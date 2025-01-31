package com.apurba.in.ex02_RestAssuredBasics.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class apitesting006_get_BDDStyles {
    @Test
    public static void main(String[] args) {
        String pincode = "700041";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when().log().all().get()
                .then().log().all().statusCode(200);

        pincode = "7000002";
        RestAssured.given()
                .baseUri("\"https://api.zippopotam.us\"")
                .basePath("/IN/"+ pincode)
                .when().log().all().get()
                .then().log().all().statusCode(200);

    }
}
