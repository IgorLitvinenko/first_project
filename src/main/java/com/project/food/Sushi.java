package com.project.food;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Sushi extends Food{
    private String name;
    private BigDecimal cost = BigDecimal.valueOf(700);

    @Override
    public String toString() {
        return "Sushi";
    }
}
