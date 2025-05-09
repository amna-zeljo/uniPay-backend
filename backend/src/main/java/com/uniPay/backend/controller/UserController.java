package com.uniPay.backend.controller;

import com.uniPay.backend.model.MockUser;
import com.uniPay.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:54102")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

   @PostMapping("/users")
    public ResponseEntity<MockUser> addUser(@RequestBody MockUser user) {
      MockUser newUser = userService.addUser(user);
      if(newUser == null) {
          return ResponseEntity.badRequest().build();
      }
      return ResponseEntity.ok(newUser);
   }


    @GetMapping("/users/{id}")
    public ResponseEntity<MockUser> getUser(@PathVariable String id) {
        MockUser user = userService.getUser(id);
        if(user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(user);


    }


}

