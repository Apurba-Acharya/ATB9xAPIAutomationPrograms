package com.apurba.in.ex02_RestAssuredBasics.GET;

import io.restassured.RestAssured;

public class apitesting006_get_BDDStyles {
    public static void main(String[] args) {
        String pincode = "700041";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when().log().all().get()
                .then().log().all().statusCode(200);

    }
}
