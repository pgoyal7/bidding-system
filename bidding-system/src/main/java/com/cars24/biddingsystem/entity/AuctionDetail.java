package com.cars24.biddingsystem.entity;

import com.cars24.biddingsystem.enums.AuctionState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.checkerframework.common.aliasing.qual.Unique;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "auction_details")
public class AuctionDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Unique
    @Column(name = "item_code")
    private String ItemCode;
    @Column(name = "step_rate")
    private BigDecimal stepRate;
    @Column(name = "minimum_base_rate")
    private BigDecimal minBaseRate;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private AuctionState state;
    @Column(name = "current_bid_rate")
    private BigDecimal currentBidRate;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "updated_by")
    private String updatedBy;
    @Version
    private String version;
}
