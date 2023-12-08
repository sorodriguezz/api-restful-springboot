package com.apirestfulspringboot.services.impl;

import com.apirestfulspringboot.dto.PhoneRequestDto;
import com.apirestfulspringboot.dto.UserRequestDto;
import com.apirestfulspringboot.entities.Phone;
import com.apirestfulspringboot.entities.Users;
import com.apirestfulspringboot.repository.UserRepository;
import com.apirestfulspringboot.services.PhoneService;
import com.apirestfulspringboot.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PhoneService phoneService;

    @Override
    public Users save(UserRequestDto userDto) {
        log.info("[save]::start of method");
        Date now = new Date();

        Users user = new Users();

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setCreated(now);
        user.setModified(now);
        user.setLastLogin(now);
        user.setActive(true);

        Users usersModel = userRepository.save(user);

        List<Phone> phones = phoneService.saveAll(userDto.getPhones(), usersModel);

        List<Phone> phonesList = new ArrayList<>();

        if (userDto.getPhones() != null) {
            for (Phone phoneEntity : phones) {
                Phone phone = new Phone();

                phone.setId(phoneEntity.getId());
                phone.setNumber(phoneEntity.getNumber());
                phone.setCityCode(phoneEntity.getCityCode());
                phone.setCountryCode(phoneEntity.getCountryCode());

                phonesList.add(phone);
            }
        }

        usersModel.setPhones(phonesList);

        log.info("[save]::end of method");

        return usersModel;
    }
}
