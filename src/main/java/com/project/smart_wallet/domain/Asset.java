package com.project.smart_wallet.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "assets")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String symbol;

    private BigDecimal interestRate;

    private BigDecimal interestRatePeriod;

    @CreationTimestamp
    private Instant CreatedAt;

    @ManyToOne
    @JoinColumn(name = "asset_type.id")
    private AssetType assetType;

    @OneToMany(mappedBy = "asset", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AssetPriceHistory> assetPriceHistories;

}
