package com.ajitata.sabidrivemodel.dto.request;

import java.time.LocalDateTime;

public class TaxiBookingCanceledEventDTO {

    private String taxiBookingId;

    private String reason;

    private LocalDateTime cancelTime = LocalDateTime.now();

    public TaxiBookingCanceledEventDTO(String taxiBookingId) {
        this.taxiBookingId = taxiBookingId;
    }

    public TaxiBookingCanceledEventDTO(String taxiBookingId, String reason, LocalDateTime cancelTime) {
        this.taxiBookingId = taxiBookingId;
        this.reason = reason;
        this.cancelTime = cancelTime;
    }

    public String getTaxiBookingId() {
        return taxiBookingId;
    }

    public void setTaxiBookingId(String taxiBookingId) {
        this.taxiBookingId = taxiBookingId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(LocalDateTime cancelTime) {
        this.cancelTime = cancelTime;
    }

}
