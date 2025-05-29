package com.unipay.backend.dto;

import java.util.List;

public class CustomerDTO {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String studentId;
    private Double walletBalance;
    private Integer walletPoints;
    private List<AnnouncementDTO> announcements;


    public CustomerDTO() {
    }

    public CustomerDTO(Integer userId, String firstName, String lastName, String studentId, 
                      Double walletBalance, Integer walletPoints, List<AnnouncementDTO> announcements) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentId = studentId;
        this.walletBalance = walletBalance;
        this.walletPoints = walletPoints;
        this.announcements = announcements;
    }

    
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public Double getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(Double walletBalance) {
        this.walletBalance = walletBalance;
    }

    public Integer getWalletPoints() {
        return walletPoints;
    }

    public void setWalletPoints(Integer walletPoints) {
        this.walletPoints = walletPoints;
    }

    public List<AnnouncementDTO> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(List<AnnouncementDTO> announcements) {
        this.announcements = announcements;
    }
}