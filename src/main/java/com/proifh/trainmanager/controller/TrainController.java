package com.proifh.trainmanager.controller;

import com.proifh.trainmanager.model.Train;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.proifh.trainmanager.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class TrainController {
    @Autowired
    TrainRepository trainRepository;
    
    
    @GetMapping("/trains/{id}")
    public ResponseEntity<Train> getTrainById(@PathVariable("id") long id){
        Optional<Train> trainData = trainRepository.findById(id);
        
        if(trainData.isPresent()){
            return new ResponseEntity<>(trainData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
