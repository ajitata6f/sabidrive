package com.ajitata.sabidrivetaxiservice;

import com.ajitata.sabidriveconfig.RedisConfig;
import com.ajitata.sabidrivemodel.enums.TaxiStatus;
import com.ajitata.sabidrivemodel.enums.TaxiType;
import com.ajitata.sabidrivemodel.util.LocationGenerator;
import com.ajitata.sabidrivetaxiservice.listener.TaxiBookingAcceptedEventMessageListener;
import com.ajitata.sabidrivetaxiservice.model.Taxi;
import com.ajitata.sabidrivetaxiservice.repository.TaxiRepository;
import com.ajitata.sabidrivetaxiservice.service.TaxiService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

import java.util.UUID;

@SpringBootApplication
public class SabidriveTaxiServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SabidriveTaxiServiceApplication.class, args);
    }

    @Bean
    public ApplicationRunner applicationRunner(TaxiRepository taxiRepository, TaxiService taxiService) {
        return args -> {
            taxiRepository.deleteAll();

            taxiRepository.save(new Taxi(UUID.randomUUID().toString(), TaxiType.MINI, TaxiStatus.AVAILABLE));
            taxiRepository.save(new Taxi(UUID.randomUUID().toString(), TaxiType.NANO, TaxiStatus.AVAILABLE));
            taxiRepository.save(new Taxi(UUID.randomUUID().toString(), TaxiType.VAN, TaxiStatus.AVAILABLE));

            Iterable<Taxi> taxis = taxiRepository.findAll();

            taxis.forEach(t -> taxiService.updateLocation(t.getTaxiId(), LocationGenerator.getLocation(79.865072, 6.927610, 3000)).subscribe());
        };
    }

    @Bean
    public RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, TaxiBookingAcceptedEventMessageListener taxiBookingAcceptedEventMessageListener) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(taxiBookingAcceptedEventMessageListener, new PatternTopic(RedisConfig.ACCEPTED_EVENT_CHANNEL));
        return container;
    }

}
