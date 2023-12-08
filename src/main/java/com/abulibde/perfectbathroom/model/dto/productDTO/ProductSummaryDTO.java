package com.abulibde.perfectbathroom.model.dto.productDTO;

import java.math.BigDecimal;

public class ProductSummaryDTO {

    private String category;

    private String brand;

    private String model;

    private BigDecimal price;

    public ProductSummaryDTO(String name, String brand, String model, BigDecimal price) {
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
