package com.demo.producer;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.function.Supplier;

@Configuration
public class KafkaProducerStream{

    @Bean
    public Supplier<RiderLocation> sendRiderLocation(){
        Random random = new Random();
        return () -> {
            String riderId = "rider" + random.nextInt(20);
            RiderLocation location = new RiderLocation(riderId, 16.7, 22.5);
            System.out.println("Sending: "+ location.getRiderId());
            return location;
        };
    }

    @Bean
    public Supplier<String> sendRiderStatus(){
        Random random = new Random();
        String[] statuses = {"ride started", "ride completed"};
        return () -> {
            String riderId = "rider" + random.nextInt(20);
            String status = statuses[random.nextInt(statuses.length)];
            String message = riderId + ":" + status;
            System.out.println("Sending Status: " + message);
            return message;
        };
    }
}