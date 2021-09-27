package com.project.food;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Seafood extends Food{
    private String name;
    private BigDecimal cost = BigDecimal.valueOf(950);

    @Override
    public String toString() {
        return "Seafood";
    }
}
