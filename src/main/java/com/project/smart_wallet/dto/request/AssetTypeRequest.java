package com.project.smart_wallet.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AssetTypeRequest(@NotBlank String name, @NotNull Boolean incomeGenerating) {
}
