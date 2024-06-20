package ru.vsu.cs.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.springboot.entity.User;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByName(String name);

    List<User> findUsersByNameContainingOrSurnameContainingOrEmailContainingOrRoleContaining
            (String name, String surname, String email, String role);

    List<User> findByStatusEqualsAndRole(int status, String role);

    Optional<User> findByEmail(String email);

    @Query(value =
            "SELECT u.name as \"name\", u.surname as \"surname\", " +
                    "count(op.productId) as \"position_amount\", sum(op.amount) as \"all_amount\"" +
                    "FROM Users u JOIN Orders o ON u.id = o.loaderId " +
                    "JOIN Order_Product op ON o.id = op.orderId " +
                    "WHERE o.date BETWEEN ?1 AND ?2 " +
                    "group by u.id"
            ,
            nativeQuery = true)
    List<Map<String, Object>> employersAnalytics(Date start, Date end);
}