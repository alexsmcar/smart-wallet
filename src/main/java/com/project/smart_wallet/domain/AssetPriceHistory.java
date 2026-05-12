package com.project.smart_wallet.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "asset_price_histories")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AssetPriceHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private BigDecimal price;

    @Setter
    private Instant collectedAt;

    @CreationTimestamp
    private Instant createdAt;

    @Setter
    @ManyToOne
    @JoinColumn(name = "asset_id")
    private Asset asset;
}
