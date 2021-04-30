package com.example.demo.service;


import com.example.demo.vo.ProductMasterData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Mapper
public interface ProductMetasDataService {

    /**
     * 查询所有产品主数据
     * @return
     */
    List<ProductMasterData> quetyByALL();



}
