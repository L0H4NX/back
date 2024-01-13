package com.zoeAcademy.repository.User.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zoeAcademy.models.product.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
