package com.unipay.backend.controller;

import com.unipay.backend.dto.ProductDTO;
import com.unipay.backend.entity.Product;
import com.unipay.backend.model.MenuItem;
import com.unipay.backend.service.MenuItemService;
import com.unipay.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:54102")
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO) {

        ProductDTO newProductDTO = productService.createProduct(productDTO);
        return ResponseEntity.ok(newProductDTO);
    }

    @PutMapping
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO) {
        ProductDTO updatedProductDto = productService.updateProduct(productDTO);
        if(updatedProductDto == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(updatedProductDto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok().build();


    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) {
        ProductDTO productDTO = productService.getProduct(id);
        if(productDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(productDTO);

    }


}