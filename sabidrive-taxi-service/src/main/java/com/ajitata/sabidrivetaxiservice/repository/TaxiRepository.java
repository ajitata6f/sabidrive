package com.ajitata.sabidrivetaxiservice.repository;

import com.ajitata.sabidrivetaxiservice.model.Taxi;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaxiRepository extends CrudRepository<Taxi, String> {

}
