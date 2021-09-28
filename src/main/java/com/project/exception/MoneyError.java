package com.project.exception;

public class MoneyError extends RuntimeException{

    public MoneyError(String errorMessage) {
        super(errorMessage);
    }
}
