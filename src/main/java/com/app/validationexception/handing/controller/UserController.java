package com.app.validationexception.handing.controller;

import com.app.validationexception.handing.dto.UserRequest;
import com.app.validationexception.handing.entity.User;
import com.app.validationexception.handing.exception.UserNotFoundException;
import com.app.validationexception.handing.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/singUp")
    public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest userRequest){
        return new ResponseEntity<>(userService.saveUser(userRequest), HttpStatus.CREATED);
    }

    @GetMapping("/fetchAllUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }

    @GetMapping("/fetchOneUser/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable int id) throws UserNotFoundException {

        return new ResponseEntity<>(userService.getUser(id),HttpStatus.OK);
    }
}
