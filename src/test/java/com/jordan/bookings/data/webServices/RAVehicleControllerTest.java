package com.jordan.bookings.data.webServices;

import static org.hamcrest.CoreMatchers.equalTo;

import org.apache.logging.log4j.status.StatusConsoleListener;
import org.junit.Before;
//import io.restassured.builder.ResponseBuilder;
//import io.restassured.config.RestAssuredConfig;
//import io.restassured.http.Headers;
//import io.restassured.parsing.Parser;
//import io.restassured.path.json.JsonPath;
//import io.restassured.path.json.config.JsonPathConfig;
//import io.restassured.path.json.exception.JsonPathException;
//import io.restassured.path.xml.exception.XmlPathException;
//import io.restassured.response.Response;
//import org.junit.Rule;
import org.junit.Test;
//import org.junit.rules.ExpectedException;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
//import static io.restassured.config.JsonConfig.jsonConfig;
//import static io.restassured.path.xml.XmlPath.CompatibilityMode.HTML;
//import static org.hamcrest.Matchers.*;
//import static org.junit.Assert.*;


public class RAVehicleControllerTest {
	
	@Before
	public void setup() {
		RestAssured.baseURI = "http://localhost:8080";
		RestAssured.port = 8080;
	}
	
	
	@Test
	public void whenRequestGet_thenOK(){
	    when().request("GET", "/vehicles").then().statusCode(200);
	}
	
	@Test
	public void whenRequestGetVehicles_thenBodyShouldHaveFord() {
		get("/vehicles").then().assertThat().body("vehicleType[0]", equalTo("FORD"));
	}
	
	@Test
	public void whenRequestGetSpecificModel_thenReturnShouldHaveModel() {
		get("/vehicles?modelName=MUSTANG").then().assertThat().body("vehicleModel[0]", equalTo("MUSTANG"));
	}
	

}
