package productSercice.command.rest;

import org.axonframework.commandhandling.gateway.CommandGateway;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;
import productSercice.command.CreateProductCommand;

import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductsCommandController {


    private final Environment env;
    private final CommandGateway commandGateway;

    public ProductsCommandController(CommandGateway commandGateway , Environment env) {
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
}

