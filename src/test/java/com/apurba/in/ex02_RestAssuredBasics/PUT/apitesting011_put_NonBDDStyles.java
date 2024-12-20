package com.apurba.in.ex02_RestAssuredBasics.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class apitesting011_put_NonBDDStyles {
    @Test
    public void test_put_NonBDD(){

        String token = "98d2b743262bf84";
        String bookingid = "2835";
        String payloadPUT = "{\n" +
                "        \"firstname\": \"xxxx\",\n" +
                "        \"lastname\": \"Brown\",\n" +
                "        \"totalprice\": 111,\n" +
                "        \"depositpaid\": true,\n" +
                "        \"bookingdates\": {\n" +
                "            \"checkin\": \"2018-01-01\",\n" +
                "            \"checkout\": \"2019-01-01\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Breakfast\"\n" +
                "    }";

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingid);
        r.contentType(ContentType.JSON);
        r.cookie("token",token);
        r.log().all().body(payloadPUT);

        Response r1 = r.when().log().all().put();

        ValidatableResponse vr1 = r1.then().log().all().statusCode(200);


    }
}
