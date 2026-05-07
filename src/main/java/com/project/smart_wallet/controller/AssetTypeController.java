package com.project.smart_wallet.controller;

import com.project.smart_wallet.dto.request.CreateAssetTypeRequest;
import com.project.smart_wallet.dto.response.CreateAssetTypeResponse;
import com.project.smart_wallet.service.AssetTypeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/asset-types")
@RequiredArgsConstructor
public class AssetTypeController {

    private final AssetTypeService assetTypeService;

    // somente ADMIN
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public CreateAssetTypeResponse createAssetType(@Valid @RequestBody CreateAssetTypeRequest request) {
        return assetTypeService.create(request);
    }
}
