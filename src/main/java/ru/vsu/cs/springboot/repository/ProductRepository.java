package ru.vsu.cs.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.springboot.entity.Product;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

    List<Product> findByProvider(String provider);

    List<Product> findByName(String name);

    List<Product> findProductsByNameContainingOrProviderContainingOrDescriptionContaining
            (String name, String provider, String description);

    @Query(value =
            "SELECT p.id as \"id\", p.name as \"prod_name\", u.name as \"shop\", " +
                    "sum(op.amount) as \"amount\", " +
                    "sum(op.amount * p.price) as \"cost\"" +
                    "FROM Products p join Order_Product op ON p.id = op.productId " +
                    "JOIN Orders o ON op.orderId = o.id " +
                    "JOIN Users u ON o.shopId = u.id " +
                    "WHERE o.date BETWEEN ?1 AND ?2 " +
                    "group by p.id, u.name, p.name",
            nativeQuery = true)
    List<Map<String, Object>> productAnalytics(Date start, Date end);
}
