package com.project.controller;

import com.project.food.Food;
import com.project.jpa.UserOrderRepository;
import com.project.jpa.UserRepository;
import com.project.model.User;
import com.project.model.UserOrder;
import com.project.service.UserService;
import org.springframework.web.bind.annotation.*;
//, consumes="application/json"

@RestController
@RequestMapping(value = "/user")
public class UserRestController {

    private final UserRepository userRepository;
    private final UserService userService;

    public UserRestController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping("/add")
    public User save(@RequestBody User user) {
       return userRepository.save(user);
    }

    @PostMapping("/order")
    public User order(@RequestBody Food food) {
       return userService.order(food);
    }

    @GetMapping("/{id}")
    public User getOne(@PathVariable Long id) {
        return userRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
