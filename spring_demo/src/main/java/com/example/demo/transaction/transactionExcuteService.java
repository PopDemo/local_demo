package com.example.demo.transaction;

import com.example.demo.transaction.db.DBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Component
public class transactionExcuteService {

    @Autowired private DBService dbService;

    /**
     * fix: Spring事务相关的projectDemo
     */

    @Transactional(propagation = Propagation.REQUIRED)
    public String queryByMobile(String mobile){

        String memberId = dbService.queryMemberById(mobile);

        return memberId;
    }



}
