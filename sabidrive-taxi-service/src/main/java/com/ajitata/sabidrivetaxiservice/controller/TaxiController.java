package com.ajitata.sabidrivetaxiservice.controller;

import com.ajitata.sabidrivemodel.dto.request.LocationDTO;
import com.ajitata.sabidrivemodel.dto.request.TaxiRegisterEventDTO;
import com.ajitata.sabidrivemodel.dto.response.TaxiAvailableResponseDTO;
import com.ajitata.sabidrivemodel.dto.response.TaxiLocationUpdatedEventResponseDTO;
import com.ajitata.sabidrivemodel.dto.response.TaxiRegisterEventResponseDTO;
import com.ajitata.sabidrivemodel.dto.response.TaxiStatusDTO;
import com.ajitata.sabidrivemodel.enums.TaxiStatus;
import com.ajitata.sabidrivemodel.enums.TaxiType;
import com.ajitata.sabidrivetaxiservice.service.TaxiService;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("/taxis")
@RestController
public class TaxiController {

    private final TaxiService taxiService;

    public TaxiController(TaxiService taxiService) {
        this.taxiService = taxiService;
    }

    @GetMapping
    public Flux<TaxiAvailableResponseDTO> getAvailableTaxis(@RequestParam("type") TaxiType taxiType, @RequestParam("latitude") Double latitude, @RequestParam("longitude") Double longitude, @RequestParam(value = "radius", defaultValue = "1") Double radius) {
        Flux<GeoResult<RedisGeoCommands.GeoLocation<String>>> availableTaxisFlux = taxiService.getAvailableTaxis(taxiType, latitude, longitude, radius);
        return availableTaxisFlux.map(r -> new TaxiAvailableResponseDTO(r.getContent().getName()));
    }

    @GetMapping("/{taxiId}/status")
    public Mono<TaxiStatusDTO> getTaxiStatus(@PathVariable("taxiId") String taxiId) {
        return taxiService.getTaxiStatus(taxiId).map(s -> new TaxiStatusDTO(taxiId, s));
    }

    @PutMapping("/{taxiId}/status")
    public Mono<TaxiStatusDTO> updateTaxiStatus(@PathVariable("taxiId") String taxiId, @RequestParam("status") String taxiStatus) {
        return taxiService.updateTaxiStatus(taxiId, TaxiStatus.valueOf(taxiStatus)).map(t -> new TaxiStatusDTO(t.getTaxiId(), t.getTaxiStatus()));
    }

    @PutMapping("/{taxiId}/location")
    public Mono<TaxiLocationUpdatedEventResponseDTO> updateLocation(@PathVariable("taxiId") String taxiId, @RequestBody LocationDTO locationDTO) {
        return taxiService.updateLocation(taxiId, locationDTO).map(t -> new TaxiLocationUpdatedEventResponseDTO(taxiId));
    }

    @PostMapping
    public Mono<TaxiRegisterEventResponseDTO> register(@RequestBody TaxiRegisterEventDTO taxiRegisterEventDTO) {
        return taxiService.register(taxiRegisterEventDTO).map(t -> new TaxiRegisterEventResponseDTO(t.getTaxiId()));
    }

}
