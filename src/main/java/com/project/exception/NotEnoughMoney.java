package com.project.exception;

public class NotEnoughMoney extends RuntimeException{

    public NotEnoughMoney(String errorMessage) {
        super(errorMessage);
    }
}
