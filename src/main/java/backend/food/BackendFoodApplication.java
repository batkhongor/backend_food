package backend.food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BackendFoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendFoodApplication.class, args);
	}

}
