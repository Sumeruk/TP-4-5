package ru.vsu.cs.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.springboot.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vsu.cs.springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);

    User findByName(String name);
}