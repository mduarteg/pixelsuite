package me.mduarteg.pixelsuite.messaging;

import me.mduarteg.pixelsuite.data.Product;
import me.mduarteg.pixelsuite.wrapper.ProductMessageWrapper;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductEmitter {

    @Channel("test-requests")
    Emitter<ProductMessageWrapper> productRequestEmitter;

    public void sendMessage(Product product) {
        ProductMessageWrapper wrapper =
                new ProductMessageWrapper(product, product.id.toString());

        productRequestEmitter.send(wrapper);
    }

}
