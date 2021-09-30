package me.mduarteg.pixelsuite.messaging;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import me.mduarteg.pixelsuite.wrapper.ProductMessageWrapper;

public class ProductDeserializer extends ObjectMapperDeserializer<ProductMessageWrapper> {
    public ProductDeserializer() {
        super(ProductMessageWrapper.class);
    }
}
