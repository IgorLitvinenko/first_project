package com.project.service;


import com.project.jpa.OrderRepository;
import com.project.jpa.UserOrderRepository;
import com.project.jpa.UserRepository;
import com.project.model.Order;
import com.project.model.User;
import com.project.model.UserOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserOrderRepository userOrderRepository;
    private final OrderRepository orderRepository;


    public UserService(UserRepository userRepository, UserOrderRepository userOrderRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.userOrderRepository = userOrderRepository;
        this.orderRepository = orderRepository;
    }

//    public User order(Food food) {
//        Long userId = food.getUser().getId();
//        User user = userRepository.findById(userId).get();
//        user.setBalance(user.getBalance().subtract(food.getCost()));
//        UserOrder userOrder = new UserOrder(food.toString());
//        userOrder.setUser(user);
//        user.getOrderHistory().add(userOrder);
//        user.setOrderHistory(user.getOrderHistory());
//        userOrderRepository.save(userOrder);
//        return user;
//    }

    public User deposit(Long id, BigDecimal balance) {
        User user = userRepository.findById(id).get();
        user.setBalance(user.getBalance().add(balance));
        return userRepository.save(user);
    }

    public UserOrder makeOrder(Long id, String orderName) {
        User user = userRepository.findById(id).get();
        Order order = orderRepository.findByOrderName(orderName);
        user.setBalance(user.getBalance().subtract(order.getCost()));
        userRepository.save(user);
        UserOrder userOrder = new UserOrder();
        userOrder.setUser(user);
        userOrder.setOrder(order);
        return userOrderRepository.save(userOrder);
    }



}
