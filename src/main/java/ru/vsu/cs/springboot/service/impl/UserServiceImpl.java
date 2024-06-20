package ru.vsu.cs.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import ru.vsu.cs.springboot.DTO.UserInfoDTO;
import ru.vsu.cs.springboot.entity.User;
import ru.vsu.cs.springboot.repository.UserRepository;
import ru.vsu.cs.springboot.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getPersonByEmail(String email) {
        // Implementation depends on how you store and retrieve users
        // For example, if using a database, you would query the database here
        return null; // Placeholder return value
    }

    @Override
    public User getPersonByName(String name) {
        // Similar to getPersonByEmail, but querying by name
        return null; // Placeholder return value
    }

    @Override
    public boolean registration(User userDto) {
        // Implement registration logic
        // This could involve saving the user to a database
        return false; // Placeholder return value
    }

    @Override
    public boolean updatePassword(Integer id, String newPassword) {
        // Find the user by ID and update their password
        // Again, this would typically interact with a database
        return false; // Placeholder return value
    }

    @Override
    public boolean updatePersonData(User userDto) {
        // Update existing user data
        // This might involve updating a record in a database
        return false; // Placeholder return value
    }

    @Override
    public User add(UserInfoDTO newUserFromFront) {
        try {
            User newUser = User.builder()
                    .id(newUserFromFront.getId())
                    .name(newUserFromFront.getName())
                    .surname(newUserFromFront.getSurname())
                    .email(newUserFromFront.getEmail())
                    .phone(newUserFromFront.getPhone())
                    .birthday(newUserFromFront.getBirthday())
                    .role(newUserFromFront.getRole())
                    .status(-1).build();

            return userRepository.save(newUser);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public User add(User newUser) {
        try {
            return userRepository.save(newUser);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public User update(UserInfoDTO newUserFromFront) {
        try {
            User newUser = User.builder()
                    .id(newUserFromFront.getId())
                    .name(newUserFromFront.getName())
                    .surname(newUserFromFront.getSurname())
                    .email(newUserFromFront.getEmail())
                    .phone(newUserFromFront.getPhone())
                    .birthday(newUserFromFront.getBirthday())
                    .role(newUserFromFront.getRole())
                    .status(-1).build();

            return userRepository.save(newUser);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserInfoDTO getById(Integer id) {
        try {
            return userToDTO(Objects.requireNonNull(userRepository.findById(id).orElse(null)));
        } catch (Exception ex) {
            return null;
        }
    }

    private UserInfoDTO userToDTO(User user){
        return UserInfoDTO.builder()
                .id(user.getId())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .phone(user.getPhone())
                .birthday(user.getBirthday())
                .role(user.getRole())
                .build();
    }

    private List<UserInfoDTO> listUserToDto(List<User> users){
        List<UserInfoDTO> result = new ArrayList<>();
        for (User user: users) {
            result.add(userToDTO(user));
        }
        return result;
    }

    @Override
    public List<UserInfoDTO> getAll() {
        try {
            List<User> freeUsers = userRepository.findAll();
            return listUserToDto(freeUsers);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<UserInfoDTO> getUsersByParameter(String parameter) {
        try {
            return listUserToDto(userRepository.
                    findUsersByNameContainingOrSurnameContainingOrEmailContainingOrRoleContaining
                            (parameter, parameter, parameter, parameter));
        } catch (IllegalArgumentException | DataAccessException ex) {
            return null;
        }
    }

    //TOD ATTENTION ATTENTION!!!!!!!!!!! -1 -> 0

    @Override
    public List<UserInfoDTO> getEmployersForJob() {
        try {
            System.out.println("DEBUG----КОГО ОН НЕ МОЖЕТ НАЙТИ" + userRepository.getReferenceById(2).getRole() + " " +
                    userRepository.getReferenceById(2).getStatus());
            List<User> freeUser = userRepository.findByStatusEqualsAndRole(0, "Кладовщик");
            return listUserToDto(freeUser);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean makeEmployerWorking(int employerId) {
        try {
            User workingUser = userRepository.getReferenceById(employerId);

            if (workingUser.getRole().equals("Кладовщик")) {
                workingUser.setStatus(1);
                userRepository.save(workingUser);
                return true;
            } else
                return false;
        } catch (Exception e) {
            return false;
        }
    }


}
