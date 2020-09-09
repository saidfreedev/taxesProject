package com.example.calculTaxes;

import java.math.BigDecimal;
import static java.util.Objects.requireNonNull;
import static java.math.BigDecimal.ZERO;
import java.math.RoundingMode;

public class Product {
    private String name;
    private BigDecimal price;
    private ProductType productType;
    private ProductCategory productCategory;

    public Product(String name, BigDecimal price, ProductType productType, ProductCategory productCategory) {
        this.name = requireNonNull(name) ;
        this.price = requireNonNull(price);
        this.productType = requireNonNull(productType);
        this.productCategory = requireNonNull(productCategory);
        assert price.compareTo(ZERO) >= 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal calculerPrixTTC(){
       // Taxe taxe = new Taxe(price, getProductType().getRateValue(), getProductCategory().getRateValue());
        return price.add(getTaxe()).setScale(2, RoundingMode.FLOOR);
    }

    public BigDecimal getTaxe(){
        return new Taxe(price, productType.getRateValue(), productCategory.getRateValue()).calculerTaxe();
    }
    @Override
    public String toString() {
        return "1 " + getName() + " : " + calculerPrixTTC();
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public void testRebase(){
        System.out.println("first commit");
    }
}
