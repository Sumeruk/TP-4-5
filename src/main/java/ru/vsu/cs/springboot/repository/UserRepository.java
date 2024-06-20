package ru.vsu.cs.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vsu.cs.springboot.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByName(String name);

    List<User> findUsersByNameContainingOrSurnameContainingOrEmailContainingOrRoleContaining
            (String name, String surname, String email, String role);

    List<User> findByStatusEqualsAndRole(int status, String role);

    Optional<User> findByEmail(String email);
}