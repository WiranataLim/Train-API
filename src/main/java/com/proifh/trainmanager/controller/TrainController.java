package com.proifh.trainmanager.controller;

import java.util.List;

import com.proifh.trainmanager.model.Train;
import com.proifh.trainmanager.repository.TrainRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TrainController {
    @Autowired
    TrainRepository trainRepository;
    
    @GetMapping("/trains")
    public ResponseEntity<List<Train>> getAllTrains(@RequestParam(required = false) String title) {
        try { 
            List<Train> trains = new ArrayList<Train>();
            
            if (title == null) {
                trainRepository.findAll().forEach(trains::add);
            }
            
            if (trains.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            
            return new ResponseEntity<>(trains, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/trains/{id}")
    public ResponseEntity<Object> deleteTrains(@PathVariable("id") long id) {
        Map<String, String> response = new HashMap();
        String message = "";
	try {
            trainRepository.deleteById(id);
            message = "train removed successfully";
            response.put("message", message);
            return new ResponseEntity<>(response, HttpStatus.OK);
	} catch (Exception e) {
            message = "train not found";
            response.put("message", message);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @PostMapping("/trains")
    public ResponseEntity<Object> newTrain(@RequestBody Train newTrain){
        Map<String,String> response = new HashMap<>();
        try {
            trainRepository.save(newTrain);
            response.put("message", "new train added successfully");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (NumberFormatException e){
            response.put("message", "failed validation");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
