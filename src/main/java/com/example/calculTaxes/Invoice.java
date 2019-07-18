package com.example.calculTaxes;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static java.util.Objects.requireNonNull;
import static java.util.stream.Collectors.joining;

public class Invoice {
    private List<Product> products = new ArrayList<>();

    public Invoice add(Product product) {
        products.add(requireNonNull(product));
        return this;
    }

    public BigDecimal calculerTotalMontant() {
        return products.stream().map(Product::calculerPrixTTC).reduce(BigDecimal::add).get();
    }

    public BigDecimal calculerTotalTaxes() {
        return products.stream().map(Product::getTaxe).reduce(BigDecimal::add).get();
    }

    public String toString() {
        return new StringJoiner("\n")
                .add(products.stream().map(Product::toString).collect(joining("\n")))
                .add("Montant des taxes : " + calculerTotalTaxes())
                .add("Total : " + calculerTotalMontant())
                .toString();
    }
}
