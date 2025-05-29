package com.unipay.backend.service;

import com.unipay.backend.dto.AnnouncementDTO;
import com.unipay.backend.dto.CustomerDTO;
import com.unipay.backend.dto.StaffDTO;

import com.unipay.backend.entity.Announcement;
import com.unipay.backend.entity.Customer;
import com.unipay.backend.entity.Staff;
import com.unipay.backend.entity.Wallet;

import com.unipay.backend.repository.AnnouncementRepository;
import com.unipay.backend.repository.CustomerRepository;
import com.unipay.backend.repository.StaffRepository;
import com.unipay.backend.repository.WalletRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HomePageService {

    private final CustomerRepository customerRepository;
    private final StaffRepository staffRepository;
    private final WalletRepository walletRepository;
    private final AnnouncementRepository announcementRepository;

    @Autowired
    public HomePageService(CustomerRepository customerRepository,
                           StaffRepository staffRepository,
                           WalletRepository walletRepository,
                           AnnouncementRepository announcementRepository) {
        this.customerRepository = customerRepository;
        this.staffRepository = staffRepository;
        this.walletRepository = walletRepository;
        this.announcementRepository = announcementRepository;
    }

    public CustomerDTO getCustomerHomePageData(Integer userId) {
        CustomerDTO dto = new CustomerDTO();

        //to find customer by userId
        Optional<Customer> customerOpt = customerRepository.findById(userId);
        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            dto.setUserId(customer.getId());
            dto.setFirstName(customer.getFirstName());
            dto.setLastName(customer.getLastName());
            dto.setStudentId(customer.getStudentId());

            //to get wallet information
            Optional<Wallet> walletOpt = walletRepository.findByCustomer_Id(userId);

            walletOpt.ifPresent(wallet -> {
                dto.setWalletBalance(wallet.getBalance());
                dto.setWalletPoints(wallet.getPoints());
            });
        }

        //to get announcements (limit to 5)
        List<Announcement> announcements = announcementRepository.findAll();
        if (announcements.size() > 5) {
            announcements = announcements.subList(0, 5);
        }

        List<AnnouncementDTO> announcementDTOs = announcements.stream().map(announcement -> {
            AnnouncementDTO dtoA = new AnnouncementDTO();
            dtoA.setId(announcement.getId());
            dtoA.setTitle(announcement.getTitle());
            dtoA.setContent(announcement.getContent());
            dtoA.setCreatedAt(announcement.getCreatedAt());
            if (announcement.getCreator() != null) {
                dtoA.setCreatorName(announcement.getCreator().getFirstName() + " " + announcement.getCreator().getLastName());
            }
            return dtoA;
        }).collect(Collectors.toList());

        dto.setAnnouncements(announcementDTOs);
        return dto;
    }

    public StaffDTO getStaffHomePageData(Integer userId) {
        Staff staff = staffRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Staff not found with id: " + userId));

        StaffDTO dto = new StaffDTO();
        dto.setUserId(staff.getId());
        dto.setFirstName(staff.getFirstName());
        dto.setLastName(staff.getLastName());
        dto.setPosition(staff.getPosition());
        dto.setDepartment(staff.getDepartment());

        //to get announcements (limit to 5)
        List<Announcement> announcements = announcementRepository.findAll();
        if (announcements.size() > 5) {
            announcements = announcements.subList(0, 5);
        }

        List<AnnouncementDTO> announcementDTOs = announcements.stream().map(announcement -> {
            AnnouncementDTO dtoA = new AnnouncementDTO();
            dtoA.setId(announcement.getId());
            dtoA.setTitle(announcement.getTitle());
            dtoA.setContent(announcement.getContent());
            dtoA.setCreatedAt(announcement.getCreatedAt());
            if (announcement.getCreator() != null) {
                dtoA.setCreatorName(announcement.getCreator().getFirstName() + " " + announcement.getCreator().getLastName());
            }
            return dtoA;
        }).collect(Collectors.toList());

        dto.setAnnouncements(announcementDTOs);
        return dto;
    }
}
