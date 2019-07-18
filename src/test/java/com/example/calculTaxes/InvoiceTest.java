package com.example.calculTaxes;

import org.junit.*;
import org.junit.runner.*;
import static org.junit.Assert.assertEquals;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InvoiceTest {

    Invoice invoice = new Invoice();
    Invoice invoice2 = new Invoice();
    Invoice invoice3 = new Invoice();

    @Before
    public void init() {

        // Input 1
        Product product = new Product("livre", new BigDecimal(12.49).setScale(2, RoundingMode.HALF_UP), ProductType.BOOK, ProductCategory.DOMESTIC);
        Product product2 = new Product("CD misical", new BigDecimal(14.99).setScale(2, RoundingMode.HALF_UP), ProductType.OTHER, ProductCategory.DOMESTIC);
        Product product3 = new Product("barre de chocolat", new BigDecimal(0.85).setScale(2, RoundingMode.HALF_UP), ProductType.FOOD, ProductCategory.DOMESTIC);

        invoice.add(product);
        invoice.add(product2);
        invoice.add(product3);
        // Input 2

        Product product4 = new Product("boîte de chocolats importée", new BigDecimal(10.00).setScale(2, RoundingMode.HALF_UP), ProductType.FOOD, ProductCategory.IMPORTED);
        Product product5 = new Product("flacon de parfum importé", new BigDecimal(47.50).setScale(2, RoundingMode.HALF_UP), ProductType.OTHER, ProductCategory.IMPORTED);

        invoice2.add(product4);
        invoice2.add(product5);
        // Input 3

        Product product6 = new Product("flacon de parfum importé", new BigDecimal(27.99).setScale(2, RoundingMode.HALF_UP), ProductType.OTHER, ProductCategory.IMPORTED);
        Product product7 = new Product("flacon de parfum", new BigDecimal(18.99).setScale(2, RoundingMode.HALF_UP), ProductType.OTHER, ProductCategory.DOMESTIC);
        Product product8 = new Product("boîte de pilules contre la migraine", new BigDecimal(9.75).setScale(2, RoundingMode.HALF_UP), ProductType.FOOD, ProductCategory.DOMESTIC);
        Product product9 = new Product("boîte de chocolats importés", new BigDecimal(11.25).setScale(2, RoundingMode.HALF_UP), ProductType.FOOD, ProductCategory.IMPORTED);

        invoice3.add(product6);
        invoice3.add(product7);
        invoice3.add(product8);
        invoice3.add(product9);
    }

    @Test
    public void calcalculerTotalTaxes() {

        assertEquals(invoice.calculerTotalTaxes(), new BigDecimal(1.50).setScale(2, RoundingMode.HALF_UP));
        assertEquals(invoice2.calculerTotalTaxes(), new BigDecimal(7.65).setScale(2, RoundingMode.HALF_UP));
        assertEquals(invoice3.calculerTotalTaxes(), new BigDecimal(6.70).setScale(2, RoundingMode.HALF_UP));
    }

    @Test
    public void calculerTotalMontant() {

        assertEquals(invoice.calculerTotalMontant(), new BigDecimal(29.83).setScale(2, RoundingMode.HALF_UP));
        assertEquals(invoice2.calculerTotalMontant(), new BigDecimal(65.15).setScale(2, RoundingMode.HALF_UP));
        assertEquals(invoice3.calculerTotalMontant(), new BigDecimal(74.68).setScale(2, RoundingMode.HALF_UP));
    }

}
