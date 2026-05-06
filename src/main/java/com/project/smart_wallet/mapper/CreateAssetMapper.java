package com.project.smart_wallet.mapper;

import com.project.smart_wallet.domain.Asset;
import com.project.smart_wallet.domain.AssetType;
import com.project.smart_wallet.dto.request.CreateAssetRequest;
import com.project.smart_wallet.dto.response.CreateAssetResponse;

public class CreateAssetMapper {

    public static Asset toEntity(CreateAssetRequest request, AssetType assetType) {
        return new Asset(
                request.name(),
                request.symbol(),
                request.logoUrl(),
                request.interestRate(),
                request.interestRatePeriod(),
                assetType
        );
    }

    public static CreateAssetResponse toResponse(Asset entity) {
        return new CreateAssetResponse(
                entity.getId(),
                entity.getName(),
                entity.getSymbol(),
                entity.getLogoUrl(),
                entity.getInterestRate(),
                entity.getInterestRatePeriod(),
                entity.getCreatedAt()
        );
    }
}
