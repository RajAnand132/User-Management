package com.projectRaj.UserManagementSystem.controller;

import com.projectRaj.UserManagementSystem.model.User;
import com.projectRaj.UserManagementSystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("api/users")
    public String addUsers(@Valid @RequestBody List<User> users) {
        return userService.addUser(users);
    }

    @GetMapping("api/user/{userId}")
    public Object getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

    @GetMapping("api/allUser")
    public List<User> getAllUser() {
        return userService.getAllUsers();
    }

    @PutMapping("api/UserInfo/userId/{userId}")
    public String updateUserInfo(@PathVariable Long userId, @Valid @RequestBody User userDetails) {
        return userService.updateUser(userId, userDetails);
    }

    @DeleteMapping("api/user/id/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }
}

