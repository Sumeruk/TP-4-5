package ru.vsu.cs.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vsu.cs.springboot.DTO.ProductFromDeliveryDTO;
import ru.vsu.cs.springboot.entity.Product;
import ru.vsu.cs.springboot.repository.ProductRepository;
import ru.vsu.cs.springboot.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
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
        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getProductsByParameter(String parameter) {
        return productRepository.findProductsByNameContainingOrProviderContainingOrDescriptionContaining(parameter,
                parameter, parameter);
    }

    @Override
    public Product increaseProductAmount(ProductFromDeliveryDTO productAmount) {
        Product requiredProduct = productRepository.findById(productAmount.getId()).orElse(null);

        if(requiredProduct == null)
            return null;

        int amount = requiredProduct.getQuantity();
        int newAmount = amount + productAmount.getAmount();
        requiredProduct.setQuantity(newAmount);

        try {
            requiredProduct = productRepository.save(requiredProduct);
            return requiredProduct;
        } catch (Exception ex){
            return null;
        }
    }

    @Override
    public Product update(String id, Product entity) {
        try {
            productRepository.deleteById(id);
            return productRepository.save(entity);
        } catch (Exception ex){
            return null;
        }

    }
}