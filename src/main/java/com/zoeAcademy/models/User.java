package com.zoeAcademy.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String lastName;

    @NotNull
    private String phone;

    @NotNull
    private String cpf;

    @NotNull
    private String cep;

    @NotNull
    private String address;

    @NotNull
    private Integer numberAdress;

    @NotNull
    private String complement;

    @NotNull
    private String district;

    @NotNull
    private String city;

    @NotNull
    private String state;

    @NotNull
    private String email;

    @NotNull
    private String password;

    public User() {

    }

    public User(String name, String lastName, String phone, String cpf, String cep, String address,
            Integer numberAdress,
            String complement, String district, String city, String state, String email, String password) {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.cpf = cpf;
        this.cep = cep;
        this.address = address;
        this.numberAdress = numberAdress;
        this.complement = complement;
        this.district = district;
        this.city = city;
        this.state = state;
        this.email = email;
        this.password = password;
    }
}
