package com.cars24.biddingsystem.repository;

import com.cars24.biddingsystem.entity.UserAuctionInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuctionInfoRepository extends PagingAndSortingRepository<UserAuctionInfo, Long> {
}
