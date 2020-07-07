package com.klysenko.test.hometask3and4.data;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Product {

    private String category;
    private String defaultCategory;
    private String dateValidFrom;
    private String dateValidTo;
    private String name;
    private String code;
    private String sku;
    private String mpn;
    private String gtin;
    private String taric;
    private String manufacturer;
    private String supplier;
    private String keywords;
    private String image;
    private String shortDescription;
    private String description;
    private String technicalData;
    private String headTitle;
    private String metaDescription;
    private String purchasePrice;
    private String currency;
    private String taxClass;
    private String price;



}
