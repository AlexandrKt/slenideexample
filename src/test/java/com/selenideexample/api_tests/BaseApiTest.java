package com.selenideexample.api_tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://api.example.com"; // replace with actual base URI
    }

    protected RequestSpecification getRequestSpecification() {
        return RestAssured.given()
                .contentType("application/json")
                .accept("application/json");
    }

    protected Response getResponse(RequestSpecification request, String endpoint) {
        return request.get(endpoint);
    }

    protected Response postResponse(RequestSpecification request, String endpoint, Object body) {
        return request.body(body).post(endpoint);
    }

    protected Response putResponse(RequestSpecification request, String endpoint, Object body) {
        return request.body(body).put(endpoint);
    }

    protected Response deleteResponse(RequestSpecification request, String endpoint) {
        return request.delete(endpoint);
    }
}
