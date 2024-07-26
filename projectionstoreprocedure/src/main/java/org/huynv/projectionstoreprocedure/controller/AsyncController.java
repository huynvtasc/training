package org.huynv.projectionstoreprocedure.controller;

import org.huynv.projectionstoreprocedure.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/async")
public class AsyncController {
    @Autowired
    private AsyncService asyncService;

    @GetMapping
    public String testAsync() throws InterruptedException {
        System.out.println("Before");
        for (int i = 0; i <= 5; i++) {
            asyncService.testAsync();
        }
        System.out.println("After");
        return "Success";
    }
}
