package com.som.cabbookuser.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.som.cabbookuser.model.Location;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @KafkaListener(topics = "cab-location", groupId = "user-group")
    public void cabLocation(String location) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Location location1 = objectMapper.readValue(location, Location.class);
        System.out.println("Location received: latitude - "+location1.latitude()+", longitude - "+location1.latitude());
    }
}
