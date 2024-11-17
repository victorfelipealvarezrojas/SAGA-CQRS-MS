package productSercice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class _ProductServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(_ProductServiceApplication.class, args);
	}
}
