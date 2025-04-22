package ex05_payLoadManagement.gson_demo;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class apitesting028_GSON {
    RequestSpecification rs;
    Response r;
    ValidatableResponse vr;

    @Test
    public void positive(){
        Booking booking = new Booking();
        booking.setFirstname("Jim");
        booking.setLastname("Brown");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Breakfast");

        Bookingdates bookingDates = new Bookingdates();
        bookingDates.setCheckin("2018-01-01");
        bookingDates.setCheckout("2019-01-01");
        booking.setBookingdates(bookingDates);

        System.out.println(booking);

        //Java Object -> JSON
        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        System.out.println(jsonStringBooking);

        rs = RestAssured.given();
        rs.baseUri("https://restful-booker.herokuapp.com");
        rs.basePath("/booking");
        rs.contentType(ContentType.JSON);
        rs.log().all().body(booking);

        r = rs.when().log().all().post();
        String jsonResponseString = r.asString();

        vr = r.then().log().all().statusCode(200);

        //*** Deserialization -> Extraction ***
        BookingResponse br = gson.fromJson(jsonResponseString,BookingResponse.class);
        System.out.println(br.getBookingid());
        System.out.println(br.getBooking().getFirstname());
        System.out.println(br.getBooking().getLastname());
    }

}
