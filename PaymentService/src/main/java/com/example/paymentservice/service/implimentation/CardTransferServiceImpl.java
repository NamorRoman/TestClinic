package com.example.paymentservice.service.implimentation;

import com.example.paymentservice.common.EntityNotFoundReturner;
import com.example.paymentservice.dto.CardTransferDto;
import com.example.paymentservice.mapper.CardTransferMapper;
import com.example.paymentservice.model.CardTransferEntity;
import com.example.paymentservice.repository.CardTransferRepository;
import com.example.paymentservice.service.CardTransferService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CardTransferServiceImpl implements CardTransferService {

    static String msg = "Не найден перевод с id ";

    CardTransferRepository repository;
    CardTransferMapper mapper;

    EntityNotFoundReturner notFoundReturner;

    @Override
    public List<CardTransferDto> readAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public List<CardTransferDto> readById(List<Long> ids) {
        var resultList = ids.stream().map(id -> repository.findById(id)
                .orElseThrow(() -> notFoundReturner.getEntityNotFoundException(msg, id))).toList();

        return mapper.toDtoList(resultList);
    }

    @Override
    public CardTransferDto findById(Long id) {
        return mapper.toDto(repository.findById(id)
                .orElseThrow(() -> notFoundReturner.getEntityNotFoundException(msg, id)));
    }

    @Override
    public CardTransferDto save(CardTransferDto dto) {
        return mapper.toDto(repository.save(mapper.toEntity(dto)));
    }

    @Override
    public CardTransferDto update(Long id, CardTransferDto dto) {

        var targetEntity = repository.findById(id)
                .orElseThrow(() -> notFoundReturner.getEntityNotFoundException(msg, id));

        return mapper.toDto(mapper.mergeToEntity(dto, targetEntity));
    }
}
