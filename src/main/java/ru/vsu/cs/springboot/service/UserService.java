package ru.vsu.cs.springboot.service;

import ru.vsu.cs.springboot.DTO.UserInfoDTO;
import ru.vsu.cs.springboot.entity.User;

import java.util.List;

public interface UserService {
    User add(User entity);

    User update(UserInfoDTO entity);

    void delete(Integer id);

    UserInfoDTO getById(Integer id);

    List<UserInfoDTO> getAll();

    User add(UserInfoDTO entity);
    User getPersonByEmail(String email);

    User getPersonByName(String Name);

    boolean registration(User userDto);

    boolean updatePassword(Integer id, String newPassword);

    boolean updatePersonData(User userDto);

    List<UserInfoDTO> getUsersByParameter(String parameter);

    List<UserInfoDTO> getEmployersForJob();

    boolean makeEmployerWorking(int employerId);
}
