package com.zoeAcademy.models.course;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.zoeAcademy.models.product.Product;

import lombok.Data;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    private String description;

    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Course() {

    }

    public Course(Long id, String name, String description, Boolean active, Product product) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.active = active;
        this.product = product;
    }
}
