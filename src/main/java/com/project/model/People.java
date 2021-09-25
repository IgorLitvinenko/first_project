package com.project.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Component
public class People {
    @Id
    @GeneratedValue
    private Long id;
    private String city;
    private String country;
    private Integer age;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
