package ex01_sampleCheck;

import io.restassured.RestAssured;

public class apitesting002 {
    public static void main(String[] args) {
        RestAssured
                .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/700041")
                .when()
                    .get()
                .then().log().all().statusCode(200);
    }
}
