package me.mduarteg.pixelsuite.data;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@MongoEntity(collection = "products")
public class Product extends PanacheMongoEntity {

    @NotBlank(message = "PRODUCT_BLANK_NAME")
    public String name;

    @NotBlank(message = "PRODUCT_BLANK_DESC")
    public String description;

    public String category;

    public String code;

    public double costPrice;

    public double unitPrice;

    public int minQuantity;

    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;

}