package com.ashish.springboottestdemo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.ashish.springboottestdemo.SpringBootTestDemoApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = SpringBootTestDemoApplication.class)
@AutoConfigureMockMvc
public class ProductControllerTest {

	@Autowired
	private MockMvc mvc;

	@LocalServerPort
	private int port;

	@Test
	public void test_allProduct() throws Exception {
		mvc.perform(get("/products").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON)).andDo(print())
				.andExpect(MockMvcResultMatchers.jsonPath("$.status").value("SUCCESS"))
				.andExpect(MockMvcResultMatchers.jsonPath("$.body[0].productId").exists())
				.andExpect(MockMvcResultMatchers.jsonPath("$.body[0].productName").value("Product1"));
	}

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void test_allProduct1() throws Exception {
		String response = this.restTemplate.getForObject("http://localhost:" + port + "/products", 
				String.class);
		System.out.println(response);
		assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/products", String.class))
				.contains("SUCCESS");
	}
}
