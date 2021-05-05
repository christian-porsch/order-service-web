package de.neuefische.orderserviceweb.service;
import de.neuefische.orderserviceweb.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import de.neuefische.orderserviceweb.model.Order;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public List<Order> listAllOrders() {
        return orderRepository.listAllOrders();
    }
}
