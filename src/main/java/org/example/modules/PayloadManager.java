package org.example.modules;

import com.google.gson.Gson;
import org.example.pojos.Booking;
import org.example.pojos.BookingResponse;
import org.example.pojos.Bookingdates;

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

}
