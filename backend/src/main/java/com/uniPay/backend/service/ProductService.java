package com.unipay.backend.service;

import com.unipay.backend.dto.ProductDTO;
import com.unipay.backend.entity.Product;
import com.unipay.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductDTO createProduct(ProductDTO productDTO){
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setPointsPrice(productDTO.getPointsPrice());
        product.setCategory(productDTO.getCategory());
        product.setAvailable(productDTO.isAvailable());
        product = productRepository.save(product);
        return new ProductDTO(product);
    }

    public List<ProductDTO> getAllProducts(){
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductDTO::new).toList();
    }

    public ProductDTO updateProduct(ProductDTO productDTO){
        Optional<Product> productOptional = productRepository.findById(productDTO.getId());
        if(productOptional.isEmpty()) return null;
        Product product = productOptional.get();
        if(productDTO.getName() != null) {
            product.setName(productDTO.getName());
        }
        if(productDTO.getDescription() != null) {
            product.setDescription(productDTO.getDescription());
        }
        if(productDTO.getPrice() != null) {
            product.setPrice(productDTO.getPrice());
        }
        if(productDTO.getPointsPrice() != null){
            product.setPointsPrice(productDTO.getPointsPrice());
        }
        if(productDTO.getCategory() != null) {
            product.setCategory(productDTO.getCategory());
        }
        if(productDTO.isAvailable() != null) {
            product.setAvailable(productDTO.isAvailable());
        }

        product = productRepository.save(product);
        return new ProductDTO(product);
    }

    public void deleteProduct(Long productId){
        productRepository.deleteById(productId);
    }

    public ProductDTO getProduct(Long id){
        Optional<Product> product = productRepository.findById(id);
        return product.map(ProductDTO::new).orElse(null);
    }

}
