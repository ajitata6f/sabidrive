package com.ajitata.sabidrivebookingservice.repository;

import com.ajitata.sabidrivebookingservice.model.TaxiBooking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxiBookingRepository extends CrudRepository<TaxiBooking, String> {

}
