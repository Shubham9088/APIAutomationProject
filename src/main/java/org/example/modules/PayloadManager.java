package org.example.modules;

import com.google.gson.Gson;
import org.example.pojos.*;

public class PayloadManager {
    public static Gson gson;
    public static String createPayloadBookingAsString() {
        Booking booking=new Booking();
        booking.setFirstname("shubham");
        booking.setLastname("chakole");
        booking.setTotalprice(11111);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Lunch");
        Bookingdates bdates=new Bookingdates();
        bdates.setCheckin("2020-01-02");
        bdates.setCheckout("2020-01-05");
        booking.setBookingdates(bdates);
        gson=new Gson();
        String jsonStringPayload=gson.toJson(booking);
        return jsonStringPayload;
    }

    public static BookingResponse bookingResponse(String jsonStringPayload) {
        gson=new Gson();
        BookingResponse booking=gson.fromJson(jsonStringPayload, BookingResponse.class);
        return booking;
    }

    public static Booking BookingResponseOfExistingUser(String jsonStringPayload) {
        gson= new Gson();
        Booking booking=gson.fromJson(jsonStringPayload, Booking.class);
        return booking;
    }

    public static String authTokenRequestPayload(){
        AuthToken token =new AuthToken();
        token.setUsername("admin");
        token.setPassword("password123");
        gson=new Gson();
        String jsonStringPayload=gson.toJson(token);
        return jsonStringPayload;
    }

    public static AuthTokenResponse authTokenResponse(String jsonStringPayload){
        gson=new Gson();
        AuthTokenResponse token=gson.fromJson(jsonStringPayload, AuthTokenResponse.class);
        return token;
    }

    public static String updatePayloadBookingAsString() {
        Booking booking=new Booking();
        booking.setFirstname("Nishant");
        booking.setLastname("chakole");
        booking.setTotalprice(11111);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Lunch");
        Bookingdates bdates=new Bookingdates();
        bdates.setCheckin("2020-01-02");
        bdates.setCheckout("2020-01-05");
        booking.setBookingdates(bdates);
        gson=new Gson();
        String jsonStringPayload=gson.toJson(booking);
        return jsonStringPayload;
    }

}
