package ru.vsu.cs.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.springboot.entity.User;
import ru.vsu.cs.springboot.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private UserService userService;

    @GetMapping("/allEmployers")
    public ResponseEntity<List<User>> getAllEmployers(){
        List<User> allUsers = userService.getAll();
        if(allUsers != null){
            return ResponseEntity.ok(allUsers);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
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
        List<User> foundProducts = userService.getUsersByParameter(parameters);
        if(foundProducts != null) {
            return ResponseEntity.ok(foundProducts);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.add(user);

        if(savedUser != null){
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.badRequest().body(new User());
        }
    }

    @PutMapping("/update/{employerId}")
    public ResponseEntity<String> updateUser(@PathVariable Integer employerId, @RequestBody User user){
        User updatedUser = userService.add(user);
        if(updatedUser != null){
            return ResponseEntity.ok("User updated");
        } else {
            return ResponseEntity.badRequest().body("Cannot update a user");
        }
    }

    @DeleteMapping("/delete/{employerId}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer employerId){
        userService.delete(employerId);
        return ResponseEntity.ok("Deleted");
    }

    @GetMapping("/getEmployersForJob")
    public ResponseEntity<List<User>> getEmployersForJob(){
        List<User> freeEmployers = userService.getEmployersForJob();
        return ResponseEntity.ok(Objects.requireNonNullElseGet(freeEmployers, ArrayList::new));
    }

    @PutMapping("makeEmployerWorking/{employerId}")
    public ResponseEntity<String> makeEmployerWorking(@PathVariable int employerId){
        boolean result = userService.makeEmployerWorking(employerId);
        if(result){
            return ResponseEntity.ok("made employer working");
        } else  {
            return ResponseEntity.ok("cannot make employer working");
        }
    }


}
