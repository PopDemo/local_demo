package com.example.demo.scope;


import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Scope("prototype")
@Component
public class manDouble {

    private String age;
    private String gender;
    private String color;
    private String height;;








}
