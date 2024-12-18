package org.example.base;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.example.endpoints.APIConstants;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    public RequestSpecification requestSpec;
    public Response response;

    @BeforeTest
    public void setUp() {
        requestSpec = RestAssured.given()
                .baseUri(APIConstants.BASE_URL)
                .contentType(ContentType.JSON);
    }

}
