package ex02_RestAssuredBasics.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class apitesting008_get_NonBDDStyles {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_GET_NonBDD(){
        String pincode = "700082";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pincode);

        response = r.when().log().all().get();

        vr = response.then().log().all().statusCode(200);
    }

    @Test
    public void test_GET_NonBDDnegative1(){
        String pincode = "440P44";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pincode);

        response = r.when().log().all().get();

        vr = response.then()
                .log().all().statusCode(200);
    }

    @Test
    public void test_GET_NonBDDnegative2(){
        String pincode = "721601";
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pincode);

        response = r.when().log().all().get();

        vr = response.then().log().all().statusCode(404);


        RequestSpecification rs = RestAssured.given();
        rs.baseUri("");
        rs.basePath("");
        Response res = rs.when().log().all().get();
    }
}
