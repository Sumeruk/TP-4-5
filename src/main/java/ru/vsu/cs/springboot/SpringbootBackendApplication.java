package ru.vsu.cs.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.vsu.cs.springboot.entity.User;
import ru.vsu.cs.springboot.repository.UserRepository;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {
    // HI NIKOLAY
	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user1 = User.builder()
				.name("1")
				.surname("1")
				.email("1@mail.com")
				.role("Employee")
				.build();

		userRepository.save(user1);
	}
}
