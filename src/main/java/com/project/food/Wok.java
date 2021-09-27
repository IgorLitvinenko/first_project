package com.project.food;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Wok extends Food{
    private String name;
    private BigDecimal cost = BigDecimal.valueOf(350);

    @Override
    public String toString() {
        return "Wok";
    }
}
