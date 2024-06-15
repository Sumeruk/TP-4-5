package ru.vsu.cs.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.springboot.entity.User;
import ru.vsu.cs.springboot.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private UserService userService;

    @GetMapping("/allEmployers")
    public ResponseEntity<List<User>> getAllEmployers(){
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/edit/{employerId}")
    public ResponseEntity<User> getEmployer(@PathVariable int employerId){
        User user = userService.getById(employerId);
        if (user != null)
            return ResponseEntity.ok(user);
        else
            return ResponseEntity.notFound().build();
    }
    @GetMapping("/allEmployers/search")
    public ResponseEntity<List<User>> getEmployersByParameter(@RequestParam String parameters){
        return ResponseEntity.ok(userService.getUsersByParameter(parameters));
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.add(user);
        System.out.println(user);
        System.out.println(savedUser);

        if(savedUser != null){
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.badRequest().body(new User());
        }
    }

    @PutMapping("/edit/{employerId}")
    public ResponseEntity<String> updateUser(@PathVariable Integer employerId, @RequestBody User user){
        User updatedUser = userService.add(user);
        if(updatedUser != null){
            return ResponseEntity.ok("User updated");
        } else {
            return ResponseEntity.badRequest().body("Cannot update a user");
        }
    }


}
