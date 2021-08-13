package com.ajitata.sabidrivebookingservice.model;


import com.ajitata.sabidrivemodel.enums.TaxiBookingStatus;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;

@RedisHash("TaxiBooking")
public class TaxiBooking {
    @Id
    private String taxiBookingId;

    private Point start;

    private LocalDateTime startTime;

    private Point end;

    private LocalDateTime endTime;

    private LocalDateTime bookedTime;

    private LocalDateTime acceptedTime;

    private Long customerId;

    private TaxiBookingStatus bookingStatus;

    private String reasonToCancel;

    private LocalDateTime cancelTime;

    private String taxiId;

    public TaxiBooking() {
    }

    public TaxiBooking(String taxiBookingId, Point start, LocalDateTime startTime, Point end, LocalDateTime endTime, LocalDateTime bookedTime, LocalDateTime acceptedTime, Long customerId, TaxiBookingStatus bookingStatus, String reasonToCancel, LocalDateTime cancelTime, String taxiId) {
        this.taxiBookingId = taxiBookingId;
        this.start = start;
        this.startTime = startTime;
        this.end = end;
        this.endTime = endTime;
        this.bookedTime = bookedTime;
        this.acceptedTime = acceptedTime;
        this.customerId = customerId;
        this.bookingStatus = bookingStatus;
        this.reasonToCancel = reasonToCancel;
        this.cancelTime = cancelTime;
        this.taxiId = taxiId;
    }

    public String getTaxiBookingId() {
        return taxiBookingId;
    }

    public void setTaxiBookingId(String taxiBookingId) {
        this.taxiBookingId = taxiBookingId;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getBookedTime() {
        return bookedTime;
    }

    public void setBookedTime(LocalDateTime bookedTime) {
        this.bookedTime = bookedTime;
    }

    public LocalDateTime getAcceptedTime() {
        return acceptedTime;
    }

    public void setAcceptedTime(LocalDateTime acceptedTime) {
        this.acceptedTime = acceptedTime;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public TaxiBookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(TaxiBookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public String getReasonToCancel() {
        return reasonToCancel;
    }

    public void setReasonToCancel(String reasonToCancel) {
        this.reasonToCancel = reasonToCancel;
    }

    public LocalDateTime getCancelTime() {
        return cancelTime;
    }

    public void setCancelTime(LocalDateTime cancelTime) {
        this.cancelTime = cancelTime;
    }

    public String getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(String taxiId) {
        this.taxiId = taxiId;
    }

    @Override
    public String toString() {
        return "TaxiBooking{" +
                "taxiBookingId='" + taxiBookingId + '\'' +
                ", start=" + start +
                ", startTime=" + startTime +
                ", end=" + end +
                ", endTime=" + endTime +
                ", bookedTime=" + bookedTime +
                ", acceptedTime=" + acceptedTime +
                ", customerId=" + customerId +
                ", bookingStatus=" + bookingStatus +
                ", reasonToCancel='" + reasonToCancel + '\'' +
                ", cancelTime=" + cancelTime +
                ", taxiId='" + taxiId + '\'' +
                '}';
    }

}
