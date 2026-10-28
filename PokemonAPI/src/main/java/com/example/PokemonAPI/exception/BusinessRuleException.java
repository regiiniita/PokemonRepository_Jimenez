package com.example.PokemonAPI.exception;

public class BusinessRuleException extends RuntimeException{

    public BusinessRuleException(String message) {
        super(message);
    }
}
