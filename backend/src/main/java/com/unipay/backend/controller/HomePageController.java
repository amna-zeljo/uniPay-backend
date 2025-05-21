package com.unipay.backend.controller;

import com.unipay.backend.dto.CustomerHomePageDTO;
import com.unipay.backend.dto.StaffHomePageDTO;
import com.unipay.backend.service.HomePageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/home")
@CrossOrigin(origins = "*")
public class HomePageController {

    private final HomePageService homePageService;

    @Autowired
    public HomePageController(HomePageService homePageService) {
        this.homePageService = homePageService;
    }

    @GetMapping("/customer/{userId}")
    public ResponseEntity<CustomerHomePageDTO> getCustomerHomePageData(@PathVariable Integer userId) {
        CustomerHomePageDTO data = homePageService.getCustomerHomePageData(userId);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/staff/{userId}")
    public ResponseEntity<StaffHomePageDTO> getStaffHomePageData(@PathVariable Integer userId) {
        StaffHomePageDTO data = homePageService.getStaffHomePageData(userId);
        return ResponseEntity.ok(data);
    }
}