package me.mduarteg.pixelsuite.service;

import me.mduarteg.pixelsuite.data.Product;
import me.mduarteg.pixelsuite.messaging.ProductEmitter;
import me.mduarteg.pixelsuite.wrapper.MissingProductObjidException;
import org.bson.types.ObjectId;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ProductService {

    @Inject
    ProductEmitter emitter;

    public Product saveProduct(Product product) {
        product.createdAt = LocalDateTime.now();
        product.updatedAt = LocalDateTime.now();

        product.persist();

        emitter.sendMessage(product);

        return product;
    }

    public List<Product> getAllProducts() {
        return Product.listAll();
    }

    public Product getOneProduct(String productId) {
        ObjectId objId = new ObjectId(productId);

        Optional<Product> optionalProduct = Product.findByIdOptional(objId);
        return optionalProduct.orElseThrow();
    }

    public Product updateProduct(Product product) throws MissingProductObjidException {
        if (product.id == null) {
            throw new MissingProductObjidException();
        }

        product.update();

        return product;
    }

    public long deleteAll() {
        return Product.deleteAll();
    }

}