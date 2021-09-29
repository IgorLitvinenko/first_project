package com.project.controller;

import com.project.jpa.OrderRepository;
import com.project.model.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/orders")
public class OrderRestController {

    private final OrderRepository orderRepository;

    @PostMapping("/add")
    public Order order(@RequestBody Order order) {
        return orderRepository.save(order);
    }

    @DeleteMapping("/delete/{id}")
    public void remove(@PathVariable Long id) {
        orderRepository.deleteById(id);
    }
    @DeleteMapping("/delete")
    public void remove(@RequestBody String orderName) {
        orderRepository.deleteOrderByOrderName(orderName);
    }
}
