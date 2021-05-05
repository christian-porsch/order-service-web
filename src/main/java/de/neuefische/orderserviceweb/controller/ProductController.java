package de.neuefische.orderserviceweb.controller;

import de.neuefische.orderserviceweb.model.Product;
import de.neuefische.orderserviceweb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
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
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "product with id " +
                productId + " not found" + "https://http.cat/404");
    }

    @PostMapping("addProduct")
    public Optional<Product> addProduct(@RequestBody Product newProduct){
        Optional<Product> optionalProduct = productService.addProduct(newProduct);
        if(optionalProduct.isPresent()) {
            return optionalProduct;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "product with id " +
                newProduct + " does already exist" + " https://http.cat/404");
    }

}


