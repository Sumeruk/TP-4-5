package ru.vsu.cs.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.vsu.cs.springboot.entity.Product;
import ru.vsu.cs.springboot.entity.User;
import ru.vsu.cs.springboot.repository.ProductRepository;
import ru.vsu.cs.springboot.repository.UserRepository;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {
    // HI NIKOLAY
	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		User kl = User.builder()
				.name("k")
				.surname("k")
				.email("k@mail.ru")
				.role("Кладовщик")
				.password("111")
				.status(-1)
				.build();

		User ns = User.builder()
				.name("ns")
				.surname("ns")
				.email("ns@mail.ru")
				.role("Начальник склада")
				.password("111")
				.build();

		User adm = User.builder()
				.name("0")
				.surname("0")
				.email("a@mail.ru")
				.role("Администратор")
				.password("111")
				.build();

		User shop = User.builder()
				.name("sh")
				.surname("sh")
				.email("sh@mail.ru")
				.role("Магазин")
				.password("111")
				.build();

		Product product = Product.builder()
				.id("1")
				.name("Плюшки")
				.quantity(0)
				.price(5)
				.build();

		userRepository.save(adm);
		userRepository.save(kl);
		userRepository.save(ns);
		userRepository.save(shop);

		productRepository.save(product);
	}
}
