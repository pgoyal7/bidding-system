package com.cars24.biddingsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SearchRunningAuctionResponse {
    private List<AuctionInfo> auctionInfoList;
    private Long totalAvailableAuctions;
}
