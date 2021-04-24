package com.example.demo.service;

import com.example.demo.dto.ProductDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProductService {

    @Select("select * from product")
    List<ProductDTO> queryById(@Param("pid") String pid);
}
