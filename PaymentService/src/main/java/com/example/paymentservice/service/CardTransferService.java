package com.example.paymentservice.service;

import com.example.paymentservice.dto.CardTransferDto;

import java.util.List;

public interface CardTransferService {

    List<CardTransferDto> readAll();

    List<CardTransferDto> readById(List<Long> ids);

    CardTransferDto findById(Long id);

    CardTransferDto save(CardTransferDto dto);

    CardTransferDto update(Long id, CardTransferDto dto);

}
