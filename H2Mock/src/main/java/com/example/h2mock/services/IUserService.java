package com.example.h2mock.services;


import com.example.h2mock.entity.User;

import java.util.List;

/**
 * user service.
 */
public interface IUserService {

    /**
     * find all user.
     *
     * @return list
     */
    List<User> findAll();
}