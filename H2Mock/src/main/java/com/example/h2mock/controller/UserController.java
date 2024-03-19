package com.example.h2mock.controller;

import com.example.h2mock.entity.User;
import com.example.h2mock.services.IUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * User controller.
 */
@RestController
public class UserController {

    /**
     * user service.
     */
    private final IUserService userService;

    /**
     * init.
     *
     * @param userService2 user service
     */
    public UserController(final IUserService userService2) {
        this.userService = userService2;
    }

    /**
     * find user list.
     *
     * @return list
     */
    @GetMapping("user/list")
    public ResponseEntity<List<User>> list() {
        return ResponseEntity.ok(userService.findAll());
    }
}