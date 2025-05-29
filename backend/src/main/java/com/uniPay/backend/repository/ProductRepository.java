package com.uniPay.backend.repository;

import com.uniPay.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
