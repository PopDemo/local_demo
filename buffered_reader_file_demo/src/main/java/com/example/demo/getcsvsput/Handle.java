package com.example.demo.getcsvsput;


import com.example.demo.getcsvsput.dto.MemberInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.Resource;
import java.io.*;
import java.lang.reflect.Member;

@Component
@Slf4j
public class Handle {

    @Resource
    private JdbcTemplate jdbcTemplate;



    public void outFileByInfo(String fileName,String outName) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outName)));

        String line = "";
        int lineSize = 0,now = 0;
        while (null != (line = reader.readLine())){
            String newline = "";
            StringBuilder sb = new StringBuilder(line);
            if (0 == lineSize){
                log.info("读取第一行  进行添加handle");
                newline = "会员Id,注册时间,注册渠道,"+line;
            }else {
                String[] lineS = line.split(",");
                MemberInfo memberInfo = getMemberInfoByMobile(lineS[0]);
                if (null != memberInfo){
                    newline = new StringBuffer().append(memberInfo.toString()).append(line).toString();
                    now++;
                }else{
                    newline = new StringBuffer().append(",,,").append(line).toString();
                }

            }

            writer.write(newline);
            writer.write("\n");
            lineSize++;
            if (now % 20 == 0){
                log.info("已映射处理正常会员{}个了",now);
            }
        }
        log.info("已经转换处理了{}条,映射正常会员:{}条,已全部处理完成");
    }

    public MemberInfo getMemberInfoByMobile(String mobile){
        String sql = "select member_id,reg_time,reg_type from plt_skx_member where mobilephone=?";
        SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql,mobile);
        MemberInfo memberInfo = null;
        while (rowSet.next()) {
            memberInfo.setMemberId(rowSet.getString("member_id"));
            memberInfo.setRegTime(rowSet.getString("reg_time"));
            memberInfo.setChannelName(rowSet.getString("reg_type"));
        }
        return memberInfo;
    }

}
