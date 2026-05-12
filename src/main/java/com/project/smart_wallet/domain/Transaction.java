package com.project.smart_wallet.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private BigDecimal quantity;

    @Setter
    private BigDecimal price;

    @Setter
    private Instant transactionAt;

    @Setter
    @Enumerated(EnumType.STRING)
    private TranscationType type;

    @CreationTimestamp
    private Instant createdAt;

    @Setter
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
