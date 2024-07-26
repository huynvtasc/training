package com.huynv.transaction.service;

import com.huynv.transaction.entity.User;
import com.huynv.transaction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AsyncService {
    @Autowired
    UserRepository repository;
    @Async
//    @Transactional
    public void asyncFunction() {
        User user = User.builder()
                .username("asyncName").fullname("asyncName")
                .password("asyncName").build();
        repository.save(user);
        System.out.println("Before throw exception");
        if (true) throw new RuntimeException("Exception zzzz");
//        return "from asyncFunction";
    }
}