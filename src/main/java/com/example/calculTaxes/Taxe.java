package com.example.calculTaxes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Taxe {

    private static final BigDecimal ROUND_0_05 = new BigDecimal("0.05");
    private static final BigDecimal ROUND_0_00 = new BigDecimal("0.00");

    BigDecimal price;
    BigDecimal rate;
    BigDecimal importedRate;

    /**
     * constructor
     * @param price
     * @param rate
     * @param importedRate
     */
    public Taxe(BigDecimal price, BigDecimal rate, BigDecimal importedRate) {
        this.price = Objects.requireNonNull(price);
        this.rate = Objects.requireNonNull(rate);
        this.importedRate = Objects.requireNonNull(importedRate);
    }
    /***
     * Le montant de chacune des taxes est arrondi aux 5 cents supérieurs
     * @param price
     * @return
     */
    public static BigDecimal arrondiPrix(BigDecimal price) {

        BigDecimal value = price.setScale(2, RoundingMode.CEILING);
        BigDecimal reminder = value.remainder(ROUND_0_05);
        return reminder.equals(ROUND_0_00) ? value : value.add(ROUND_0_05.subtract(reminder));

    }

    /**
     *
     * @return
     */
    public BigDecimal calculerTaxe(){
        return arrondiPrix(price.multiply(rate))
                .add(arrondiPrix(price.multiply(importedRate)));
    }
    }
