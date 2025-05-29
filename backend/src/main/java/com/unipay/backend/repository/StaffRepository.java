package com.unipay.backend.repository;

import com.unipay.backend.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Integer> {
    //UPDATED ATTEMPTED FIX -- removed findByUserId because there's no 'userId' property in Staff entity
}
