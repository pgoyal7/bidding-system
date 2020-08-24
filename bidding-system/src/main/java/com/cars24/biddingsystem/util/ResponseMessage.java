package com.cars24.biddingsystem.util;

import lombok.Getter;

@Getter
public enum MessageMapping {
    BID_ACCEPTED("M0001", "Bid is accepted"),
    BID_REJECTED("M0002", "Bid is rejected"),
    AUCTION_NOT_FOUND("M0003", "Auction not found"),
    SUCCESS("M0004", "SUCCESS"),
    FAILURE("M0005", "FAILURE");

    private String code;
    private String message;

    MessageMapping(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
