package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

public class RestUtils {

    public static Response postMethod(String endPoint , String reqPayload, Map<String, String> headers  ) {
       return RestAssured.given().log().all()
               .contentType("application/json")
               .headers(headers)
               .baseUri(endPoint)
               .body(reqPayload)
               .post()
               .then().log().all().extract().response();
    }
}
