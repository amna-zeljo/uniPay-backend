package com.unipay.backend.dto;

import java.util.List;

public class StaffDTO {
    private Integer userId;
    private String firstName;
    private String lastName;
    private String position;
    private String department;
    private List<AnnouncementDTO> announcements;

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

    public List<AnnouncementDTO> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(List<AnnouncementDTO> announcements) {
        this.announcements = announcements;
    }
}