package ru.vsu.cs.springboot.service;

import ru.vsu.cs.springboot.DTO.ProductIdNameDTO;
import ru.vsu.cs.springboot.DTO.ProductWithAmountDTO;
import ru.vsu.cs.springboot.entity.Product;

import java.util.List;

public interface ProductService extends Service<Product, String> {

    List<Product> getProductsByProvider(String provider);

    List<Product> getProductsByName(String name);

    List<Product> getProductsByParameter(String parameter);

    Product updateProductAmount(ProductWithAmountDTO productAmount);
    Product update(String id, Product entity);

    List<ProductIdNameDTO> getProductsForSearch();
}
