package me.mduarteg.pixelsuite;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import me.mduarteg.pixelsuite.api.ProductResource;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.when;

@QuarkusTest
@TestHTTPEndpoint(ProductResource.class)
public class ProductResourceTest {

    @Test
    public void Should_GetListOfProducts_When_ValidHttpRequest() {
        when().get()
                .then()
                .statusCode(200);
    }

}