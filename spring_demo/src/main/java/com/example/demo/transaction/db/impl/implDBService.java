package com.example.demo.transaction.db.impl;

import com.example.demo.transaction.db.DBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class implDBService implements DBService {

    @Autowired private JdbcTemplate jdbcTemplate;

    @Override
    @Transactional(propagation = Propagation.NESTED)
    public String queryMemberById(String mobile) {
        String sql = "select member_id as memberId from plt_skx_member where mobilephone = ?";
        SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql,mobile);
        while (sqlRowSet.next()) {
            log.info("通过mobile:{},查询会员成功",mobile);
            String memberId = sqlRowSet.getString("memberId");
            return memberId;
        }
        return null;
    }
}
