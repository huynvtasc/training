package com.huynv.transaction;

import com.huynv.transaction.entity.User;
import com.huynv.transaction.repository.UserRepository;
import com.huynv.transaction.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping
@RequiredArgsConstructor
public class TransactionApplication {
    private final UserService service;
    private final UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(TransactionApplication.class, args);
    }

    @GetMapping("/case1")
    @Transactional // Hàm con sẽ không bị ảnh hưởng bởi exception của hàm cha
    public String testRequireNew() {
        User user = User.builder()
                .username("username1").fullname("fullname1")
                .password("123456").build();
        repository.save(user);
        service.saveRequireNew();
        throw new RuntimeException();
    }

    @GetMapping("/case2") // Hàm con và hàm cha cùng chung một transaction
    public String testRequire() {
        User user = User.builder()
                .username("username1").fullname("fullname1")
                .password("123456").build();
        repository.save(user);
        service.saveRequire();
        throw new RuntimeException();
    }

    @GetMapping("/case3")
    @Transactional(readOnly = true) // Nếu @Transactional thì việc thay đổi entity sẽ được đồng bộ vào db
    public String testAutoCommit() {
        User user = repository.findById(4L).get();
        user.setFullname("autocommitttt");
        return "Successful !!!";
    }

    @GetMapping("/case4") // Chỗ này phải có transaction
    @Transactional
    public String testMandatory() {
        service.saveMandatory();
        return "Successful !!!";
    }

    @GetMapping("/case5")
    @Transactional // Chỗ này phải không có transaction
    public String testNever() {
        service.saveNever();
        return "Successful !!!";
    }
}
