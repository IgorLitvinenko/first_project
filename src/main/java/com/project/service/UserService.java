package com.project.service;


import com.project.food.Food;
import com.project.jpa.UserOrderRepository;
import com.project.jpa.UserRepository;
import com.project.model.UserOrder;
import com.project.model.User;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserOrderRepository userOrderRepository;


    public UserService(UserRepository userRepository, UserOrderRepository userOrderRepository) {
        this.userRepository = userRepository;
        this.userOrderRepository = userOrderRepository;
    }

    public User order(Food food) {
        Long userId = food.getUser().getId();
        User user = userRepository.findById(userId).get();
        user.setBalance(user.getBalance().subtract(food.getCost()));
        UserOrder userOrder = new UserOrder(food.toString());
        userOrder.setUser(user);
        user.getOrderHistory().add(userOrder);
        user.setOrderHistory(user.getOrderHistory());
        userOrderRepository.save(userOrder);
        return user;
    }

    public User deposit(Long id, BigDecimal balance) {
        User user = userRepository.findById(id).get();
        user.setBalance(user.getBalance().add(balance));
        return userRepository.save(user);
    }

}
