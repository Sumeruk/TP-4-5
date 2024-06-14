package ru.vsu.cs.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.springboot.entity.Order;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findByLoaderId(int loaderId);

    List<Order> findByStatus(String status);
}
