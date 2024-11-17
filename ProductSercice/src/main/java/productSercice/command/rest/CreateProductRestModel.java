package productSercice.command.rest;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;


import java.math.BigDecimal;

@Data
public class CreateProductRestModel {

    @NotBlank(message = "Title is mandatory")
    private String title;

    @Min(value = 1, message = "Price should be greater than 0")
    private BigDecimal price;

    @Min(value = 1, message = "Quantity should be greater than 0")
    @Max(value = 100, message = "Quantity should be less than 100")
    private Integer quantity;
}
