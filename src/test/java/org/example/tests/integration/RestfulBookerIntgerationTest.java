package org.example.tests.integration;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.asserts.AssertActions;
import org.example.base.BaseTest;
import org.example.endpoints.APIConstants;
import org.example.pojos.Booking;
import org.example.pojos.BookingResponse;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.example.modules.PayloadManager;

public class RestfulBookerIntgerationTest extends BaseTest {

    public RestfulBookerIntgerationTest restfulBookerIntgerationTest;

    @Test(priority = 1)
    public void testcreateBooking(ITestContext id) {
        requestSpec.basePath(APIConstants.Create_Update_Booking);
        response= RestAssured.given(requestSpec)
                .when()
                    .body(PayloadManager.createPayloadBookingAsString())
                    .post();
        BookingResponse bookingResponse= PayloadManager.bookingResponse(response.asString());
        //verify status code
        AssertActions.verifyStatusCode(response,200);

        id.setAttribute("bookingId",bookingResponse.getBookingid());
    }

    @Test(priority = 2)
    public void testGetBooking(ITestContext id) {
        requestSpec.basePath(APIConstants.Create_Update_Booking + "/" + id.getAttribute("bookingId"));
        System.out.println(APIConstants.Create_Update_Booking + "/" + id.getAttribute("bookingId"));
        response= RestAssured.given(requestSpec)
                .when()
                .get();

        Booking booking= PayloadManager.BookingResponseOfExistingUser(response.asString());
        //verify status code
        AssertActions.verifyStatusCode(response,200);

        //verify firstName
        AssertActions.verifyStaringKey(booking.getFirstname(),"shubham");

    }

    //update the booking details
    @Test(priority = 3)
    public void testupdateBooking(ITestContext id){
        requestSpec.basePath(APIConstants.Create_Update_Booking + "/" + id.getAttribute("bookingId"));
        restfulBookerIntgerationTest= new RestfulBookerIntgerationTest();
        String token=restfulBookerIntgerationTest.createToken();
        response= RestAssured.given(requestSpec)
                .cookie("token",token)
                .when()
                .body(PayloadManager.updatePayloadBookingAsString())
                .put();

        Booking bookingResponse= PayloadManager.BookingResponseOfExistingUser(response.asString());
        AssertActions.verifyStatusCode(response,200);

        AssertActions.verifyStaringKey("Nishant",bookingResponse.getFirstname());

    }

    //Delete a booking
    @Test(priority=4)
    public void testDeleteBooking(ITestContext id){
        requestSpec.basePath(APIConstants.Create_Update_Booking + "/" + id.getAttribute("bookingId"));
        restfulBookerIntgerationTest= new RestfulBookerIntgerationTest();
        String token=restfulBookerIntgerationTest.createToken();
        response=RestAssured.given(requestSpec)
                    .cookie("token",token)
                .when()
                    .delete();

        AssertActions.verifyStatusCode(response,201);
    }
}
