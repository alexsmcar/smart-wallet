package com.project.smart_wallet.dto.response;

import java.time.LocalDateTime;

public record RegisterResponse(Long id, String username, LocalDateTime createdAt) {
}
