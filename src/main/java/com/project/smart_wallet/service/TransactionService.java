package com.project.smart_wallet.service;

import com.project.smart_wallet.domain.Asset;
import com.project.smart_wallet.domain.Transaction;
import com.project.smart_wallet.domain.User;
import com.project.smart_wallet.dto.request.CreateTransactionRequest;
import com.project.smart_wallet.dto.response.CreateTransactionResponse;
import com.project.smart_wallet.exceptions.custom.ConflictException;
import com.project.smart_wallet.exceptions.custom.NotFoundException;
import com.project.smart_wallet.repository.AssetRepository;
import com.project.smart_wallet.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.project.smart_wallet.mapper.CreateTransactionMapper.toEntity;
import static com.project.smart_wallet.mapper.CreateTransactionMapper.toResponse;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final TransactionRepository transactionRepository;

    private final AssetRepository assetRepository;

    private final UserService userService;

    public CreateTransactionResponse createTransaction(CreateTransactionRequest request) {
        User user = userService.getAuthenticatedUser();
        Asset asset = assetRepository.findById(request.assetId())
                .orElseThrow(() -> new NotFoundException("Asset não encontrado"));

        Transaction transaction = toEntity(request, user, asset);

        transactionRepository.save(transaction);

        return toResponse(transaction);
    }
}
