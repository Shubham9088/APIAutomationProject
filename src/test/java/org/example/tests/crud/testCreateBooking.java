package org.example.tests.crud;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.asserts.AssertActions;
import org.example.base.BaseTest;
import org.example.endpoints.APIConstants;
import org.example.pojos.BookingResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.modules.PayloadManager;

public class testCreateBooking extends BaseTest {

    @Test
    public void testVerifyCreateBooking() {
        requestSpec.basePath(APIConstants.Create_Update_Booking);
        response = RestAssured.given(requestSpec)
                    .when()
                    .body(PayloadManager.createPayloadBookingAsString()).post();

        //deserilization
        BookingResponse bookingResponse= PayloadManager.bookingResponse(response.asString());

        //Verify status code
        AssertActions.verifyStatusCode(response,200);

        //Verify booking firstName
        AssertActions.verifyStaringKey(bookingResponse.getBooking().getFirstname(),"shubham");

    }
}
