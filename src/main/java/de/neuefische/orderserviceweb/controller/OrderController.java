package de.neuefische.orderserviceweb.controller;

import de.neuefische.orderserviceweb.model.Order;
import de.neuefische.orderserviceweb.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("{orderId}")
    public Order getOrderById(@PathVariable String orderId) {
        Optional<Order> optionalOrder = orderService.getOrderById(orderId);
        if(optionalOrder.isPresent()) {
            return optionalOrder.get();
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "order with id " + orderId + " not found" + "https://http.cat/404");
    }

    @PostMapping("addOrder")
    public Order addOrder(@RequestBody Order newOrder){
        return orderService.addOrder(newOrder);
    }
}
