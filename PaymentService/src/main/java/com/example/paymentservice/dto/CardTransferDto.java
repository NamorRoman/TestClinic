package com.example.paymentservice.dto;

import com.example.paymentservice.model.CardTransferEntity;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * A DTO for the {@link CardTransferEntity} entity
 */
@Data
public class CardTransferDto implements Serializable {
    private final Long id;
    private final String targetAccount;
    private final BigDecimal amount;
}