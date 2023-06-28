package com.example.paymentservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "card_transfer")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CardTransferEntity {

    @Id
    @Column
    Long id;

    @Column(name = "target_account")
    String targetAccount;

    @Column(name = "amount")
    BigDecimal amount;

}
