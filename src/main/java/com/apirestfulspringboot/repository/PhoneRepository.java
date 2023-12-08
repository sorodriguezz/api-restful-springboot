package com.apirestfulspringboot.repository;

import com.apirestfulspringboot.entities.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, String> {
}
