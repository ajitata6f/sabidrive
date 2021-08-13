package com.ajitata.sabidrivemodel.dto.response;

public class TaxiRegisterEventResponseDTO {

    private String taxiId;

    public TaxiRegisterEventResponseDTO() {
    }

    public TaxiRegisterEventResponseDTO(String taxiId) {
        this.taxiId = taxiId;
    }

    public String getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(String taxiId) {
        this.taxiId = taxiId;
    }

}
