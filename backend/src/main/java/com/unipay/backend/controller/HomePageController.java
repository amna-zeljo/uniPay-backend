package com.unipay.backend.controller;

import com.unipay.backend.dto.CustomerDTO;
import com.unipay.backend.dto.StaffDTO;
import com.unipay.backend.service.HomePageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/homepage")
@CrossOrigin(origins = "*")
public class HomePageController {

    private final HomePageService homePageService;

    @Autowired
    public HomePageController(HomePageService homePageService) {
        this.homePageService = homePageService;
    }

    @GetMapping("/customer/{userId}")
    public ResponseEntity<CustomerDTO> getCustomerHomePageData(@PathVariable Integer userId) {
        CustomerDTO customerDTO = homePageService.getCustomerHomePageData(userId);
        return ResponseEntity.ok(customerDTO);
    }

    @GetMapping("/staff/{userId}")
    public ResponseEntity<StaffDTO> getStaffHomePageData(@PathVariable Integer userId) {
        StaffDTO staffDTO = homePageService.getStaffHomePageData(userId);
        return ResponseEntity.ok(staffDTO);
    }
}