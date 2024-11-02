package productSercice.Rest;

import org.axonframework.commandhandling.gateway.CommandGateway;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import productSercice.command.CreateProductCommand;

import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductsController {


    private final Environment env;
    private final CommandGateway commandGateway;

    public ProductsController(CommandGateway commandGateway ,Environment env) {
        this.commandGateway = commandGateway;
        this.env = env;
    }

    @PostMapping
    public String createProduct(@RequestBody CreateProductRestModel product) {

        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .productId(UUID.randomUUID().toString())
                .title(product.getTitle())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();

        String response = "";

        try {
            response = commandGateway.sendAndWait(createProductCommand);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }

    @GetMapping
    public String getProducts() {
        System.out.println("env = " + env.toString());
        return "HTTP Get Handled " + env.getProperty("local.server.ports");
    }

    @PutMapping
    public String updateProduct() {
        return "HTTP Put Handled";
    }

    @DeleteMapping
    public String deleteProduct() {
        return "HTTP Delete Handled";
    }
}

