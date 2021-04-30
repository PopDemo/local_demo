package com.example.demo.dto;

import lombok.Data;


/**
 * 产品主数据
 * ORM表
 * DTO
 */
@Data
public class ProductMetasDataDTO {
    private Integer id;
    private String product_id;
    private String career_classification_id;
    private String vendor_band_id;
    private String product_classification_id;
    private String product_name_id;
    private String product_gauge_id;
    private String creator;
    private String creation_date;
    private String update_date;
    private String update_man;
    // 0 使用中
    private Integer deleted;
}
