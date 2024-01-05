package com.novisoftware.application;

import com.novisoftware.domain.dto.UserDto;
import com.novisoftware.domain.dto.UserRegistrationDto;
import com.novisoftware.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserRegistrationDto userDto) {
        UserDto createdUser = userService.createUser(userDto);
        return ResponseEntity.ok(createdUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUserDetails(@PathVariable Long userId) {
        UserDto userDetails = userService.getUserById(userId);
        return ResponseEntity.ok(userDetails);
    }
}
