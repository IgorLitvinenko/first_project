package com.project.model;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.exception.MoneyError;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Entity
@NoArgsConstructor
@Table(name = "`order`")
public class Order {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @Column(name = "order_name")
    private String orderName;

    @Column(name = "cost")
    private BigDecimal cost;

    public void setCost(BigDecimal cost) {
        if (cost.intValue() >= 0) {
            this.cost = cost;
        }
        if (cost.intValue() < 0) {
            throw new MoneyError("Cost can't be negative");
        }
    }
}

