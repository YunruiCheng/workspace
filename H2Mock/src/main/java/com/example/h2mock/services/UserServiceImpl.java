package com.example.h2mock.services;

import com.example.h2mock.dao.UserRepository;
import com.example.h2mock.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User service impl.
 */
@Service
public class UserServiceImpl implements IUserService {

    /**
     * user dao.
     */
    private final UserRepository userRepository;

    /**
     * init.
     *
     * @param userRepository2 user dao
     */
    public UserServiceImpl(final UserRepository userRepository2) {
        this.userRepository = userRepository2;
    }

    /**
     * find all user.
     *
     * @return list
     */
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}