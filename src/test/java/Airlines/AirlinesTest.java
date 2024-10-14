package Airlines;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.RestUtils;
import java.util.HashMap;

public class AirlinesTest {

    @Test
    public void createAirline() {
       Response response = RestAssured.given().log().all()
                .contentType("application/json")
                .baseUri("https://api.instantwebtools.net/v1/airlines")
                .body("{\n" +
                        "    \"_id\":\"12345002\",\n" +
                        "    \"name\": \"Sri Lankan Airways\",\n" +
                        "    \"country\": \"Sri Lanka\",\n" +
                        "    \"logo\": \"https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png\",\n" +
                        "    \"slogan\": \"From Sri Lanka\",\n" +
                        "    \"head_quaters\": \"Katunayake, Sri Lanka\",\n" +
                        "    \"website\": \"www.srilankaaairways.com\",\n" +
                        "    \"established\": \"1990\"\n" +
                        "}")
                .post()
               .then().log().all().extract().response();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test
    public void createAirlineWithUtils(){
        String endpoint = "https://api.instantwebtools.net/v1/airlines";
        String payload = "{\n" +
                "    \"_id\":\"12345003\",\n" +
                "    \"name\": \"Sri Lankan Airways\",\n" +
                "    \"country\": \"Sri Lanka\",\n" +
                "    \"logo\": \"https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png\",\n" +
                "    \"slogan\": \"From Sri Lanka\",\n" +
                "    \"head_quaters\": \"Katunayake, Sri Lanka\",\n" +
                "    \"website\": \"www.srilankaaairways.com\",\n" +
                "    \"established\": \"1990\"\n" +
                "}";
        Response response = RestUtils.postMethod(endpoint, payload, new HashMap<>());
        Assert.assertEquals(response.statusCode(), 200);
    }
}
