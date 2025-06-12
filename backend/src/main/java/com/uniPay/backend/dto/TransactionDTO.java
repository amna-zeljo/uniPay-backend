package com.unipay.backend.dto;

import com.unipay.backend.entity.Product;
import com.unipay.backend.entity.Transaction;
import com.unipay.backend.entity.Wallet;
import jakarta.persistence.*;

import java.util.Date;

public class TransactionDTO {

    private Integer id;
    private Double amount;
    private Double pointsUsed;
    private String status;
    private String type;
    private Date transactionDate;

    public TransactionDTO(Transaction transaction){
        this.id = transaction.getId();
        this.amount = transaction.getAmount();
        this.pointsUsed = transaction.getPointsUsed();
        this.status = transaction.getStatus();
        this.type = transaction.getType();
        this.transactionDate = transaction.getTransactionDate();

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getPointsUsed() {
        return pointsUsed;
    }

    public void setPointsUsed(Double pointsUsed) {
        this.pointsUsed = pointsUsed;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }
}
