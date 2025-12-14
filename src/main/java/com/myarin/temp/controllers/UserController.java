package com.myarin.temp.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.myarin.temp.dtos.UserDto;
import com.myarin.temp.models.UserModel;
import com.myarin.temp.repositories.UserRepository;




@RestController
public class UserController {
    
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @GetMapping("/users")
    public List<UserDto> getUsers() {
        return userRepository.getUsers().stream()
            .map(userModel -> new UserDto(userModel.getName(), userModel.getEmail()))
            .toList();
    }

    @GetMapping("/users/{id}")
    public UserDto getUserById(@PathVariable String id) {
        return userRepository.getUsers().stream()
            .filter(userModel -> userModel.getId().equals(id))
            .findFirst()
            .map(userModel -> new UserDto(userModel.getName(), userModel.getEmail()))
            .orElse(null);
    }
    
    @PostMapping("/users")
    public String creatUser(@RequestBody UserDto userDto) {
        userRepository.addUser(new UserModel(userDto.getName(), userDto.getEmail()));
        return "User created successfully";
    }
    
    @PutMapping("users/{id}")
    public String updateUser(@PathVariable String id, @RequestBody UserDto userDto) {
        UserModel updatedUser = new UserModel(id, userDto.getName(), userDto.getEmail());
        userRepository.editUser(updatedUser);
        return "User updated successfully";
    }
}
