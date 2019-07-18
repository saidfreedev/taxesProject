package com.example.calculTaxes;

import java.math.BigDecimal;

public enum ProductType {
    BOOK{
        @Override
        public BigDecimal getRateValue() {
            return BigDecimal.ZERO;
        }
    },
    OTHER{
        @Override
        public BigDecimal getRateValue() {
            return new BigDecimal("0.1");
        }
    },
    DRUG{
        @Override
        public BigDecimal getRateValue() {
            return BigDecimal.ZERO;
        }
    },
    FOOD;

        public BigDecimal getRateValue() {
            return BigDecimal.ZERO;
        }


}
