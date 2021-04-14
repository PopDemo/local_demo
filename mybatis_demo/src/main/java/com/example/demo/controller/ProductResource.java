package com.example.demo.controller;

import com.example.demo.dto.ProductDTO;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/product")
public class ProductResource {


    @Autowired
    private ProductService productService;

    @GetMapping("/get")
    public ProductDTO queryById(String pid){
        return productService.queryById(pid);
    }





}
