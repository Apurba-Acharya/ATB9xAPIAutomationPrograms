package com.apurba.in.ex02_RestAssuredBasics.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class apitesting007_get_BDDStyles {

    @Test
    public void get_positive(){
        String pincode = "700041";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when().log().all().get()
                .then().log().all().statusCode(200);
    }
    @Test
    public void get_negative(){
        String pincode = "-1";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)
                .when().log().all().get()
                .then().log().all().statusCode(200);
    }
}
