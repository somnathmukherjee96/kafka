package com.som.cabbookdriver.service;

import com.som.cabbookdriver.constant.AppConstant;
import com.som.cabbookdriver.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class CabLocationService {
    @Autowired private KafkaTemplate<String, Object> kafkaTemplate;

    public boolean booleanUpdateLocation(Location location){
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(AppConstant.CAB_LOCATION,location);
        future.whenComplete((result, ex)-> {
           if(ex==null) System.out.println("Sent message=["+location.latitude()+", "+location.longitude()+"] with offset=["+result.getRecordMetadata().offset()+"]");
           else System.out.println("Unable to send the message=["+location.latitude()+", "+location.longitude()+"] due to : "+ex.getMessage());
        });
        return true;
    }
}
