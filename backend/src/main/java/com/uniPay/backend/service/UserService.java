package com.unipay.backend.service;

import com.unipay.backend.dto.UserDTO;
import com.unipay.backend.entity.Customer;
import com.unipay.backend.entity.Staff;
import com.unipay.backend.entity.User;
import com.unipay.backend.entity.Wallet;
import com.unipay.backend.model.MockUser;
import com.unipay.backend.repository.CustomerRepository;
import com.unipay.backend.repository.StaffRepository;
import com.unipay.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            return null;
        }
        if (!user.getPassword().equals(password)) {
            return null;
        }
        return new UserDTO(user);
    }

    public UserDTO register(UserDTO userDTO) {
        User user=new User();
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setUsername(userDTO.getUsername());
        user.setRole(userDTO.getRole());
        List<String> splitUsername = Arrays.stream(userDTO.getUsername().split(" ")).toList();
        if("STAFF".equals(userDTO.getRole())){
            Staff staff = new Staff();
            staff.setPosition("Assistant");
            staff.setUser(user);
            staff.setFirstName(splitUsername.get(0));
            if(splitUsername.size() > 1){
                staff.setLastName(splitUsername.get(1));
            }
            staff.setFirstName(userDTO.getUsername().split(" ")[0]);
            user.setStaff(staff);
        }else {
            Customer customer = new Customer();
            customer.setFirstName(splitUsername.get(0));
            if(splitUsername.size() > 1){
                customer.setLastName(splitUsername.get(1));
            }
            customer.setStudentId(userDTO.getUsername());
            customer.setUser(user);
            user.setCustomer(customer);

            Wallet wallet = new Wallet();
            wallet.setUser(user);
            double randomNumber = (double) Math.round((Math.random() * 50 + 1) * 100) / 100;
            wallet.setBalance( randomNumber);
            randomNumber = (double) Math.round((Math.random() * 50 + 1) * 100) / 100;
            wallet.setPoints((int) randomNumber);
            user.setWallet(wallet);
        }
        user = userRepository.save(user);

        return new UserDTO(user);

    }

}
