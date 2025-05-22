package com.unipay.backend.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "wallets")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "balance")
    private Double balance;

    @Column(name = "points")
    private Integer points;

    @Column(name = "last_updated")
    private Date lastUpdated;

    @OneToOne(mappedBy = "wallet")
    private Customer customer; // optional: reverse reference

    public Wallet() {
    }

    public Wallet(Double balance, Integer points) {
        this.balance = balance;
        this.points = points;
        this.lastUpdated = new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}