package com.som.cabbookdriver.service;

import com.som.cabbookdriver.constant.AppConstant;
import com.som.cabbookdriver.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CabLocationService {
    @Autowired private KafkaTemplate<String, Object> kafkaTemplate;

    public boolean booleanUpdateLocation(Location location){
        kafkaTemplate.send(AppConstant.CAB_LOCATION, location);
        return true;
    }
}
