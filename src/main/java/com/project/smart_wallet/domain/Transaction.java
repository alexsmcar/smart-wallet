package com.project.smart_wallet.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal quantity;

    private BigDecimal price;

    private LocalDateTime transactionAt;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private TranscationType type;

    @ManyToOne
    @JoinColumn(name = "user.id")
    private User user;
}
