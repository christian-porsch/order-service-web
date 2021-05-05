package de.neuefische.orderserviceweb.controller;

import de.neuefische.orderserviceweb.model.Product;
import de.neuefische.orderserviceweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> listAllProducts(){
        return productService.listAllProducts();
    }

    @GetMapping("{productId}")
    public Product getProductById(@PathVariable String productId) {
        Optional<Product> optionalProduct = productService.getProductById(productId);
        if (optionalProduct.isPresent()) {
            return optionalProduct.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "product with id " + productId + " not found" + "https://http.cat/404");
    }


}


