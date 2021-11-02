
package com.example.pneutrust.service;

import com.example.pneutrust.entities.User;
import com.example.pneutrust.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean userSaved(User user) {
        for (User u : userRepository.findAll()) {
            if (u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public boolean userRegistered(User user) {
        for (User u : userRepository.findAll()) {
            if (u.getEmail().equals(user.getEmail())) {
                return true;
            }
        }
        return false;
    }

    public void save(User user) {
        userRepository.save(user);
    }
}

