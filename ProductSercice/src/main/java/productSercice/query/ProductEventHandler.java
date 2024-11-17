package productSercice.query;

import lombok.AllArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import productSercice.core.data.ProductEntity;
import productSercice.core.data.ProductRepository;
import productSercice.core.events.ProductCreatedEvent;

@AllArgsConstructor
@Component
public class ProductEventHandler {

    private final ProductRepository productRepository;

    @EventHandler
    public void on(ProductCreatedEvent event) {
        ProductEntity productEntity = new ProductEntity();
        BeanUtils.copyProperties(event, productEntity);
        productRepository.save(productEntity);
    }
}