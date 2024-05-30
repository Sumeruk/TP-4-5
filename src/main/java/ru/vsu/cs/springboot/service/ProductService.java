package ru.vsu.cs.springboot.service;

import ru.vsu.cs.springboot.entity.Product;

import java.util.List;

public interface ProductService extends Service<Product, Integer> {

    List<Product> getProductsByProvider(String provider);

    List<Product> getProductsByName(String name);
}