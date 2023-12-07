package com.apirestfulspringboot.services.impl;

import com.apirestfulspringboot.dto.UserRequestDto;
import com.apirestfulspringboot.entities.Users;
import com.apirestfulspringboot.repository.UserRepository;
import com.apirestfulspringboot.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users save(UserRequestDto userDto) {
        log.info("[save]::start of method");
        Date now = new Date();

        Users model = new Users();
        model.setName(userDto.getName());
        model.setEmail(userDto.getEmail());
        model.setPassword(userDto.getPassword());
        model.setCreated(now);
        model.setLastLogin(now);
        model.setModified(now);
        model.setActive(true);

        model = userRepository.save(model);
        //phoneService.saveAll(userDto.getPhones(), model);
        log.info("[save]::end of method");
        return model;
    }
}
