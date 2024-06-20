package ru.vsu.cs.springboot.repository;

import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.springboot.entity.Order;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByLoaderId(int loaderId);

    List<Order> findByStatus(String status);

    List<Order> findByShopId(int shopId);

    Order findOrderByStatus(String status, Limit limit);

    List<Order> findByStatusAndLoaderId(String status, int loaderId);

    @Query(
            value = "SELECT o.id as \"orderId\" , u1.name as \"shop\", u2.name \"empl_name\", " +
                    "u2.surname as \"empl_surname\", u2.phone as \"phone\", o.date as \"date\", " +
                    "count(p.id) as \"numb_prod_items\", " +
                    "sum(op.amount) as \"prod_amount\", " +
                    "sum(op.amount * p.price) as \"cost\" " +
                    "FROM Orders o JOIN Users u1 ON o.shopId = u1.id " +
                    "JOIN Users u2 ON o.loaderId = u2.id " +
                    "JOIN Order_Product op  ON o.id = op.orderId " +
                    "JOIN Products p ON op.productId = p.id " +
                    "WHERE o.date BETWEEN ?1 AND ?2 " +
                    "group by o.id"
            ,
            nativeQuery = true
    )
    List<Map<String, Object>> orderAnalytic(Date start, Date end);

    @Query(
            value = "SELECT o.id as \"orderId\" , u1.name as \"shop\", u2.name \"empl_name\", " +
                    "u2.surname as \"empl_surname\", u2.phone as \"phone\", " +
                    "p.name as \"prod_name\", " +
                    "op.amount as \"prod_amount\", o.date as \"date\" " +
                    "FROM Orders o JOIN Users u1 ON o.shopId = u1.id " +
                    "JOIN Users u2 ON o.loaderId = u2.id " +
                    "JOIN Order_Product op  ON o.id = op.orderId " +
                    "JOIN Products p ON op.productId = p.id " +
                    "WHERE o.date = ?1 " +
                    "group by o.id"
            ,
            nativeQuery = true
    )
    List<Map<String, Object>> dateAnalytic(Date date);
}
