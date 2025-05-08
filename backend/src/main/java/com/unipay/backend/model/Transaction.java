package com.unipay.backend.model;

import java.time.LocalDateTime;

public class Transaction {
    private String id;
    private String userId;
    private double amount;
    private String type; // "deposit", "purchase"
    private LocalDateTime timestamp;
    private String description;

    
    public Transaction() {}

    public Transaction(String id, String userId, double amount, String type, 
                      LocalDateTime timestamp, String description) {
        this.id = id;
        this.userId = userId;
        this.amount = amount;
        this.type = type;
        this.timestamp = timestamp;
        this.description = description;
    }

    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}