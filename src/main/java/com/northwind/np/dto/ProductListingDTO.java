package com.northwind.np.dto;

import com.northwind.np.entities.ProductEntity;

import java.math.BigDecimal;

public class ProductListingDTO {

    private String categoryName;
    private String productName;
    private String quantityPerUnit;
    private BigDecimal unitPrice;

    public ProductListingDTO(ProductEntity productEntity) {
        this.categoryName = productEntity.getCategoryID().getCategoryName();
        this.productName = productEntity.getProductName();
        this.quantityPerUnit = productEntity.getQuantityPerUnit();
        this.unitPrice = productEntity.getUnitPrice();
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getProductName() {
        return productName;
    }

    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }
}
