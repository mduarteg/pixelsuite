package me.mduarteg.pixelsuite.messaging;

import me.mduarteg.pixelsuite.wrapper.ProductMessageWrapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductReceiver {

    private static final Logger LOGGER = Logger.getLogger(ProductReceiver.class);

    @Incoming("test-requests")
    public void process(ConsumerRecord<String, ProductMessageWrapper> record) {
        String key = record.key();
        ProductMessageWrapper wrapper = record.value();

        LOGGER.info("Received product message with ID: " + key);
        LOGGER.info(wrapper);
    }

}
