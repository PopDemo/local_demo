package com.example.demo.vo;

import lombok.Data;

import java.util.Date;


@Data
public class ProductMasterData {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 产品大类名称
     */
    private String productCategories;
    /**
     * 事业分类名称
     */
    private String careerClassification;
    /**
     * 厂商， 品牌
     */
    private String vendorBand;
    /**
     * 产品分类
     */
    private String productClassification;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 产品品规
     */
    private String productGauge;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建时间
     */
    private Date creationDate;
    /**
     * 修改时间
     */
    private Date updateDate;
    /**
     * 修改人
     */
    private String updateMan;
    /**
     * 刪除狀態
     */
    private Integer deleted;

}