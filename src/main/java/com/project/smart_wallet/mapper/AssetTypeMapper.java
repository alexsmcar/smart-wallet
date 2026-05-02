package com.project.smart_wallet.mapper;

import com.project.smart_wallet.domain.AssetType;
import com.project.smart_wallet.dto.request.AssetTypeRequest;
import com.project.smart_wallet.dto.response.AssetTypeResponse;

public class AssetTypeMapper {

    public static AssetType toEntity(AssetTypeRequest request) {
        return new AssetType(request.name(), request.incomeGenerating());
    }

    public static AssetTypeResponse toResponse(AssetType entity) {
        return new AssetTypeResponse(entity.getId(), entity.getName(), entity.getIncomeGenerating(),
                entity.getCreatedAt());
    }
}
