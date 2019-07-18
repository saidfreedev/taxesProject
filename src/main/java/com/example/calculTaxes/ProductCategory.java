package com.example.calculTaxes;

import java.math.BigDecimal;

public enum ProductCategory {
    IMPORTED {
        @Override
        public BigDecimal getRateValue() {
            return  new BigDecimal("0.05");
        }
    },
    DOMESTIC {
        @Override
        public BigDecimal getRateValue() {
            return BigDecimal.ZERO;
        }
    };

    public abstract BigDecimal getRateValue();

}
