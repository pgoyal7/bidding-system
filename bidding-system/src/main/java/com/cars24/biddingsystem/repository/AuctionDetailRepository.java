package com.cars24.biddingsystem.repository;

import com.cars24.biddingsystem.entity.AuctionDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionDetailRepository extends CrudRepository<AuctionDetails, Long> {
}
