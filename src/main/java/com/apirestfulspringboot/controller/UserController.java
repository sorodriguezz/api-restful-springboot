package com.apirestfulspringboot.controller;

import com.apirestfulspringboot.dto.UserRequestDto;
import com.apirestfulspringboot.entities.Users;

public interface UserController {

    public Users registerUser(UserRequestDto req);
}
