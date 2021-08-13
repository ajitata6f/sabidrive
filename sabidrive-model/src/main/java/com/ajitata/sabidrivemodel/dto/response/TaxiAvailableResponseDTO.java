package com.ajitata.sabidrivemodel.dto.response;

public class TaxiAvailableResponseDTO {

    private String taxiId;

    public TaxiAvailableResponseDTO() {
    }

    public TaxiAvailableResponseDTO(String taxiId) {
        this.taxiId = taxiId;
    }

    public String getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(String taxiId) {
        this.taxiId = taxiId;
    }

}