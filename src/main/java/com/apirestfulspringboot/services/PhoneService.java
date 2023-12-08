package com.apirestfulspringboot.services;

import com.apirestfulspringboot.dto.PhoneRequestDto;
import com.apirestfulspringboot.entities.Phone;
import com.apirestfulspringboot.entities.Users;

import java.util.List;

public interface PhoneService {
    public List<Phone> saveAll(List<PhoneRequestDto> list, Users user);
}
