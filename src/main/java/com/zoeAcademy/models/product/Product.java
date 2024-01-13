package com.zoeAcademy.models.product;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.zoeAcademy.models.course.Course;

import lombok.Data;

@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    private String description;

    private Boolean active;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Course> courses;

    public Product() {

    }

    public Product(String name, String description, Boolean active, List<Course> courses) {
        this.name = name;
        this.description = description;
        this.active = active;
        this.courses = courses;
    }
}
