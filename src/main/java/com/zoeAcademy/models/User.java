package com.zoeAcademy.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

// import lombok.Data;

@Entity
// @Data
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private String phone;

    private String cpf;

    private String cep;

    private String address;

    private Integer numberAdress;

    private String complement;

    private String district;

    private String city;

    private String state;

    private String email;

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
