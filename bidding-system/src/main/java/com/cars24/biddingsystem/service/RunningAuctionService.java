package com.cars24.biddingsystem.broadcast;

import com.cars24.biddingsystem.entity.AuctionDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RunningAuction {
    private AuctionDetails auctionDetails;
    private List<User> userList = new ArrayList<>();

    public void addUser(User user) {
        this.userList.add(user);
    }

    public void removeUser(User user) {
        this.userList.remove(user);
    }

    public void setAuctionDetails(AuctionDetails auctionDetails) {
        this.auctionDetails = auctionDetails;
        for(User user : userList) {
            user.update(auctionDetails);
        }
    }
}
