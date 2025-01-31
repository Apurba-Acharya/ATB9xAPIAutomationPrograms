package com.apurba.in.ex04_Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*; //asserj import is separtly required

public class apiTesting024_TestNG_RestAssured_AllTypeOfAssertions {
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

        vr.body("bookingid", Matchers.notNullValue());
        vr.body("booking.firstname",Matchers.equalTo("Jim"));
        vr.body("booking.lastname",Matchers.equalTo("Brown"));

        Integer bookingId = r1.then().extract().path("bookingid");
        String firstname = r1.then().extract().path("booking.firstname");
        String lastname = r1.then().extract().path("booking.lastname");

        //TestNG Assertions
        Assert.assertNotNull(bookingId);
        Assert.assertEquals(firstname, "Jim");
        Assert.assertEquals(lastname, "Brown");

        //or AssertJ
        assertThat(bookingId).isNotNull().isNotZero().isPositive();
        assertThat(firstname).isEqualTo("Jim").isNotEmpty().isNotNull();


    }
}