package com.apirestfulspringboot.controller.impl;

import com.apirestfulspringboot.controller.UserController;
import com.apirestfulspringboot.dto.UserRequestDto;
import com.apirestfulspringboot.entities.Users;
import com.apirestfulspringboot.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@Slf4j
@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;

    @Override
    @PostMapping("/register")
    public Users registerUser(@Valid @RequestBody UserRequestDto req) {
        log.info("[registerUser] :: method start");
        Users user = userService.save(req);
        log.info("[registerUser] :: method end");
        return user;
    }
}
