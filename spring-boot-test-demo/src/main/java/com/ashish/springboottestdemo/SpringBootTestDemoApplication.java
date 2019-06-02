package com.ashish.springboottestdemo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ashish.springboottestdemo.bean.Product;
import com.ashish.springboottestdemo.dao.ProductRepo;

@SpringBootApplication
public class SpringBootTestDemoApplication implements CommandLineRunner {
	
	@Autowired
	private ProductRepo productRepo;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Product p1 = new Product(1,"Product1", "Pending", true);
		Product p2 = new Product(2,"Product2", "Configured", false);
		Product p3 = new Product(3,"Product3", "Configured", true);
		Product p4 = new Product(4,"Product4", "PartialConfigured", true);
		Product p5 = new Product(5,"Product5", "PartialConfigured", false);
		Product p6 = new Product(6,"Product6", "Pending", true);
		Product p7 = new Product(7,"Product7", "Pending", false);
		
		productRepo.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7));
	}

}
