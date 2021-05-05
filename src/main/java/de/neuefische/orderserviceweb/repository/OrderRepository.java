package de.neuefische.orderserviceweb.repository;

import de.neuefische.orderserviceweb.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {
    private final List<Order> orderList = new ArrayList<>(List.of(
            new Order("1", "Goldener Apfel"),
            new Order("2", "Bio Fairtrade Kakao mit Blutdiamanten"),
            new Order("3","Gewoehnlicher Tee, aber mit Goldplaettchen"),
            new Order("4","(Sehr) teurer Kaffee")
    ));
    public List<Order> listAllOrders() {
        return orderList;
    }

    /* ToDo: 
        -AddOrder
        -GetOrder
    */
}
