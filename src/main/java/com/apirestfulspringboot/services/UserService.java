package com.apirestfulspringboot.services;

import com.apirestfulspringboot.dto.UserRequestDto;
import com.apirestfulspringboot.entities.Users;

public interface UserService {
   public Users save(UserRequestDto userDto);
}
