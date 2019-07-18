package com.example.calculTaxes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.math.RoundingMode;

@SpringBootApplication
public class CalculTaxesApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CalculTaxesApplication.class, args);
	}

	@Override
	public void run(String... args){
		Invoice invoice = new Invoice();
		Invoice invoice2 = new Invoice();
		Invoice invoice3 = new Invoice();

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

		System.out.println("### INPUT");
		System.out.println("");

		System.out.println("#### Input 1");
		System.out.println("");
		System.out.println("* 1 "+product.getName() +" à "+product.getPrice());
		System.out.println("* 1 "+product2.getName() +" à "+product2.getPrice());
		System.out.println("* 1 "+product3.getName() +" à "+product3.getPrice());
		System.out.println("");

		System.out.println("#### Input 2");
		System.out.println("");
		System.out.println("* 1 "+product4.getName() +" à "+product4.getPrice());
		System.out.println("* 1 "+product5.getName() +" à "+product5.getPrice());
		System.out.println("");

		System.out.println("#### Input 3");
		System.out.println("* 1 "+product6.getName() +" à "+product6.getPrice());
		System.out.println("* 1 "+product7.getName() +" à "+product7.getPrice());
		System.out.println("* 1 "+product8.getName() +" à "+product8.getPrice());
		System.out.println("* 1 "+product9.getName() +" à "+product9.getPrice());



		System.out.println("### OUTPUT");
		System.out.println("");

		System.out.println("#### Output 1");
		System.out.println("");
		System.out.println(invoice.toString());
		System.out.println("");

		System.out.println("#### Output 2");
		System.out.println("");
		System.out.println(invoice2.toString());
		System.out.println("");

		System.out.println("#### Output 3");
		System.out.println("");
		System.out.println(invoice3.toString());

	}

}
