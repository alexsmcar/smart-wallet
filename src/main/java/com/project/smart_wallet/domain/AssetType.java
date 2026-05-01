package com.project.smart_wallet.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "asset_types")
public class AssetType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Boolean incomeGenerating;

    @CreationTimestamp
    private Instant createdAt;

    @OneToMany(mappedBy = "assetType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Asset> assets;

    public AssetType(String name, Boolean incomeGenerating) {
        this.name = name;
        this.incomeGenerating = incomeGenerating;
    }
}
