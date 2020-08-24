package com.cars24.biddingsystem.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "user_auction_info")
public class UserAuctionInfo implements Serializable {
    @Id
    private Long id;
    @Column(name = "user_token")
    private String userToken;
    @ManyToMany
    private AuctionDetails auctionDetails;
    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;
    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;
    @Column(name = "created_by")
    private String created_by;
    @Column(name = "updated_by")
    private String updatedBy;
    @Version
    private int version;

}
