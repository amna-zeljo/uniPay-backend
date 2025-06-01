package com.unipay.backend;

import com.unipay.backend.dto.ProductDTO;
import com.unipay.backend.entity.Product;
import com.unipay.backend.repository.ProductRepository;
import com.unipay.backend.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
class ProductsTests {

    @Mock
    ProductRepository productRepository;
    @InjectMocks
    ProductService productService;

    @Test
    void testGetAllProductsEmpty(){
        when(productRepository.findAll()).thenReturn(Collections.emptyList());
        List<ProductDTO> products = productService.getAllProducts();
        assertEquals(0, products.size());
    }

    @Test
    void testGetSingleProduct(){
        Product product = new Product();
        product.setName("TestName");
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        ProductDTO productDTO = productService.getProduct(1L);
        assertEquals(product.getName(), productDTO.getName());
    }

    @Test
    void testCreateProduct(){
        Product product = new Product();
        product.setName("TestName");
        product.setPrice(100);
        when(productRepository.save(any(Product.class))).thenReturn(product);

        ProductDTO productDTO = new ProductDTO(product);
        productDTO = productService.createProduct(productDTO);
        assertEquals(product.getName(), productDTO.getName());
    }

    @Test
    void testDeleteExistingProduct(){
        Product product = new Product();
        product.setName("TestName");
        product.setPrice(100);
        when(productRepository.save(any(Product.class))).thenReturn(product);

        ProductDTO productDTO = new ProductDTO(product);
        productService.createProduct(productDTO);
        productService.deleteProduct(productDTO.getId());
    }

    @Test
    void testUpdateProduct(){
        Product product = new Product();
        product.setName("TestName");
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("New Name");
        productDTO.setPrice(20L);
        productDTO.setPointsPrice(0);
        productDTO.setCategory("New Category");
        productDTO.setDescription("New Desc");
        productDTO.setAvailable(true);
        productDTO.setId(1L);
        productService.updateProduct(productDTO);
        assertEquals(product.getName(), productDTO.getName());
    }

    @Test
    void testUpdateProductWhenDatabaseEmpty(){
        Product product = new Product();
        product.setName("TestName");
        when(productRepository.findById(1L)).thenReturn(Optional.empty());
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        ProductDTO updatedProduct = productService.updateProduct(productDTO);
        assertNull(updatedProduct);
    }

    @Test
    void testOnlyUpdateProductName(){
        Product product = new Product();
        product.setName("TestName");
        when(productRepository.findById(1L)).thenReturn(Optional.of(product));
        when(productRepository.save(any(Product.class))).thenReturn(product);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(1L);
        ProductDTO updatedProductDTO = productService.updateProduct(productDTO);
        assertEquals(product.getName(), updatedProductDTO.getName());
    }

    @Test
    void testUpdateNonExistingProduct(){
        Product product = new Product();
        product.setName("TestName");
        when(productRepository.findById(2L)).thenThrow(new RuntimeException());
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("New Name");
        productDTO.setPrice(20L);
        productDTO.setPointsPrice(0);
        productDTO.setCategory("New Category");
        productDTO.setDescription("New Desc");
        productDTO.setAvailable(true);
        productDTO.setId(1L);
        assertThrows(RuntimeException.class,() -> productService.updateProduct(productDTO));
    }

}
