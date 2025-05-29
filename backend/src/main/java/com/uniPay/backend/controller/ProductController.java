package com.uniPay.backend.controller;

import com.uniPay.backend.dto.ProductDTO;
import com.uniPay.backend.entity.Product;
import com.uniPay.backend.model.MenuItem;
import com.uniPay.backend.service.MenuItemService;
import com.uniPay.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:54102")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/product")
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO) {

        ProductDTO newProductDTO = productService.createProduct(productDTO);
        return ResponseEntity.ok(newProductDTO);
    }

    @PutMapping("/product")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO updatedProductDto = productService.updateProduct(productDTO);
        if(updatedProductDto == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(updatedProductDto);
    }


    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();


    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {
        ProductDTO productDTO = productService.getProduct(id);
        if(productDTO != null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDTO);

    }


}