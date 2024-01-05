package com.novisoftware.service.impl;

import com.novisoftware.application.mapper.UserMapper;
import com.novisoftware.domain.dto.UserDto;
import com.novisoftware.domain.dto.UserRegistrationDto;
import com.novisoftware.domain.model.User;
import com.novisoftware.domain.repository.UserRepository;
import com.novisoftware.exception.UserNotFoundException;
import com.novisoftware.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto createUser(UserRegistrationDto registrationDto) {
        User user = userMapper.createUserFromRegistrationDto(registrationDto);
        userRepository.save(user);

        return userMapper.buildUserDto(user);
    }

    @Override
    public UserDto getUserById(Long userId) {
        return userRepository.findById(userId)
                .map(userMapper::buildUserDto)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
    }
}
