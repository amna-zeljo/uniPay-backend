package com.unipay.backend.controller;

import com.unipay.backend.dto.ProductDTO;
import com.unipay.backend.dto.TransactionDTO;
import com.unipay.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<TransactionDTO> getAllTransactions() {
        return productService.getAllTransactions();
    }

}