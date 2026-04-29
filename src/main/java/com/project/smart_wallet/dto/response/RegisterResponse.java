package com.project.smart_wallet.dto.response;

import java.time.Instant;

public record RegisterResponse(Long id, String username, String email, Instant createdAt) {
}
