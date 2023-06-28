package com.example.paymentservice.repository;

import com.example.paymentservice.model.CardTransferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardTransferRepository extends JpaRepository<CardTransferEntity, Long> {
}