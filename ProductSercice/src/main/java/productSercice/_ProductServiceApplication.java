package productSercice;

import org.axonframework.commandhandling.CommandBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import productSercice.command.interceptors.CreateProductCommandInterceptor;

@EnableDiscoveryClient
@SpringBootApplication
public class _ProductServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(_ProductServiceApplication.class, args);
	}

	@Autowired
	public void registerCreateProductInterceptor(ApplicationContext _ctx, CommandBus bus) {
		bus.registerDispatchInterceptor(_ctx.getBean(CreateProductCommandInterceptor.class));
	}
}
