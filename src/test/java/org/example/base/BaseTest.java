package org.example.base;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.endpoints.APIConstants;
import org.example.modules.PayloadManager;
import org.example.pojos.AuthTokenResponse;
import org.testng.annotations.BeforeTest;
import org.example.modules.PayloadManager.*;

public class BaseTest {
    public RequestSpecification requestSpec;
    public Response response;

    @BeforeTest
    public void setUp() {
        requestSpec = RestAssured.given()
                .baseUri(APIConstants.BASE_URL)
                .contentType(ContentType.JSON);
    }

    public String createToken(){
        //set a header
        requestSpec=RestAssured.given()
                .baseUri(APIConstants.BASE_URL)
                .contentType(ContentType.JSON)
                .basePath(APIConstants.Create_Auth_Token);

        //send the post request
        response= RestAssured.given(requestSpec)
                .when()
                .body(PayloadManager.authTokenRequestPayload())
                .post();

        AuthTokenResponse authTokenResponse= PayloadManager.authTokenResponse(response.asString());
        return  authTokenResponse.getToken();

    }


}
