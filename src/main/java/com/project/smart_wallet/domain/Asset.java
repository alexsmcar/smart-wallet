package com.project.smart_wallet.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "assets")
public class Asset {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String name;

    @Setter
    private String symbol;

    @Setter
    private String logoUrl;

    @Setter
    private BigDecimal interestRate;

    @Enumerated(EnumType.STRING)
    @Setter
    private InterestRatePeriod interestRatePeriod;

    @CreationTimestamp
    private Instant createdAt;

    @ManyToOne
    @JoinColumn(name = "asset_type_id")
    @Setter
    private AssetType assetType;

    @OneToMany(mappedBy = "asset", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AssetPriceHistory> assetPriceHistories;


    public Asset(
            String name,
            String symbol,
            String logoUrl,
            BigDecimal interestRate,
            InterestRatePeriod interestRatePeriod,
            AssetType assetType
    ) {
        this.name = name;
        this.symbol = symbol;
        this.logoUrl = logoUrl;
        this.interestRate = interestRate;
        this.interestRatePeriod = interestRatePeriod;
        this.assetType = assetType;
    }
}
