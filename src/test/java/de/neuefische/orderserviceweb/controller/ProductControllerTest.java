package de.neuefische.orderserviceweb.controller;

import de.neuefische.orderserviceweb.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import de.neuefische.orderserviceweb.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;



import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProductControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private ProductRepository repository;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void listAllProducts() {

        //When
        String host = "http://localhost:" + port;

        String hostProductUrl = host + "/product";
        ResponseEntity<Product[]> response = restTemplate.getForEntity(hostProductUrl, Product[].class);
        Product[] actual = response.getBody();

        //Then
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(actual, arrayContainingInAnyOrder(
                new Product("1", "Goldener Apfel"),
                new Product("2", "Bio Fairtrade Kakao mit Blutdiamanten"),
                new Product("3", "Gewoehnlicher Tee, aber mit Goldplaettchen"),
                new Product("4", "(Sehr) teurer Kaffee")
        ));



    }



    @Test
    void getProductById() {
    }

    @Test
    void addProduct() {
    }
}
