package ru.vsu.cs.springboot.security.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import ru.vsu.cs.springboot.entity.User;
import ru.vsu.cs.springboot.repository.UserRepository;
import ru.vsu.cs.springboot.security.DTO.AuthenticationRequest;
import ru.vsu.cs.springboot.security.DTO.AuthenticationResponse;
import ru.vsu.cs.springboot.security.repository.UserAuthRepository;

import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class LoginLogoutService {

    @Autowired
    private UserAuthRepository userAuthRepository;

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) throws UsernameNotFoundException {
        Optional<User> userFromRequest = userRepository.findByEmail(authenticationRequest.getEmail());

        if (userFromRequest.isPresent()) {
            if (userFromRequest.get().getPassword() == null) {

                userFromRequest.get().setPassword(passwordEncoder.encode(authenticationRequest.getPassword()));
                userFromRequest.get().setStatus(0);

                userRepository.save(userFromRequest.get());
                //System.out.println("DEBUG------ пользователь" + userFromRequest.get());

                var jwtToken = jwtService.generateToken(userFromRequest.get());


                //System.out.println("DEBUG------RESPONSE " + AuthenticationResponse.builder()
//                        .token(jwtToken)
//                        .role(userFromRequest.get().getRole())
//                        .id(userFromRequest.get().getId())
//                        .build());

                return AuthenticationResponse.builder()
                        .token(jwtToken)
                        .role(userFromRequest.get().getRole())
                        .id(userFromRequest.get().getId())
                        .build();
            } else {
                try {
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(
                                    authenticationRequest.getEmail(),
                                    authenticationRequest.getPassword()
                            ));


                    userFromRequest.get().setStatus(0);

                    userRepository.save(userFromRequest.get());

                    //System.out.println("DEBUG------ существующий пользователь" + userFromRequest.get());

                    var jwtToken = jwtService.generateToken(userFromRequest.get());

                    //System.out.println("DEBUG-----new token " + jwtToken);
                    return AuthenticationResponse.builder()
                            .token(jwtToken)
                            .role(userFromRequest.get().getRole())
                            .id(userFromRequest.get().getId())
                            .build();
                } catch (AuthenticationException exception){
                    return new AuthenticationResponse("0", 0, "0");
                }

            }
        } else {
            return new AuthenticationResponse("0", 0, "0");
        }

    }

    public boolean logout(int userId){
        try {
            User user = userRepository.getReferenceById(userId);
            user.setStatus(-1);
            userRepository.save(user);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
