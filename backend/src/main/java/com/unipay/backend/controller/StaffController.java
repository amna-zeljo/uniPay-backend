package com.unipay.backend.controller;

import com.unipay.backend.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/staff")
@CrossOrigin(origins = "*")
public class StaffController {

    //note to self: this is dummy data --> in a real app, this would come from a service
    private final Map<String, User> dummyCustomers = new HashMap<>() {{
        put("USR001", new User(
            "USR001", 
            "Zeljo Manijak", 
            150.50, 
            25, 
            "customer",
            "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVR42mP8z8BQDwAEhQGAhKmMIQAAAABJRU5ErkJggg=="
        ));
        put("USR002", new User(
            "USR002", 
            "Plavi Zamak", 
            75.25, 
            10, 
            "customer",
            "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVR42mP8z8BQDwAEhQGAhKmMIQAAAABJRU5ErkJggg=="
        ));
    }};
    
    private final Map<String, String> qrCodeToUserId = new HashMap<>() {{
        put("data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAYAAAAfFcSJAAAADUlEQVR42mP8z8BQDwAEhQGAhKmMIQAAAABJRU5ErkJggg==", "USR001");
    }};

    /**
     * section: search 
     * note to self: search option 1 --> to earch for a customer by ID
     * this endpoint supports the "Input ID" tab in staff home page
     */
    @GetMapping("/search")
    public ResponseEntity<User> searchCustomerById(@RequestParam String customerId) {
        // important: in a real app, change for proper function --> to look up the user by ID
        // but for now, just return the dummy customer if the ID matches
        User customer = dummyCustomers.get(customerId);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * note to self: search option 2 --> to search for a customer by QR code
     * this endpoint supports the "Scan QR" tab in staff home page
     */
    @GetMapping("/scan")
    public ResponseEntity<User> scanCustomerQrCode(@RequestParam String qrCodeData) {
        // important: in a real app, change for proper function --> to look up the user by QR code
        // but for now, just return the dummy customer if the QR code matches
        String userId = qrCodeToUserId.get(qrCodeData);
        if (userId != null) {
            User customer = dummyCustomers.get(userId);
            if (customer != null) {
                return ResponseEntity.ok(customer);
            }
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * section: process a payment for a customer
     * this endpoint supports the payment processing functionality in staff home page
     */
    @PostMapping("/process-payment")
    public ResponseEntity<Map<String, Object>> processPayment(
            @RequestParam String customerId,
            @RequestParam double amount,
            @RequestParam String description) {
        
        User customer = dummyCustomers.get(customerId);
        if (customer == null) {
            return ResponseEntity.notFound().build();
        }
        
        boolean successful = customer.getBalance() >= amount;
        
        if (successful) {
            //note to self: this line is to update customer balance
            customer.setBalance(customer.getBalance() - amount);
        }
        
        Map<String, Object> response = new HashMap<>();
        response.put("transactionId", "TRX" + System.currentTimeMillis());
        response.put("customerId", customer.getId());
        response.put("customerName", customer.getName());
        response.put("amount", amount);
        response.put("newBalance", customer.getBalance());
        response.put("successful", successful);
        response.put("message", successful ? "Payment processed successfully" : "Insufficient funds");
        
        return ResponseEntity.ok(response);
    }
}