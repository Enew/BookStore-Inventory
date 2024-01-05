package com.novisoftware.application.mapper;

import com.novisoftware.domain.dto.UserDto;
import com.novisoftware.domain.dto.UserRegistrationDto;
import com.novisoftware.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User createUserFromRegistrationDto(UserRegistrationDto registrationDto) {
        User user = new User();
        user.setUsername(registrationDto.getUsername());
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        return user;
    }

    public UserDto buildUserDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}