package com.uniPay.backend.dto;

import com.uniPay.backend.entity.Product;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer pointsPrice;
    private String category;
    private Boolean available;

    public ProductDTO(Product product){
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.pointsPrice = product.getPointsPrice();
        this.category = product.getCategory();
        this.available = product.isAvailable();

    }

    public ProductDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getPointsPrice() {
        return pointsPrice;
    }

    public void setPointsPrice(int pointsPrice) {
        this.pointsPrice = pointsPrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
