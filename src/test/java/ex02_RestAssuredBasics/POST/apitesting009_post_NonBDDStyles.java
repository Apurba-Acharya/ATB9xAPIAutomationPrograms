package ex02_RestAssuredBasics.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class apitesting009_post_NonBDDStyles {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    @Test
    public void test_GET_NonBDD() {
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.contentType(ContentType.JSON);
        r.log().all().body(payload);

        response = r.when().log().all().post();

        vr = response.then().log().all().statusCode(200);

    }
}
