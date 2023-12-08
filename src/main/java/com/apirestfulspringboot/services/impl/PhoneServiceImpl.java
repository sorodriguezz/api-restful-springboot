package com.apirestfulspringboot.services.impl;

import com.apirestfulspringboot.dto.PhoneRequestDto;
import com.apirestfulspringboot.entities.Phone;
import com.apirestfulspringboot.entities.Users;
import com.apirestfulspringboot.repository.PhoneRepository;
import com.apirestfulspringboot.services.PhoneService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PhoneServiceImpl implements PhoneService {

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public List<Phone> saveAll(List<PhoneRequestDto> list, Users user) {
        log.info("[saveAll]::start of method");
        List<Phone> phones = new ArrayList<>();

        for (PhoneRequestDto item : list) {
            Phone phone = new Phone();

            phone.setNumber(item.getNumber());
            phone.setCountryCode(item.getCountrycode());
            phone.setCityCode(item.getCitycode());
            phone.setIdUser(user);

            phones.add(phone);
        }

        phoneRepository.saveAll(phones);

        log.info("[saveAll]::end of method");

        return phones;
    }
}
