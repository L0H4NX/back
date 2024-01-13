package com.zoeAcademy.service.User.product;

import java.util.List;

import org.springframework.stereotype.Service;

import com.zoeAcademy.models.GenericReturn;
import com.zoeAcademy.models.product.Product;
import com.zoeAcademy.repository.User.product.ProductRepository;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public GenericReturn<List<Product>> getAllProducts() {

        List<Product> products = productRepository.findAll();

        if (products.size() == 0) {
            return new GenericReturn<>(true, "Nenhum Produto Encontrado", null);
        }

        return new GenericReturn<>(true, "Produtos Encontrados com Sucesso", products);
    }

    public GenericReturn<Product> getProductById(Long id) {

        Product product = productRepository.findById(id).get();

        if (product == null) {
            return new GenericReturn<>(true, "Nenhum Produto Encontrado", null);
        }

        return new GenericReturn<>(true, "Produto Encontrado com Sucesso", product);
    }

    public GenericReturn<Product> createProduct(Product product) {

        Product newProduct = productRepository.save(product);

        return new GenericReturn<>(true, "Produto Criado com Sucesso", newProduct);
    }

    public GenericReturn<?> deleteProduct(Long id) {

        Product product = productRepository.findById(id).get();

        if (product == null) {
            return new GenericReturn<>(true, "Nenhum Produto Encontrado", null);
        }

        productRepository.deleteById(id);

        return new GenericReturn<>(true, "Produto Excluído com Sucesso", null);

    }

}
