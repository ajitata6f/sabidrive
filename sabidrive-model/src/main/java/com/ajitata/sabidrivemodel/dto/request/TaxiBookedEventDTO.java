package com.ajitata.sabidrivemodel.dto.request;

import com.ajitata.sabidrivemodel.enums.TaxiType;

import java.time.LocalDateTime;
import java.util.UUID;

public class TaxiBookedEventDTO {

    private String taxiBookingId = UUID.randomUUID().toString();

    private LocationDTO start;

    private LocationDTO end;

    private LocalDateTime bookedTime = LocalDateTime.now();

    private Long customerId;

    private TaxiType taxiType;

    public TaxiBookedEventDTO() {
    }

    public TaxiBookedEventDTO(String taxiBookingId, LocationDTO start, LocationDTO end, LocalDateTime bookedTime, Long customerId, TaxiType taxiType) {
        this.taxiBookingId = taxiBookingId;
        this.start = start;
        this.end = end;
        this.bookedTime = bookedTime;
        this.customerId = customerId;
        this.taxiType = taxiType;
    }

    public String getTaxiBookingId() {
        return taxiBookingId;
    }

    public void setTaxiBookingId(String taxiBookingId) {
        this.taxiBookingId = taxiBookingId;
    }

    public LocationDTO getStart() {
        return start;
    }

    public void setStart(LocationDTO start) {
        this.start = start;
    }

    public LocationDTO getEnd() {
        return end;
    }

    public void setEnd(LocationDTO end) {
        this.end = end;
    }

    public LocalDateTime getBookedTime() {
        return bookedTime;
    }

    public void setBookedTime(LocalDateTime bookedTime) {
        this.bookedTime = bookedTime;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public TaxiType getTaxiType() {
        return taxiType;
    }

    public void setTaxiType(TaxiType taxiType) {
        this.taxiType = taxiType;
    }

}