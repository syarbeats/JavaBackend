package com.backend.controller;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
 
import org.junit.Test;
 
public class DomisiliServicesTesting {
	
	
	@Test
	public void testGetDataKelurahanByIdSuccess() {
		
		expect().
			//body("id", equalTo(2)).
			body("kota", equalTo("[Kota Bandung]")).
			body("kelurahan", equalTo("Antapani Kulon")).
			body("kecamatan", equalTo("Antapani")).
		when().
			get("/java-testing/jasamedika/domisili/datakelurahan/2");
	}
 
	
	 
	@Test
	public void testDataKelurahanByIdNotFound() {
		
		expect().
			body(nullValue()).
		when().
			get("/java-testing/jasamedika/domisili/datakelurahan/200");
	}
}
