package com.arlanda;

import com.arlanda.customer.Customer;
import com.arlanda.customer.CustomerRepository;
import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class ArlandaCrmApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArlandaCrmApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(CustomerRepository customerRepository) {
		return args -> {
			var faker = new Faker();
			var name = faker.name();
			Random random = new Random();
			String firstName = name.firstName();
			String lastName = name.lastName();
			Customer customer = new Customer(
					firstName + " " + lastName,
					firstName.toLowerCase() + "." + lastName.toLowerCase() + "@elitech.com",
				    random.nextInt(16, 99)
			);

			customerRepository.save(customer);
		};
	}

}
