	package io.Spring.HackerNewsAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HackerrankApiApplication extends SpringBootServletInitializer { //Entending so that we can build war file for this

	public static void main(String[] args) {
		SpringApplication.run(HackerrankApiApplication.class, args);
	}

}
