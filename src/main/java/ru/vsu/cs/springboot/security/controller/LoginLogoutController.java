package ru.vsu.cs.springboot.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vsu.cs.springboot.security.DTO.AuthenticationRequest;
import ru.vsu.cs.springboot.security.DTO.AuthenticationResponse;
import ru.vsu.cs.springboot.security.service.LoginLogoutService;

@RestController
@RequestMapping("/api/auth")
public class LoginLogoutController {

    @Autowired
    private LoginLogoutService loginLogoutService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> loginUser(@RequestBody AuthenticationRequest userRequest) {

        AuthenticationResponse resp = loginLogoutService.login(userRequest);

        if (resp.getToken().equals("0") || resp.getRole().equals("0")){
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logoutUser(@RequestBody int userId){

        if(loginLogoutService.logout(userId)){

            return ResponseEntity.ok("logout successful");
        } else {

            return ResponseEntity.badRequest().body("Cannot set status");
        }
    }
}
