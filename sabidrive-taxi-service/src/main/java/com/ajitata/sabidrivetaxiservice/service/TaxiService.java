package com.ajitata.sabidrivetaxiservice.service;

import com.ajitata.sabidrivetaxiservice.exception.TaxiIdNotFoundException;
import com.ajitata.sabidrivetaxiservice.model.Taxi;
import com.ajitata.sabidrivetaxiservice.repository.TaxiRepository;
import com.ajitata.sabidrivemodel.converter.LocationToPointConverter;
import com.ajitata.sabidrivemodel.dto.request.LocationDTO;
import com.ajitata.sabidrivemodel.dto.request.TaxiRegisterEventDTO;
import com.ajitata.sabidrivemodel.enums.TaxiStatus;
import com.ajitata.sabidrivemodel.enums.TaxiType;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.Optional;

@Service
public class TaxiService {

    private final ReactiveRedisTemplate<String, String> reactiveRedisTemplate;
    private final TaxiRepository taxiRepository;
    private final LocationToPointConverter locationToPointConverter = new LocationToPointConverter();

    public TaxiService(ReactiveRedisTemplate<String, String> reactiveRedisTemplate, TaxiRepository taxiRepository) {
        this.reactiveRedisTemplate = reactiveRedisTemplate;
        this.taxiRepository = taxiRepository;
    }

    public Mono<Taxi> register(TaxiRegisterEventDTO taxiRegisterEventDTO) {
        Taxi taxi = new Taxi(taxiRegisterEventDTO.getTaxiId(), taxiRegisterEventDTO.getTaxiType(), TaxiStatus.AVAILABLE);
        return Mono.just(taxiRepository.save(taxi));
    }

    public Mono<Taxi> updateLocation(String taxiId, LocationDTO locationDTO) {
        Optional<Taxi> taxiOptional = taxiRepository.findById(taxiId);
        if (taxiOptional.isPresent()) {
            Taxi taxi = taxiOptional.get();
            return reactiveRedisTemplate.opsForGeo().add(taxi.getTaxiType().toString(), Objects.requireNonNull(locationToPointConverter.convert(locationDTO)), taxiId).flatMap(l -> Mono.just(taxi));
        } else {
            throw getTaxiIdNotFoundException(taxiId);
        }
    }

    public Flux<GeoResult<RedisGeoCommands.GeoLocation<String>>> getAvailableTaxis(TaxiType taxiType, Double latitude, Double longitude, Double radius) {
        return reactiveRedisTemplate.opsForGeo().radius(taxiType.toString(), new Circle(new Point(longitude, latitude), new Distance(radius, Metrics.KILOMETERS)));
    }

    public Mono<TaxiStatus> getTaxiStatus(String taxiId) {
        Optional<Taxi> taxiOptional = taxiRepository.findById(taxiId);
        if (taxiOptional.isPresent()) {
            Taxi taxi = taxiOptional.get();
            return Mono.just(taxi.getTaxiStatus());
        } else {
            throw getTaxiIdNotFoundException(taxiId);
        }

    }

    public Mono<Taxi> updateTaxiStatus(String taxiId, TaxiStatus taxiStatus) {
        Optional<Taxi> taxiOptional = taxiRepository.findById(taxiId);
        if (taxiOptional.isPresent()) {
            Taxi taxi = taxiOptional.get();
            taxi.setTaxiStatus(taxiStatus);
            return Mono.just(taxiRepository.save(taxi));
        } else {
            throw getTaxiIdNotFoundException(taxiId);
        }
    }

    private TaxiIdNotFoundException getTaxiIdNotFoundException(String taxiId) {
        return new TaxiIdNotFoundException("Taxi Id "+taxiId+" Not Found");
    }

}

