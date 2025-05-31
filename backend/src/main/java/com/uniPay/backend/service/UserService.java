package com.unipay.backend.service;

import com.unipay.backend.dto.UserDTO;
import com.unipay.backend.entity.User;
import com.unipay.backend.model.MockUser;
import com.unipay.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return null;
        }
        if (!user.getPassword().equals(password)) {
            return null;
        }
        return new UserDTO(user);
    }

    public UserDTO register(UserDTO userDTO) {
        User user=new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());
        user.setRole(userDTO.getRole());
        userRepository.save(user);
        return new UserDTO(user);

    }

}
