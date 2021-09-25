//package com.project.controller;
//
//import com.project.jpa.UserRepository;
//import com.project.model.User;
//import org.springframework.web.bind.annotation.*;
//
//
//@RestController
//@RequestMapping("/users")
//public class UserRestController {
//
//    private final UserRepository userRepository;
//
//    public UserRestController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @PostMapping()
//    public User save(@RequestBody User user) {
//       return userRepository.save(user);
//    }
//
//    @GetMapping("/{id}")
//    public User getOne(@PathVariable Long id) {
//        return userRepository.findById(id).get();
//    }
//
//    @DeleteMapping("/{id}")
//    public void remove(@PathVariable Long id) {
//        userRepository.deleteById(id);
//    }
//}
