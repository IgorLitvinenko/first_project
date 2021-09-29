package com.project.model;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.project.exception.MoneyError;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;
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

    @OneToMany(mappedBy="user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserOrder> userOrder;

    public void setBalance(BigDecimal balance) {
        if (balance.intValue() >= 0) {
            this.balance = balance;
        }
        if (balance.intValue() < 0) {
            throw new MoneyError("Not enough money, balance : " + getBalance());
        }
    }
}

