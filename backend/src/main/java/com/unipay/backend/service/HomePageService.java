package com.unipay.backend.service;

import com.unipay.backend.dto.AnnouncementDTO;
import com.unipay.backend.dto.CustomerHomePageDTO;
import com.unipay.backend.dto.StaffHomePageDTO;
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

    public CustomerHomePageDTO getCustomerHomePageData(Integer userId) {
        CustomerHomePageDTO dto = new CustomerHomePageDTO();
        
        //section: to get customer data
        Customer customer = customerRepository.findByUserId(userId);
        if (customer != null) {
            dto.setFirstName(customer.getFirstName());
            dto.setLastName(customer.getLastName());
            dto.setStudentId(customer.getStudentId());
            dto.setFaculty(customer.getFaculty());
        }
        
        //section: to get wallet data
        Wallet wallet = walletRepository.findByUserId(userId);
        if (wallet != null) {
            dto.setWalletBalance(wallet.getBalance());
            dto.setWalletPoints(wallet.getPoints());
            dto.setLastWalletUpdate(wallet.getLastUpdated());
        }
        
        //section: to get announcements
        List<Announcement> announcements = announcementRepository.findActiveCustomerAnnouncements();
        List<AnnouncementDTO> announcementDTOs = new ArrayList<>();
        
        for (Announcement announcement : announcements) {
            AnnouncementDTO announcementDTO = new AnnouncementDTO();
            announcementDTO.setId(announcement.getId());
            announcementDTO.setTitle(announcement.getTitle());
            announcementDTO.setContent(announcement.getContent());
            announcementDTO.setTargetAudience(announcement.getTargetAudience());
            announcementDTO.setCreatedAt(announcement.getCreatedAt());
            announcementDTO.setExpiresAt(announcement.getExpiresAt());
            
            if (announcement.getCreator() != null) {
                announcementDTO.setCreatorName(announcement.getCreator().getFirstName() + " " + announcement.getCreator().getLastName());
            }
            
            announcementDTOs.add(announcementDTO);
        }
        
        dto.setAnnouncements(announcementDTOs);
        
        return dto;
    }

    public StaffHomePageDTO getStaffHomePageData(Integer userId) {
        StaffHomePageDTO dto = new StaffHomePageDTO();
        
        //section: to get staff data
        Staff staff = staffRepository.findByUserId(userId);
        if (staff != null) {
            dto.setFirstName(staff.getFirstName());
            dto.setLastName(staff.getLastName());
            dto.setPosition(staff.getPosition());
            dto.setDepartment(staff.getDepartment());
            dto.setHireDate(staff.getHireDate());
        }
        
        //section: to get announcements
        List<Announcement> announcements = announcementRepository.findActiveStaffAnnouncements();
        List<AnnouncementDTO> announcementDTOs = new ArrayList<>();
        
        for (Announcement announcement : announcements) {
            AnnouncementDTO announcementDTO = new AnnouncementDTO();
            announcementDTO.setId(announcement.getId());
            announcementDTO.setTitle(announcement.getTitle());
            announcementDTO.setContent(announcement.getContent());
            announcementDTO.setTargetAudience(announcement.getTargetAudience());
            announcementDTO.setCreatedAt(announcement.getCreatedAt());
            announcementDTO.setExpiresAt(announcement.getExpiresAt());
            
            if (announcement.getCreator() != null) {
                announcementDTO.setCreatorName(announcement.getCreator().getFirstName() + " " + announcement.getCreator().getLastName());
            }
            
            announcementDTOs.add(announcementDTO);
        }
        
        dto.setAnnouncements(announcementDTOs);
        
        return dto;
    }
}