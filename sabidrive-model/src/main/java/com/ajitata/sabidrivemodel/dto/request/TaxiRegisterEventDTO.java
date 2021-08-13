package com.ajitata.sabidrivemodel.dto.request;

import com.ajitata.sabidrivemodel.enums.TaxiType;

import java.util.UUID;

public class TaxiRegisterEventDTO {
    private String taxiId = UUID.randomUUID().toString();

    private TaxiType taxiType;

    public TaxiRegisterEventDTO() {
    }

    public TaxiRegisterEventDTO(String taxiId, TaxiType taxiType) {
        this.taxiId = taxiId;
        this.taxiType = taxiType;
    }

    public String getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(String taxiId) {
        this.taxiId = taxiId;
    }

    public TaxiType getTaxiType() {
        return taxiType;
    }

    public void setTaxiType(TaxiType taxiType) {
        this.taxiType = taxiType;
    }

}