package com.project.smart_wallet.repository;

import com.project.smart_wallet.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
