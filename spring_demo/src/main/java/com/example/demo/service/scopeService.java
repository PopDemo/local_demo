package com.example.demo.service;

import com.example.demo.scope.man;
import com.example.demo.scope.manDouble;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class scopeService implements CommandLineRunner {

    @Autowired
    private man man1;


    @Autowired
    private manDouble man2;


    @Override
    public void run(String... args) throws Exception {
        log.info("man1 ---> {}:{}", man1 = man1);
    }
}
