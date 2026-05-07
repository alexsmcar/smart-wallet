package com.project.smart_wallet.mapper;

import com.project.smart_wallet.domain.AssetType;
import com.project.smart_wallet.dto.request.CreateAssetTypeRequest;
import com.project.smart_wallet.dto.response.CreateAssetTypeResponse;

public class CreateAssetTypeMapper {

    public static AssetType toEntity(CreateAssetTypeRequest request) {
        return new AssetType(request.name(), request.incomeGenerating());
    }

    public static CreateAssetTypeResponse toResponse(AssetType entity) {
        return new CreateAssetTypeResponse(
                entity.getId(),
                entity.getName(),
                entity.getIncomeGenerating(),
                entity.getCreatedAt());
    }
}
