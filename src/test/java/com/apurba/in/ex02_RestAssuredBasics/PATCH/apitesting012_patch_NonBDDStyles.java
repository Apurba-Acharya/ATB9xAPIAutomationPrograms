package com.apurba.in.ex02_RestAssuredBasics.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class apitesting012_patch_NonBDDStyles {
    @Test
    public void test_patch_NonBDD(){

        String token = "a7ff4dc7cd9fb39";
        String bookingid = "1665";
        String payloadpatch = "{\n" +
                "    \"firstname\" : \"xxxxx\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.log().all().body(payloadpatch);

        Response r1 = r.when().log().all().patch();

        ValidatableResponse vr1 = r1.then().log().all().statusCode(200);


    }
}
