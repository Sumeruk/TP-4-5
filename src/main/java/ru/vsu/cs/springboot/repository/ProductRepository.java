package ru.vsu.cs.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.springboot.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
