package com.ajitata.sabidrivetaxiservice.model;

import com.ajitata.sabidrivemodel.enums.TaxiStatus;
import com.ajitata.sabidrivemodel.enums.TaxiType;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Taxi")
public class Taxi implements Serializable {
    @Id
    private String taxiId;

    private TaxiType taxiType;

    private TaxiStatus taxiStatus;

    public Taxi() {
    }

    public Taxi(String taxiId, TaxiType taxiType, TaxiStatus taxiStatus) {
        this.taxiId = taxiId;
        this.taxiType = taxiType;
        this.taxiStatus = taxiStatus;
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

    public TaxiStatus getTaxiStatus() {
        return taxiStatus;
    }

    public void setTaxiStatus(TaxiStatus taxiStatus) {
        this.taxiStatus = taxiStatus;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "taxiId='" + taxiId + '\'' +
                ", taxiType=" + taxiType +
                ", taxiStatus=" + taxiStatus +
                '}';
    }

}