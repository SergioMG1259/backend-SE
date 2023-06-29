package com.OpenCrew.ERentCar.users.application.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.OpenCrew.ERentCar.users.application.dto.LoginDTO;
import com.OpenCrew.ERentCar.users.application.dto.UserDTO;
import com.OpenCrew.ERentCar.users.application.mapper.UserMapper;
import com.OpenCrew.ERentCar.users.application.requests.CreateUser;
import com.OpenCrew.ERentCar.users.domain.services.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    private final UserMapper mapper;

    public UserController(UserService userService, UserMapper mapper) {
        this.userService = userService;
        this.mapper = mapper;
    }
    @PostMapping("register")
    public ResponseEntity<UserDTO> registerUser(@Valid @RequestBody CreateUser request){
        UserDTO userDTO= mapper.toDTO(this.userService.registerUser(request));
        return ResponseEntity.ok(userDTO);
    }
    @PostMapping("login/email/{email}/password/{password}")
    public ResponseEntity<LoginDTO> loginUser(@PathVariable("email")String email,@PathVariable("password")String password){
        LoginDTO userDTO= mapper.toLogin(this.userService.login(email,password));
        return ResponseEntity.ok(userDTO);
    }
    @GetMapping("{userId}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long userId){
        UserDTO userDTO=mapper.toDTO(this.userService.getById(userId));
        return ResponseEntity.ok(userDTO);
    }
}
