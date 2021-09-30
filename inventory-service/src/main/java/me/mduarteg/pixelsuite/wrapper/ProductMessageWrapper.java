package me.mduarteg.pixelsuite.wrapper;

import me.mduarteg.pixelsuite.data.Product;

public class ProductMessageWrapper {
    private Product product;
    private String id;

    public ProductMessageWrapper() {}

    public ProductMessageWrapper(Product product, String id) {
        this.product = product;
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
