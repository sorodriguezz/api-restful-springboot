package com.apirestfulspringboot.repository;

import com.apirestfulspringboot.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, String> {
}
