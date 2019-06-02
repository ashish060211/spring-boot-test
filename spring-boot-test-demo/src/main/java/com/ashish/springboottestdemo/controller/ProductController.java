package com.ashish.springboottestdemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashish.springboottestdemo.bean.Product;
import com.ashish.springboottestdemo.dao.ProductRepo;
import com.ashish.springboottestdemo.wrapper.Response;

@RestController
public class ProductController {

	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductRepo productRepo;
	
	private static String INVALID_INPUT_MSG = "invalid input pass.";
	private static String SUCCESS_MSG = "operation successfully executed.";
	private static String SERVER_ERROR_MSG = "server error occur. please contact admin.";
	
	
	@GetMapping("/products")
	public ResponseEntity<Response<List<Product>>> getProducts() {

		Response<List<Product>> response = null;
		org.springframework.http.HttpStatus httpstatus;
		try {

			log.info("getProducts  called...");
			List<Product> responseBody = productRepo.findAll();
			response = Response.success(SUCCESS_MSG, responseBody);
			httpstatus = CollectionUtils.isEmpty(responseBody)
					? org.springframework.http.HttpStatus.NOT_FOUND
							: org.springframework.http.HttpStatus.OK;
			return new ResponseEntity<>(response, httpstatus);
		} catch (Exception ex) {
			log.error("Error occur while executing getProducts : ", ex);
			response = Response.error(SERVER_ERROR_MSG);
			httpstatus = HttpStatus.INTERNAL_SERVER_ERROR;
			return new ResponseEntity<>(response, httpstatus);
		}
	}
}
