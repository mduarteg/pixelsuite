package me.mduarteg.pixelsuite.data;

import java.time.LocalDateTime;

public class Product {

    public String name;

    public String description;

    public String category;

    public String code;

    public double costPrice;

    public double unitPrice;

    public int minQuantity;

    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", code='" + code + '\'' +
                ", costPrice=" + costPrice +
                ", unitPrice=" + unitPrice +
                ", minQuantity=" + minQuantity +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}