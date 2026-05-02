package com.project.smart_wallet.controller;

import com.project.smart_wallet.dto.request.AssetTypeRequest;
import com.project.smart_wallet.dto.response.AssetTypeResponse;
import com.project.smart_wallet.service.AssetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/assets")
public class AssetController {

    private final AssetService assetService;

    // somente ADMIN
    @PostMapping("/types")
    @ResponseStatus(HttpStatus.CREATED)
    public AssetTypeResponse createAssetType(@Valid @RequestBody AssetTypeRequest request) {
        return assetService.createAssetType(request);
    }
}
