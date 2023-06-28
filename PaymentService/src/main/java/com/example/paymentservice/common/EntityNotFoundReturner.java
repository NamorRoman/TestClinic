package com.example.paymentservice.common;


import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class EntityNotFoundReturner {

    public EntityNotFoundException getEntityNotFoundException(String message, Long id) {
        return new EntityNotFoundException(message + id);
    }
}
