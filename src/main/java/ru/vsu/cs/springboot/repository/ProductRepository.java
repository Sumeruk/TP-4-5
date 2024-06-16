package ru.vsu.cs.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.springboot.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findByProvider(String provider);

    List<Product> findByName(String name);

    List<Product> findProductsByNameContainingOrProviderContainingOrDescriptionContaining
            (String name, String provider, String description);

}
