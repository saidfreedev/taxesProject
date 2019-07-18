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
public class ProductTest {

    @Test
    public void calculerPrixTTC(){
        Product product = new Product("livre", new BigDecimal(12.49).setScale(2, RoundingMode.HALF_UP),ProductType.BOOK, ProductCategory.DOMESTIC);
        Product product2 = new Product("CD misical", new BigDecimal(14.99).setScale(2, RoundingMode.HALF_UP),ProductType.OTHER, ProductCategory.DOMESTIC);
        Product product3 = new Product("boîte de chocolats importés", new BigDecimal(11.25).setScale(2, RoundingMode.HALF_UP),ProductType.FOOD, ProductCategory.IMPORTED);

        assertEquals(product.calculerPrixTTC(), new BigDecimal(12.49).setScale(2, RoundingMode.HALF_UP));
        assertEquals(product2.calculerPrixTTC(), new BigDecimal(16.49).setScale(2, RoundingMode.HALF_UP));
        assertEquals(product3.calculerPrixTTC(), new BigDecimal(11.85).setScale(2, RoundingMode.HALF_UP));
    }
}
