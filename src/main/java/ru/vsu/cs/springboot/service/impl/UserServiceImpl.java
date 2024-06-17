package ru.vsu.cs.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import ru.vsu.cs.springboot.entity.User;
import ru.vsu.cs.springboot.repository.UserRepository;
import ru.vsu.cs.springboot.service.UserService;

import java.util.List;

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
    public boolean login(User userDto) {
        // Authenticate the user and start a session or similar
        // This could involve checking the provided credentials against stored values
        return false; // Placeholder return value
    }

    @Override
    public User add(User newUser) {
        try {
            newUser.setStatus(-1);
            return userRepository.save(newUser);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public User update(User entity) {
        try {
            return userRepository.save(entity);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getById(Integer id) {
        try {
            return userRepository.findById(id).orElse(null);
        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public List<User> getAll() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<User> getUsersByParameter(String parameter) {
        try {
            return userRepository.
                    findUsersByNameContainingOrSurnameContainingOrEmailContainingOrRoleContaining
                            (parameter, parameter, parameter, parameter);
        } catch (IllegalArgumentException | DataAccessException ex) {
            return null;
        }
    }

    //TOD ATTENTION ATTENTION!!!!!!!!!!! -1 -> 0

    @Override
    public List<User> getEmployersForJob() {
        try {
            return userRepository.findByStatusEqualsAndRole(-1, "Кладовщик");
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
