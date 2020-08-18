package com.cars24.biddingsystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/auction")
public class AuctionController {

    @PostMapping("")
    public void placeBid() {

    }

    @GetMapping("")
    public void getAllRunningAuction() {

    }
}
