package com.github.s_places.demoapi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class Person {

    @Id
    private int id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String patronymic;
    @Column
    private String phone;
    @Column
    private String email;
}
