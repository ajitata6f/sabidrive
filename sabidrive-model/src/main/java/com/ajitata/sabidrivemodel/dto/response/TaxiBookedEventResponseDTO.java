package com.ajitata.sabidrivemodel.dto.response;

public class TaxiBookedEventResponseDTO {

    private String taxiBookingId;

    public TaxiBookedEventResponseDTO() {
    }

    public TaxiBookedEventResponseDTO(String taxiBookingId) {
        this.taxiBookingId = taxiBookingId;
    }

    public String getTaxiBookingId() {
        return taxiBookingId;
    }

    public void setTaxiBookingId(String taxiBookingId) {
        this.taxiBookingId = taxiBookingId;
    }

}