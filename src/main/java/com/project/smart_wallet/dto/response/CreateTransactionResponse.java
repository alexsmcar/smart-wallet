package com.project.smart_wallet.dto.response;

import com.project.smart_wallet.domain.TransactionType;

import java.math.BigDecimal;
import java.time.Instant;

public record CreateTransactionResponse(
        Long id,
        BigDecimal quantity,
        BigDecimal price,
        Instant transactionAt,
        TransactionType type,
        AssetSummaryResponse asset,
        Instant createdAt
) {
}
