package ru.vsu.cs.springboot.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.springboot.security.entity.UserAuth;

import java.util.Optional;


public interface UserAuthRepository extends JpaRepository<UserAuth, Integer> {

    Optional<UserAuth> findByUsername(String username);

}
