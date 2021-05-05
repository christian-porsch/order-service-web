package de.neuefische.orderserviceweb.service;

import de.neuefische.orderserviceweb.model.Product;
import de.neuefische.orderserviceweb.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    //Constructor
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //Methoden
    public List<Product> listAllProducts() {
        return productRepository.listAllProducts();
    }

    public Optional<Product> getProductById(String productId) {
        return productRepository.getProductById(productId);
    }

    public Optional<Product> addProduct(Product newProduct) {
        if(productRepository.getProductRepoMap().containsKey(newProduct.getId())){
            return Optional.empty();
        }

        return Optional.of(productRepository.addProduct(newProduct));
    }
}
