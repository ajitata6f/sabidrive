package com.ajitata.sabidrivebookingservice.exception;

public class TaxiBookingIdNotFoundException extends RuntimeException {

    public TaxiBookingIdNotFoundException(String message) {
        super(message);
    }

    public TaxiBookingIdNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
