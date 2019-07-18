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
public class TaxesTest {

    @Test
    public void arrondiPrix() {

        BigDecimal roundedPrice = new BigDecimal(1.05);
        assertEquals(Taxe.arrondiPrix(new BigDecimal(0.99)), new BigDecimal(1.00).setScale(2, RoundingMode.HALF_UP));
        assertEquals(Taxe.arrondiPrix(new BigDecimal(1.00)), new BigDecimal(1.00).setScale(2, RoundingMode.HALF_UP));
        assertEquals(Taxe.arrondiPrix(new BigDecimal(1.01)), roundedPrice.setScale(2, RoundingMode.HALF_UP));
        assertEquals(Taxe.arrondiPrix(new BigDecimal(1.02)), roundedPrice.setScale(2, RoundingMode.HALF_UP));
    }
    @Test
    public void calculerTaxe(){
        BigDecimal price = new BigDecimal(5);
        BigDecimal rate = new BigDecimal(0.1);
        BigDecimal importedRate = new BigDecimal(0.05);
        Taxe taxe = new Taxe(price, rate, importedRate);
        assertEquals(taxe.calculerTaxe(), new BigDecimal(0.85).setScale(2, RoundingMode.HALF_UP));

    }
}
