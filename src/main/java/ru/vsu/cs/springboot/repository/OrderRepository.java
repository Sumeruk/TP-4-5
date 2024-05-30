package ru.vsu.cs.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.springboot.entity.Order;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByLoaderId(int loaderId);

    List<Order> findByStatus(String status);
}
