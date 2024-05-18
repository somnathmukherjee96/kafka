package com.som.cabbookdriver.controller;

import com.som.cabbookdriver.service.CabLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class CabLocationController {
    @Autowired
    CabLocationService cabLocationService;

    public ResponseEntity updatedLocation(){
        return new ResponseEntity<>(Map.of("message", "Location updated"), HttpStatus.OK);
    }
}
