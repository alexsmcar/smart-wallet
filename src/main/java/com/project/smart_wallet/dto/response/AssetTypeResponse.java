package com.project.smart_wallet.dto.response;

import java.time.Instant;

public record AssetTypeResponse(Long id, String name, Boolean incomeGenerating, Instant createdAt) {
}
