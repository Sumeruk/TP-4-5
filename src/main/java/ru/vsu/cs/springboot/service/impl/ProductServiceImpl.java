package ru.vsu.cs.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.cs.springboot.DTO.ProductIdNameDTO;
import ru.vsu.cs.springboot.DTO.ProductWithAmountDTO;
import ru.vsu.cs.springboot.entity.Product;
import ru.vsu.cs.springboot.repository.ProductRepository;
import ru.vsu.cs.springboot.service.ProductService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product add(Product product) {
        try {
            product.setQuantity(0);
            return productRepository.save(product);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Product update(Product product) {
        try {
            return productRepository.save(product);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public void delete(String id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product getById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByProvider(String provider) {
        return productRepository.findByProvider(provider);
    }

    @Override
    public List<Product> getProductsByName(String name) {
        try {
            return productRepository.findByName(name);
        } catch (Exception ex){
            return null;
        }
    }

    @Override
    public List<Product> getProductsByParameter(String parameter) {
        try {
            return productRepository.findProductsByNameContainingOrProviderContainingOrDescriptionContaining(parameter,
                    parameter, parameter);
        } catch (Exception e){
            return null;
        }
    }

    @Override
    public Product updateProductAmount(ProductWithAmountDTO productAmount) {
        Product requiredProduct = productRepository.findById(productAmount.getId()).orElse(null);

        if (requiredProduct == null)
            return null;

        int amount = requiredProduct.getQuantity();
        if (productAmount.getAmount() > 0) {
            int newAmount = amount + productAmount.getAmount();
            requiredProduct.setQuantity(newAmount);
        } else {
            return null;
        }

        try {
            requiredProduct = productRepository.save(requiredProduct);
            return requiredProduct;
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Product update(String id, Product entity) {
        try {
            productRepository.deleteById(id);
            return productRepository.save(entity);
        } catch (Exception ex) {
            return null;
        }

    }

    @Override
    public List<ProductIdNameDTO> getProductsForSearch() {
        try {
            List<Product> allProducts = productRepository.findAll();
            List<ProductIdNameDTO> productsForSearch = new ArrayList<>();

            for (Product product: allProducts) {
                productsForSearch.add(new ProductIdNameDTO(product.getId(), product.getName()));
            }

            return productsForSearch;
        } catch (Exception ex){
            return null;
        }

    }
}