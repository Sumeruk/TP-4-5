package ru.vsu.cs.springboot.repository;

import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.springboot.entity.Order;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByLoaderId(int loaderId);

    List<Order> findByStatus(String status);

    List<Order> findByShopId(int shopId);

    Order findOrderByStatus(String status, Limit limit);

    List<Order> findByStatusAndLoaderId(String status, int loaderId);
}
