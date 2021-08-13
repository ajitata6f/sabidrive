package com.ajitata.sabidrivetaxiservice.listener;

import com.ajitata.sabidrivemodel.dto.request.TaxiBookingAcceptedEventDTO;
import com.ajitata.sabidrivemodel.enums.TaxiStatus;
import com.ajitata.sabidrivetaxiservice.service.TaxiService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class TaxiBookingAcceptedEventMessageListener implements MessageListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaxiBookingAcceptedEventMessageListener.class);

    private final TaxiService taxiService;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public TaxiBookingAcceptedEventMessageListener(TaxiService taxiService) {
        this.taxiService = taxiService;
    }

    @Override
    public void onMessage(Message message, @Nullable byte[] bytes) {
        try {
            TaxiBookingAcceptedEventDTO taxiBookingAcceptedEventDTO = objectMapper.readValue(new String(message.getBody()), TaxiBookingAcceptedEventDTO.class);
            LOGGER.info("Accepted Event {}", taxiBookingAcceptedEventDTO);
            taxiService.updateTaxiStatus(taxiBookingAcceptedEventDTO.getTaxiId(), TaxiStatus.OCCUPIED);
        } catch (IOException e) {
            LOGGER.error("Error while updating taxi status", e);
        }
    }
}
