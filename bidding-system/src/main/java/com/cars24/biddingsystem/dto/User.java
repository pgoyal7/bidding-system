package com.cars24.biddingsystem.broadcast;

import com.cars24.biddingsystem.entity.AuctionDetails;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Setter
@Getter
@Slf4j
public class User {
    private String userToken;

    public User(String userToken) {
        this.userToken = userToken;
    }

    public void update(Object details) {
        AuctionDetails auctionDetails = (AuctionDetails)details;
        log.info("Item code : {} is now ");
    }
}
