package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ProductService {

    @Select("select * from product where id=#{pid}")
    ProductDTO queryById(@Param("pid") String pid);
}
