package ru.vsu.cs.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.springboot.DTO.UserInfoDTO;
import ru.vsu.cs.springboot.entity.User;
import ru.vsu.cs.springboot.repository.UserRepository;
import ru.vsu.cs.springboot.service.UserService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/boss/employersAnalytics/{dateStart}/{dateEnd}")
    public ResponseEntity<?> getEmployersAnalytics(@PathVariable String dateStart, @PathVariable String dateEnd){
        try {
            return ResponseEntity.ok(userRepository.employersAnalytics(Date.valueOf(dateStart), Date.valueOf(dateEnd)));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("wrong parameters");
        }
    }

    @GetMapping("/adm/allEmployers")
    public ResponseEntity<List<UserInfoDTO>> getAllEmployers(){
        List<UserInfoDTO> allUsers = userService.getAll();
        if(allUsers != null){
            return ResponseEntity.ok(allUsers);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @GetMapping("/adm/edit/{employerId}")
    public ResponseEntity<UserInfoDTO> getEmployer(@PathVariable int employerId){
        UserInfoDTO user = userService.getById(employerId);
        if (user != null)
            return ResponseEntity.ok(user);
        else
            return ResponseEntity.notFound().build();
    }

    @GetMapping("/adm/allEmployers/search")
    public ResponseEntity<List<UserInfoDTO>> getEmployersByParameter(@RequestParam String parameters){
        List<UserInfoDTO> foundProducts = userService.getUsersByParameter(parameters);
        if(foundProducts != null) {
            return ResponseEntity.ok(foundProducts);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/adm/create")
    public ResponseEntity<?> createUser(@RequestBody UserInfoDTO user){
        User savedUser = userService.add(user);

        if(savedUser != null){
            return ResponseEntity.ok("Successful create user");
        } else {
            return ResponseEntity.badRequest().body(new User());
        }
    }

    @PutMapping("/adm/update/{employerId}")
    public ResponseEntity<String> updateUser(@PathVariable Integer employerId, @RequestBody UserInfoDTO user){
        User updatedUser = userService.add(user);
        if(updatedUser != null){
            return ResponseEntity.ok("User updated");
        } else {
            return ResponseEntity.badRequest().body("Cannot update a user");
        }
    }

    @DeleteMapping("/adm/delete/{employerId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer employerId){
        userService.delete(employerId);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/boss/getEmployersForJob")
    public ResponseEntity<List<UserInfoDTO>> getEmployersForJob(){

        List<UserInfoDTO> freeEmployers = userService.getEmployersForJob();
        return ResponseEntity.ok(Objects.requireNonNullElseGet(freeEmployers, ArrayList::new));
    }

    @PutMapping("/boss/makeEmployerWorking/{employerId}")
    public ResponseEntity<String> makeEmployerWorking(@PathVariable int employerId){
        boolean result = userService.makeEmployerWorking(employerId);
        if(result){
            return ResponseEntity.ok("made employer working");
        } else  {
            return ResponseEntity.ok("cannot make employer working");
        }
    }


}
