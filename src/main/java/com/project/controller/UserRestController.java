package com.project.controller;

import com.project.jpa.UserRepository;
import com.project.model.User;
import com.project.model.UserOrder;
import com.project.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(value = "/users")
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

    @PutMapping("/deposit")
    public User deposit(@RequestParam Long id, @RequestParam BigDecimal balance) {
        return userService.deposit(id, balance);
    }

    @PutMapping("/order")
    public UserOrder userOrder(@RequestParam Long id, @RequestParam String orderName) {
        return userService.makeOrder(id, orderName);
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
