package com.huynv.transaction.controller;

import com.huynv.transaction.entity.User;
import com.huynv.transaction.repository.UserRepository;
import com.huynv.transaction.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/async")
public class AsyncController {
    @Autowired
    private UserRepository repository;
    @Autowired
    private AsyncService asyncService;

    @GetMapping
    @Transactional
    public String testTransactional() throws ExecutionException, InterruptedException {
        User user = User.builder()
                .username("username1").fullname("fullname1")
                .password("123456").build();
        repository.save(user);

//        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        String result = executorService.submit(() -> asyncService.asyncFunction()).get();
//        executorService.submit(() -> asyncService.asyncFunction());
        asyncService.asyncFunction();

        System.out.println("After throw exception");
        return "hehee";
    }
}
