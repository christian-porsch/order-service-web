package de.neuefische.orderserviceweb.controller;

import de.neuefische.orderserviceweb.model.Order;
import de.neuefische.orderserviceweb.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> listAllOrders(){
        return orderService.listAllOrders();
    }

    /*@GetMapping("{orderId}")
    public Order getOrderById(@PathVariable String orderId) {

    }*/
}
