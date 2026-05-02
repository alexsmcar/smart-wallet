package com.project.smart_wallet.service;

import com.project.smart_wallet.domain.AssetType;
import com.project.smart_wallet.dto.request.AssetTypeRequest;
import com.project.smart_wallet.dto.response.AssetTypeResponse;
import com.project.smart_wallet.mapper.AssetTypeMapper;
import com.project.smart_wallet.repository.AssetTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.project.smart_wallet.mapper.AssetTypeMapper.toEntity;
import static com.project.smart_wallet.mapper.AssetTypeMapper.toResponse;

@RequiredArgsConstructor
@Service
public class AssetService {

    private final AssetTypeRepository assetTypeRepository;

    public AssetTypeResponse createAssetType(AssetTypeRequest request) {
        if (assetTypeRepository.findByName(request.name()).isPresent()) {
            throw new RuntimeException("Asset já cadastrado");
        }

        AssetType assetType = toEntity(request);

        assetTypeRepository.save(assetType);

        return toResponse(assetType);
    }
}
