package com.project.smart_wallet.mapper;

import com.project.smart_wallet.domain.User;
import com.project.smart_wallet.dto.response.RegisterResponse;

public class RegisterMapper {

    public static RegisterResponse toResponse(User user) {
        return new RegisterResponse(user.getId(), user.getName(), user.getEmail(), user.getCreatedAt());
    }
}
