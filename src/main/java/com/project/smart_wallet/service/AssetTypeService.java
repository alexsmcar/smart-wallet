package com.project.smart_wallet.service;

import com.project.smart_wallet.domain.AssetType;
import com.project.smart_wallet.dto.request.CreateAssetTypeRequest;
import com.project.smart_wallet.dto.response.CreateAssetTypeResponse;
import com.project.smart_wallet.exceptions.custom.ConflictException;
import com.project.smart_wallet.repository.AssetTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.project.smart_wallet.mapper.CreateAssetTypeMapper.toEntity;
import static com.project.smart_wallet.mapper.CreateAssetTypeMapper.toResponse;

@Service
@RequiredArgsConstructor
public class AssetTypeService {

    private final AssetTypeRepository assetTypeRepository;

    public CreateAssetTypeResponse create(CreateAssetTypeRequest request) {
        if (assetTypeRepository.findByName(request.name()).isPresent()) {
            throw new ConflictException("AssetType já cadastrado");
        }

        AssetType assetType = toEntity(request);

        assetTypeRepository.save(assetType);

        return toResponse(assetType);
    }
}
