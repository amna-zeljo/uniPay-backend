package com.unipay.backend.service;

import com.unipay.backend.dto.ProductDTO;
import com.unipay.backend.dto.TransactionDTO;
import com.unipay.backend.entity.Product;
import com.unipay.backend.entity.Transaction;
import com.unipay.backend.entity.User;
import com.unipay.backend.repository.ProductRepository;
import com.unipay.backend.repository.TransactionRepository;
import com.unipay.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    public ProductService(ProductRepository productRepository, UserRepository userRepository, TransactionRepository transactionRepository) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
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

    public TransactionDTO purchaseProduct(Long userId, Long productId){

        Optional<User> user = userRepository.findUserById(userId);

        if(user.isEmpty()) return null;

        Optional<Product> product = productRepository.findById(productId);

        if(product.isEmpty()) return null;

        if(user.get().getWallet().getBalance() < product.get().getPrice()) return null;

        Transaction transaction = new Transaction();
        transaction.setAmount(product.get().getPrice());
        transaction.setProduct(product.get());
        transaction.setType("OUTGOING");
        transaction.setWallet(user.get().getWallet());
        transaction.setTransactionDate(new Date());

        transaction = transactionRepository.save(transaction);
        user.get().getWallet().setBalance(user.get().getWallet().getBalance() - transaction.getAmount());
        userRepository.save(user.get());
        return new TransactionDTO(transaction);

    }

    public List<TransactionDTO> getAllTransactions(){
        return transactionRepository.findAll().stream().map(TransactionDTO::new).toList();
    }

}
