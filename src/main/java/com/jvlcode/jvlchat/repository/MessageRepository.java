package com.jvlcode.jvlchat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvlcode.jvlchat.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    List<Message> findAllByOrderByIdAsc();

}