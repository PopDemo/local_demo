package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cache.annotation.Cacheable;

import java.util.Date;
import java.util.Objects;

/**
 * @program: skq
 * @description
 * @author: Zhanghu
 * @create: 2021-04-16 15:04
 **/
@Getter
@Setter
@AllArgsConstructor
public class MemberBind implements Comparable<MemberBind>{

    private String memberId;
    private String platCode;
    private Date createTime;
    private String source;
    private Boolean status;

    @Override
    public int compareTo(MemberBind o) {
        return this.createTime.compareTo(o.getCreateTime());
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberBind that = (MemberBind) o;
        return memberId.equals(that.memberId) &&
                platCode.equals(that.platCode) &&
                createTime.equals(that.createTime) &&
                source.equals(that.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, platCode, createTime, source);
    }


}
