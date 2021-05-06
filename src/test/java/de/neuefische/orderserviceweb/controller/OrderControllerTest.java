package de.neuefische.orderserviceweb.controller;

import de.neuefische.orderserviceweb.model.Order;
import de.neuefische.orderserviceweb.repository.OrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderControllerTest {
    //1. Webserver starten mit Random Port
    //2. Port abgreifen und speichern
    //3. Repo+ TestRest Template autowiren

    @LocalServerPort
    private int port;

    @Autowired
    private OrderRepository repository;

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void listAllOrders() {
    }

    @Test
    void getOrderById() {
        //Given
        Order expectedOrder = new Order("2", "Bio Fairtrade Kakao mit Blutdiamanten");
        //4. Url zusammenbauen
        String host = "http://localhost:" + port + "/order/2";
        ResponseEntity<Order> response = restTemplate.getForEntity(host, Order.class);

        //Then
        assertThat(response.getStatusCode(), is(HttpStatus.OK));
        assertThat(response.getBody(), is(expectedOrder));
    }

    @Test
    void addOrder() {
    }
}