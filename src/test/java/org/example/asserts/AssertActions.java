package org.example.asserts;
import org.testng.Assert;

import io.restassured.response.Response;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class AssertActions {

    public static void  verifyStatusCode(Response response, int expectedStatusCode) {
        assertThat(response.getStatusCode()).isEqualTo(expectedStatusCode);
    }

    public static void verifyStaringKey(String keyExpect, String KeyActual){
        assertThat(KeyActual).isEqualTo(keyExpect);
    }


}
