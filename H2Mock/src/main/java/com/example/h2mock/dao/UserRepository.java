package com.example.h2mock.dao;

import com.example.h2mock.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * user dao.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}