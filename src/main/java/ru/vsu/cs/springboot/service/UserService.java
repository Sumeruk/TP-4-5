package ru.vsu.cs.springboot.service;

import ru.vsu.cs.springboot.entity.User;

import java.util.List;

public interface UserService extends Service<User, Integer>{
    User getPersonByEmail(String email);

    User getPersonByName(String Name);

    boolean registration(User userDto);

    boolean updatePassword(Integer id, String newPassword);

    boolean updatePersonData(User userDto);

    boolean login(User userDto);

    List<User> getUsersByParameter(String parameter);

    User saveUser(User newUser);
}
