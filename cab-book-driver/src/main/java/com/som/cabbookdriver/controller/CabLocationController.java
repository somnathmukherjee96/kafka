package com.som.cabbookdriver.controller;

import com.som.cabbookdriver.model.Location;
import com.som.cabbookdriver.service.CabLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class CabLocationController {
    @Autowired
    CabLocationService cabLocationService;
   @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updatedLocation() throws InterruptedException {
       int range = 100;
       while(range > 0){
           String longitude = String.valueOf(Math.random());
           String latitude = String.valueOf(Math.random());
           cabLocationService.booleanUpdateLocation(new Location(longitude,latitude));
           Thread.sleep(1000);
           range--;
       }
        return new ResponseEntity<>(Map.of("message", "Location updated"), HttpStatus.OK);
    }
}
