package productSercice.Rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

    @PostMapping
    public String createProduct() {
        return "HTTP Post Handled";
    }

    @GetMapping
    public String getProducts() {
        return "HTTP Get Handled";
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

