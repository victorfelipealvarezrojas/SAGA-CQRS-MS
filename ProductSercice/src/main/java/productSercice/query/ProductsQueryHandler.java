package productSercice.query;

import lombok.AllArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;
import productSercice.core.data.ProductRepository;
import productSercice.query.rest.ProductRestModel;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class ProductsQueryHandler {

    private final ProductRepository productRepository;

    @QueryHandler
    public List<ProductRestModel> getProducts(FindProductsQuery query) {
        List<ProductRestModel> products = new ArrayList<>();
        productRepository.findAll().forEach(productEntity -> {
            ProductRestModel product = new ProductRestModel();
            product.setProductId(productEntity.getProductId());
            product.setTitle(productEntity.getTitle());
            product.setPrice(productEntity.getPrice());
            product.setQuantity(productEntity.getQuantity());
            products.add(product);
        });
        return products;
    }

}
