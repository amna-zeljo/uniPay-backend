package com.uniPay.backend.controller;

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

    @GetMapping("/users")
    public List<MockUser> getUsers() {
        return userService.getUsers();
    }
   @PostMapping("/users")
    public ResponseEntity<MockUser> addUser(@RequestBody MockUser user) {
      MockUser newUser = userService.addUser(user);
      if(newUser == null) {
          return ResponseEntity.badRequest().build();
      }
      return ResponseEntity.ok(newUser);
   }

    @PutMapping("/users/{id}")
    public ResponseEntity<MockUser> updateUser(@RequestBody MockUser user,@PathVariable String id) {
        MockUser updateUser = userService.updateUser(user, id);
        if(updateUser == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(updateUser);
    }


    @DeleteMapping("/users/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable String id) {
        Boolean isDeleted = userService.deleteUser( id);
        if(!isDeleted) {
            return ResponseEntity.status(404).body(false);
        }
        return ResponseEntity.ok(isDeleted);


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

