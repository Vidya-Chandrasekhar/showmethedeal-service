package com.vcs.shoppingbuddy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.vcs.shoppingbuddy.repo")
public class ShoppingBuddyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingBuddyServiceApplication.class, args);
	}
}
