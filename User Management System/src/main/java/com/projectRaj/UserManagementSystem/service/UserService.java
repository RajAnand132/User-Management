package com.projectRaj.UserManagementSystem.service;

import com.projectRaj.UserManagementSystem.model.User;
import com.projectRaj.UserManagementSystem.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String addUser(List<User> users) {
        userRepository.saveAll(users);
        return users.size() + " Users added";
    }

    public Object getUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            return userOptional.get(); // Return the User object if found
        } else {
            String errorMessage = "User with ID " + userId + " not found";
            return errorMessage; // Return an error message if user is not found
        }
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public String updateUser(Long userId, User userDetails) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.setUsername(userDetails.getUsername());
            user.setDateOfBirth(userDetails.getDateOfBirth());
            user.setEmail(userDetails.getEmail());
            user.setPhoneNumber(userDetails.getPhoneNumber());
            userRepository.save(user);
            return "User with ID " + userId + " updated";
        } else {
            return "User not found with ID " + userId;
        }
    }

    public String deleteUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            userRepository.delete(user);
            return "User with ID " + userId + " deleted";
        } else {
            return "User not found with ID " + userId;
        }
    }
}

