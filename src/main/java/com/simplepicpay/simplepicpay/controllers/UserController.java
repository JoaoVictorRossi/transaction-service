package com.simplepicpay.simplepicpay.controllers;

import com.simplepicpay.simplepicpay.domain.user.User;
import com.simplepicpay.simplepicpay.dtos.UserDTO;
import com.simplepicpay.simplepicpay.dtos.details.UserDetailsDTO;
import com.simplepicpay.simplepicpay.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDetailsDTO> save(@RequestBody @Valid UserDTO userDTO, UriComponentsBuilder uriBuilder) {
        User user = userService.saveUser(new User(userDTO));
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(new UserDetailsDTO(user));
    }

    @GetMapping
    public ResponseEntity<List<UserDetailsDTO>> getAll() {
        List<User> users = this.userService.getAll();
        return ResponseEntity.ok(users.stream().map(UserDetailsDTO::new).toList());
    }


}
