package com.unipay.backend.controller;

import com.unipay.backend.model.Transaction;
import com.unipay.backend.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/customer")
@CrossOrigin(origins = "*")
public class CustomerController {

    // Dummy data - in a real app, this would come from a service
    private final User dummyCustomer = new User(
        "USR001", 
        "John Doe", 
        150.50, 
        25, 
        "customer",
        "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVR42mP8z8BQDwAEhQGAhKmMIQAAAABJRU5ErkJggg=="
    );
    
    private final List<Transaction> dummyTransactions = new ArrayList<>() {{
        add(new Transaction("TRX001", "USR001", 50.00, "deposit", LocalDateTime.now().minusDays(5), "Account Top-up"));
        add(new Transaction("TRX002", "USR001", -15.75, "purchase", LocalDateTime.now().minusDays(3), "Lunch Purchase"));
        add(new Transaction("TRX003", "USR001", -5.25, "purchase", LocalDateTime.now().minusDays(1), "Coffee Purchase"));
    }};

    /**
     * Get customer information including QR code
     * This endpoint supports your customer home page which displays user info and QR code
     */
    @GetMapping("/{id}")
    public ResponseEntity<User> getCustomerInfo(@PathVariable String id) {
        // In a real app, you would look up the user by ID
        // For now, just return the dummy customer if the ID matches
        if (dummyCustomer.getId().equals(id)) {
            return ResponseEntity.ok(dummyCustomer);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Get customer transaction history
     * This endpoint supports the transaction history tab in your customer home page
     */
    @GetMapping("/{id}/transactions")
    public ResponseEntity<List<Transaction>> getCustomerTransactions(@PathVariable String id) {
        // In a real app, you would filter transactions by user ID
        // For now, just return the dummy transactions if the ID matches
        if (dummyCustomer.getId().equals(id)) {
            return ResponseEntity.ok(dummyTransactions);
        }
        return ResponseEntity.notFound().build();
    }
}