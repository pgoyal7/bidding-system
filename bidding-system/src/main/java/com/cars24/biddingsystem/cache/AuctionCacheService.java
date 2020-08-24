package com.cars24.biddingsystem.cache;

import com.cars24.biddingsystem.entity.AuctionDetail;
import com.cars24.biddingsystem.enums.AuctionState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class AuctionCacheService {
    public static final Map<String, AuctionDetail> ITEM_WISE_AUCTION_DETAILS;

    static {
        ITEM_WISE_AUCTION_DETAILS = new ConcurrentHashMap<>();
    }

    public boolean addOrUpdateToCache(final String key, final AuctionDetail value) {
        boolean isAddedToCache = false;
        try {
            log.info("Trying to add/update new value for item code : {}", key);
            ITEM_WISE_AUCTION_DETAILS.put(key, value);
        } catch(Exception e) {
            log.error("Failed to add/update new value for item code : {} with message : {}",
                    key, e.getMessage(), e);
        }
        return isAddedToCache;
    }

    public boolean validateItemCodeMinimumBaseRateAndState(final String key, final BigDecimal bidAmount) {
        boolean isValid = false;
        log.info("Validating item code, minimum base rate and state for item code : {}", key);
        if(ITEM_WISE_AUCTION_DETAILS.containsKey(key)) {
            AuctionDetail auctionDetail = ITEM_WISE_AUCTION_DETAILS.get(key);
            if(isAuctionRunning(auctionDetail) && validateMinimumBaseRate(auctionDetail, bidAmount)) {
                isValid = true;
            }
        }
        return isValid;
    }

    public boolean validateMinimumBaseRate(final AuctionDetail auctionDetail, final BigDecimal bidAmount) {
        boolean isValid = false;
        log.info("Validating bid amount against the item code : {}", auctionDetail.getItemCode());
        if(auctionDetail.getCurrentBidRate().compareTo(bidAmount) < 0) {
            log.info("Bid amount has been successfully validated against the current bid rate for a given item code");
            isValid = true;
        }
        return isValid;
    }

    public boolean isAuctionRunning(final AuctionDetail auctionDetail) {
        boolean isAuctionRunning = false;
        log.info("Checking whether auction is running for item code : {}", auctionDetail.getItemCode());
        if(auctionDetail.getState().equals(AuctionState.RUNNING)) {
            isAuctionRunning = true;
            log.info("Auction is currently running for item code : {}", auctionDetail.getItemCode());
        }
        return isAuctionRunning;
    }
}
