package com.unipay.backend.dto;

import java.time.LocalDateTime;
import java.util.List;

public class StaffHomePageDTO {
    private String firstName;
    private String lastName;
    private String position;
    private String department;
    private LocalDateTime hireDate;
    private List<AnnouncementDTO> announcements;
    
    
    public StaffHomePageDTO() {
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDateTime getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDateTime hireDate) {
        this.hireDate = hireDate;
    }

    public List<AnnouncementDTO> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(List<AnnouncementDTO> announcements) {
        this.announcements = announcements;
    }
}