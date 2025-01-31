package com.apurba.in.ex04_Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.hamcrest.text.MatchesPattern;
import org.testng.annotations.Test;

public class apiTesting021_TestNG_RestAssured_Assertions {
    @Test
    public void test_POST(){
        String payload_post = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.log().all().body(payload_post);
        Response r1 = r.when().log().all().post();
        ValidatableResponse vr = r1.then().log().all().statusCode(200);

        //1. Take the response format from postman
        //2. Go to: https://jsonpathfinder.com/
        //3. Paste the Response
        //4. Copy id from Path box (eg: bookingid)

        vr.body("bookingid", Matchers.notNullValue());
        vr.body("booking.firstname",Matchers.equalTo("Jim"));
        vr.body("booking.lastname",Matchers.equalTo("Brown"));
    }
}