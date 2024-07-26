package org.huynv.projectionstoreprocedure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {
    @Async
    public void testAsync() throws InterruptedException {
        Thread.sleep(3000);
        System.out.println(Thread.currentThread().getName() + " Alo alo....");
    }
}
