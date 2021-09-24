package me.mduarteg.pixelsuite.wrapper;

import me.mduarteg.pixelsuite.data.Product;

public class ProductMessageWrapper {
    public Product product;
    public String id;

    public ProductMessageWrapper() {}

    public ProductMessageWrapper(Product product, String id) {
        this.product = product;
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProductMessageWrapper{" +
                "product=" + product +
                ", id=" + id +
                '}';
    }
}
