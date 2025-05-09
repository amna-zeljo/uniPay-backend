package com.uniPay.backend.controller;

import com.uniPay.backend.model.MenuItem;
import com.uniPay.backend.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:54102")
@RestController
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @GetMapping("/menuItems")
    public List<MenuItem> getMenuItems() {
        return menuItemService.getMenuItems();
    }
   @PostMapping("/menuItem")
    public ResponseEntity<MenuItem> addMenuItem(@RequestBody MenuItem menuItem) {
      MenuItem newMenuItem = menuItemService.addMenuItem(menuItem);
      if(newMenuItem == null) {
          return ResponseEntity.badRequest().build();
      }
      return ResponseEntity.ok(newMenuItem);
   }

    @PutMapping("/menuItem/{id}")
    public ResponseEntity<MenuItem> updateMenuItem(@RequestBody MenuItem menuItem,@PathVariable String id) {
        MenuItem updateMenuItem = menuItemService.updateMenuItem(menuItem, id);
        if(updateMenuItem == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(updateMenuItem);
    }


}

