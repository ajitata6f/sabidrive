package com.ajitata.sabidrivemodel.dto.request;

import java.time.LocalDateTime;

public class TaxiBookingAcceptedEventDTO {

    private String taxiBookingId;

    private String taxiId;

    private LocalDateTime acceptedTime =  LocalDateTime.now();

    public TaxiBookingAcceptedEventDTO() {
    }

    public TaxiBookingAcceptedEventDTO(String taxiBookingId, String taxiId, LocalDateTime acceptedTime) {
        this.taxiBookingId = taxiBookingId;
        this.taxiId = taxiId;
        this.acceptedTime = acceptedTime;
    }

    public String getTaxiBookingId() {
        return taxiBookingId;
    }

    public void setTaxiBookingId(String taxiBookingId) {
        this.taxiBookingId = taxiBookingId;
    }

    public String getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(String taxiId) {
        this.taxiId = taxiId;
    }

    public LocalDateTime getAcceptedTime() {
        return acceptedTime;
    }

    public void setAcceptedTime(LocalDateTime acceptedTime) {
        this.acceptedTime = acceptedTime;
    }

}
