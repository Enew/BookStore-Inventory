package com.novisoftware.service;

import com.novisoftware.domain.dto.UserDto;
import com.novisoftware.domain.dto.UserRegistrationDto;

public interface UserService {
    UserDto createUser(UserRegistrationDto registrationDto);
    UserDto getUserById(Long userId);
}
