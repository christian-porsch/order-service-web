package de.neuefische.orderserviceweb.repository;

import de.neuefische.orderserviceweb.model.Order;
import org.springframework.stereotype.Repository;
import de.neuefische.orderserviceweb.model.Product;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;


@Repository
public class ProductRepository {

    private final Map<String, Product> productRepoMap = new HashMap<>(Map.of(
       "1", new Product("1", "Goldener Apfel"),
       "2", new Product("2", "Bio Fairtrade Kakao mit Blutdiamanten"),
       "3", new Product("3", "GGewoehnlicher Tee, aber mit Goldplaettchen"),
       "4", new Product("4", "(Sehr) teurer Kaffee")
    ));

    public List<Product> listAllProducts(){
        return  new ArrayList<>(productRepoMap.values());
    }

    public Optional<Product> getProductById(String productId) {
        return Optional.ofNullable(productRepoMap.get(productId));
    }
}
