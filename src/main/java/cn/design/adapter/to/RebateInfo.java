package cn.design.adapter.to;

import lombok.Data;

import java.util.Date;

@Data
public class RebateInfo {

    private String userId; // ⽤户ID
    private String bizId; // 业务ID
    private Date bizTime; // 业务时间
    private String desc; // 业务描述

}
