package com.unipay.backend.repository;

import com.unipay.backend.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {
    @Query("SELECT a FROM Announcement a WHERE a.isActive = true AND (a.targetAudience = 'CUSTOMER' OR a.targetAudience = 'ALL') ORDER BY a.createdAt DESC")
    List<Announcement> findActiveCustomerAnnouncements();
    
    @Query("SELECT a FROM Announcement a WHERE a.isActive = true AND (a.targetAudience = 'STAFF' OR a.targetAudience = 'ALL') ORDER BY a.createdAt DESC")
    List<Announcement> findActiveStaffAnnouncements();
}