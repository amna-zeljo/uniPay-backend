package com.unipay.backend.model;

public class User {
    private String id;
    private String name;
    private double balance;
    private int subscriptionPoints;
    private String role; // we have two roles: "customer" or "staff"
    private String qrCodeData; // Base64 encoded QR code data

    
    public User() {}

    public User(String id, String name, double balance, int subscriptionPoints, 
                String role, String qrCodeData) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.subscriptionPoints = subscriptionPoints;
        this.role = role;
        this.qrCodeData = qrCodeData;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getSubscriptionPoints() {
        return subscriptionPoints;
    }

    public void setSubscriptionPoints(int subscriptionPoints) {
        this.subscriptionPoints = subscriptionPoints;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getQrCodeData() {
        return qrCodeData;
    }

    public void setQrCodeData(String qrCodeData) {
        this.qrCodeData = qrCodeData;
    }
}