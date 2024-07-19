package com.huynv.transaction.service;

import com.huynv.transaction.entity.User;
import com.huynv.transaction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveRequireNew() {
        User user = User.builder()
                .username("username2").fullname("fullname2")
                .password("123456").build();

        userRepository.save(user);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveRequire() {
        User user = User.builder()
                .username("username2").fullname("fullname2")
                .password("123456").build();

        userRepository.save(user);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void saveMandatory() {
        User user = User.builder()
                .username("username2").fullname("fullname2")
                .password("123456").build();
        userRepository.save(user);
    }

    @Transactional(propagation = Propagation.NEVER)
    public void saveNever() {
        User user = User.builder()
                .username("username2").fullname("fullname2")
                .password("123456").build();
        userRepository.save(user);
    }
}
