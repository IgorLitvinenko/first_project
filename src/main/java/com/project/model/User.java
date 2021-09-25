package com.project.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "some_people")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}
