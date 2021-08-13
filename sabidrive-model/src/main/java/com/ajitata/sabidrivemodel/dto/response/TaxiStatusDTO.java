package com.ajitata.sabidrivemodel.dto.response;

import com.ajitata.sabidrivemodel.enums.TaxiStatus;

public class TaxiStatusDTO {
    private String taxiId;

    private TaxiStatus status;

    public TaxiStatusDTO() {
    }

    public TaxiStatusDTO(String taxiId, TaxiStatus status) {
        this.taxiId = taxiId;
        this.status = status;
    }

    public String getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(String taxiId) {
        this.taxiId = taxiId;
    }

    public TaxiStatus getStatus() {
        return status;
    }

    public void setStatus(TaxiStatus status) {
        this.status = status;
    }
}
