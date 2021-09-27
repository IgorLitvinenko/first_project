package com.project.food;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.project.model.User;
import lombok.Data;
import java.math.BigDecimal;

@Data
@JsonTypeInfo( use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @Type(value = Pizza.class, name = "pizza"),
        @Type(value = Sushi.class, name = "sushi"),
        @Type(value = Seafood.class, name = "seafood"),
        @Type(value = Burger.class, name = "burger"),
        @Type(value = Wok.class, name = "wok")
})
public abstract class Food {
    private User user;
    private String name;
    private BigDecimal cost;

}
