package com.backend.controller;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;
 
import org.junit.Test;

public class RegistrasiPasienServicesTesting {
	
	/*  Positif Unit testing for registrasi pasien service   
	 *  Get Pasien data By Id
	 *  Using dummy data (Hard-coded Data)
	 * */
	 
	@Test
	public void testGetDataPasienByIdSuccess() {
		
		expect().
			body("id", equalTo(1611000001)).
			body("nama", equalTo("John Lennon")).
			body("alamat", equalTo("JL. Antabaru no.09")).
			body("no_telepon", equalTo("0876548723")).
			body("rtrw", equalTo("01/02")).
			body("kelurahan", equalTo("Antapani Kidul")).
			body("tanggal_lahir", equalTo("2-12-1942")).
			body("jenis_kelamin", equalTo("L")).
		when().
			get("/java-testing/jasamedika/pasien/datapasien/1611000001");
	}
 
	
	/*  Negatif Unit testing for registrasi pasien service   
	 *  Get Pasien data By Id
	 *  Using dummy data (Hard-coded Data)
	 * */
	 
	@Test
	public void testDataPasienByIdNotFound() {
		
		expect().
			body(nullValue()).
		when().
			get("/java-testing/jasamedika/pasien/datapasien/1611000100");
	}

}
