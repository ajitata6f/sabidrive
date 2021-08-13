package com.ajitata.sabidrivemodel.dto.response;

public class TaxiLocationUpdatedEventResponseDTO {

    private String taxiId;

    public TaxiLocationUpdatedEventResponseDTO() {
    }

    public TaxiLocationUpdatedEventResponseDTO(String taxiId) {
        this.taxiId = taxiId;
    }

    public String getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(String taxiId) {
        this.taxiId = taxiId;
    }

}
