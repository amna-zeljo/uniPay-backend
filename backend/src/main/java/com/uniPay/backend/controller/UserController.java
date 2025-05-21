package com.uniPay.backend.controller;

import com.uniPay.backend.dto.UserDTO;
import com.uniPay.backend.model.MockUser;
import com.uniPay.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:54102")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestParam String email, @RequestParam String password) {
        UserDTO userDTO=userService.login(email, password);
        if(userDTO==null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/register")
    public ResponseEntity<UserDTO> register(@RequestBody UserDTO userDTO) {
        UserDTO newUserDTO=userService.register(userDTO);
        if(newUserDTO==null) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(newUserDTO);
    }

}

