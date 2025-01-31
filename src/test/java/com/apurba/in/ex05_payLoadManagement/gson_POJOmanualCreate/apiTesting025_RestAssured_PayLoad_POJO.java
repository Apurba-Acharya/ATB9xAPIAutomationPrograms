package com.apurba.in.ex05_payLoadManagement.gson_POJOmanualCreate;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class apiTesting025_RestAssured_PayLoad_POJO {
    @Test
    public void test_POST(){
//        String payload_post = "{\n" +
//                "    \"firstname\" : \"Jim\",\n" +
//                "    \"lastname\" : \"Brown\",\n" +
//                "    \"totalprice\" : 111,\n" +
//                "    \"depositpaid\" : true,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"2018-01-01\",\n" +
//                "        \"checkout\" : \"2019-01-01\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Breakfast\"\n" +
//                "}";

        //POJO >>
        Booking booking = new Booking();
        booking.setFirstname("XXXX");
        booking.setLastname("YYYY");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("lunch");

        BookingDates bookingDates = new BookingDates();
        bookingDates.setCheckin("2018-01-01");
        bookingDates.setCheckout("2019-01-01");
        booking.setBookingdates(bookingDates);

        System.out.println(booking);

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking");
        r.contentType(ContentType.JSON);
        r.log().all().body(booking);

        Response r1 = r.when().log().all().post();

        ValidatableResponse vr = r1.then().log().all().statusCode(200);

        vr.body("bookingid", Matchers.notNullValue());
        vr.body("booking.firstname",Matchers.equalTo("XXXX"));
        vr.body("booking.lastname",Matchers.equalTo("YYYY"));

        Integer bookingId = r1.then().extract().path("bookingid");
        String firstname = r1.then().extract().path("booking.firstname");
        String lastname = r1.then().extract().path("booking.lastname");

        //TestNG Assertions
        Assert.assertNotNull(bookingId);
        Assert.assertEquals(firstname, "XXXX");
        Assert.assertEquals(lastname, "YYYY");

        //AssertJ
        assertThat(bookingId).isNotNull().isNotZero().isPositive();
        assertThat(firstname).isEqualTo("XXXX").isNotEmpty().isNotNull();


    }
}