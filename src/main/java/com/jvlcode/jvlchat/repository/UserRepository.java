package com.jvlcode.jvlchat.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvlcode.jvlchat.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByUnameAndPhone(String uname, String phone);

}