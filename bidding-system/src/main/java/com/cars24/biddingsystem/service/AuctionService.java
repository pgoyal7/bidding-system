package com.cars24.biddingsystem.service;

import com.cars24.biddingsystem.dto.PaginationInfo;
import com.cars24.biddingsystem.dto.PlaceBidRequest;
import com.cars24.biddingsystem.dto.RunningAuctionResponse;
import com.cars24.biddingsystem.dto.SortInfo;
import com.cars24.biddingsystem.enums.AuctionState;

public interface AuctionService {
    boolean placeBid(final String itemCode, final PlaceBidRequest bidRequest, final String userToken);
    RunningAuctionResponse getAllRunningAuctions(final AuctionState auctionState, final PaginationInfo paginationInfo,
                                                 final SortInfo sortInfo);
}
