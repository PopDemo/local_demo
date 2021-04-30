package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/get")
public class ProductResource {


    @Autowired
    private ProductService productService;

    @PostMapping("/get")
    public List<ProductDTO> queryById(String pid){
        return productService.queryById(pid);
    }








}
