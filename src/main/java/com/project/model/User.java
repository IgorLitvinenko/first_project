package com.project.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.exception.NotEnoughMoney;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "balance")
    private BigDecimal balance = BigDecimal.valueOf(10000);

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<UserOrder> orderHistory = new ArrayList<>();

    public void setBalance(BigDecimal balance) {
        if (balance.intValue() >= 0) {
            this.balance = balance;
        }
        if (balance.intValue() < 0) {
            throw new NotEnoughMoney("Not enough money, balance : " + getBalance());
        }
    }
}

