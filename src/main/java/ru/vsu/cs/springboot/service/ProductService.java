package ru.vsu.cs.springboot.service;

import ru.vsu.cs.springboot.DTO.ProductFromDeliveryDTO;
import ru.vsu.cs.springboot.entity.Product;

import java.util.List;

public interface ProductService extends Service<Product, String> {

    List<Product> getProductsByProvider(String provider);

    List<Product> getProductsByName(String name);

    List<Product> getProductsByParameter(String parameter);

    Product increaseProductAmount(ProductFromDeliveryDTO productAmount);
    Product update(String id, Product entity);
}
