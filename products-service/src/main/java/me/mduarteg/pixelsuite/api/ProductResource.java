package me.mduarteg.pixelsuite.api;

import me.mduarteg.pixelsuite.data.Product;
import me.mduarteg.pixelsuite.util.PixelConstants;
import me.mduarteg.pixelsuite.wrapper.ExceptionWrapper;
import me.mduarteg.pixelsuite.service.ProductService;
import me.mduarteg.pixelsuite.wrapper.MissingProductObjidException;
import me.mduarteg.pixelsuite.wrapper.ResponseWrapper;
import org.jboss.logging.Logger;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Path("/product")
@RequestScoped
public class ProductResource {

    private static final Logger LOGGER = Logger.getLogger(ProductResource.class);

    @Inject
    Validator validator;

    @Inject
    ProductService productService;

    @GET
    @RolesAllowed(value = { "USER" })
    public Response getAllProducts() {
        ResponseWrapper<List<Product>> response =
                new ResponseWrapper<>(PixelConstants.PRODUCT_GET_ALL, productService.getAllProducts());

        return Response.ok(response).build();
    }

    @GET
    @Path("/{productId}")
    public Response getOneProduct(@PathParam("productId") String productId) {
        Product product;

        try {
            product = productService.getOneProduct(productId);
        } catch (NoSuchElementException ex) {
            ExceptionWrapper exceptionWrapper =
                    new ExceptionWrapper(PixelConstants.PRODUCT_NOT_FOUND, ex.getMessage(), null);
            LOGGER.error(exceptionWrapper);
            return Response.status(404).entity(exceptionWrapper).build();
        }

        ResponseWrapper<Product> response =
                new ResponseWrapper<>(PixelConstants.PRODUCT_GET_ONE, product);

        return Response.ok(response).build();
    }

    @POST
    public Response saveNewProduct(Product product) {
        Set<ConstraintViolation<Product>> violations = validator.validate(product);

        if (violations.isEmpty()) {
            Product newProduct = productService.saveProduct(product);

            ResponseWrapper<Product> response =
                    new ResponseWrapper<>(PixelConstants.PRODUCT_SAVE_ONE, newProduct);

            return Response.ok(response).build();
        } else {
            List<String> resultViolations = violations
                    .stream()
                    .map(ConstraintViolation::getMessageTemplate)
                    .collect(Collectors.toList());

            ExceptionWrapper exceptionWrapper =
                    new ExceptionWrapper(PixelConstants.PRODUCT_VALIDATION_ERROR, "", resultViolations);

            return Response.status(400).entity(exceptionWrapper).build();
        }
    }

    @PUT
    public Response updateProduct(Product product) {
        Set<ConstraintViolation<Product>> violations = validator.validate(product);

        if (violations.isEmpty()) {
            Product updatedProduct;

            try {
                updatedProduct = productService.updateProduct(product);
            } catch (MissingProductObjidException e) {
                ExceptionWrapper exceptionWrapper =
                        new ExceptionWrapper(PixelConstants.PRODUCT_UPDATE_ERROR, "", null);

                return Response.status(400).entity(exceptionWrapper).build();
            }

            ResponseWrapper<Product> response =
                    new ResponseWrapper<>(PixelConstants.PRODUCT_UPDATE, updatedProduct);

            return Response.ok(response).build();
        } else {
            List<String> resultViolations = violations
                    .stream()
                    .map(ConstraintViolation::getMessageTemplate)
                    .collect(Collectors.toList());

            ExceptionWrapper exceptionWrapper =
                    new ExceptionWrapper(PixelConstants.PRODUCT_VALIDATION_ERROR, "", resultViolations);

            return Response.status(400).entity(exceptionWrapper).build();
        }
    }

    @DELETE
    public Response deleteAllProducts() {
        Long result = productService.deleteAll();
        ResponseWrapper<Long> response =
                new ResponseWrapper<>(PixelConstants.PRODUCT_DELETE_ALL, result);

        return Response.ok(response).build();
    }

}