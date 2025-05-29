package com.unipay.backend.repository;

import com.unipay.backend.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement, Integer> {
    List<Announcement> findTop5ByOrderByCreatedAtDesc();
}