package com.proifh.trainmanager.controller;

import com.proifh.trainmanager.model.ErrorMessage;
import java.util.List;

import com.proifh.trainmanager.model.Train;
import com.proifh.trainmanager.repository.TrainRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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
    
    @GetMapping("/trains/{id}")
    public ResponseEntity<Object> getTrainById(@PathVariable("id") long id){
        Optional<Train> trainData = trainRepository.findById(id);
        
        if(trainData.isPresent()){
            return new ResponseEntity<>(trainData.get(), HttpStatus.OK);
        } else {
            ErrorMessage errmsg = new ErrorMessage(new Date(),"train not found",404);
            return new ResponseEntity<Object>(errmsg, new HttpHeaders(),HttpStatus.NOT_FOUND);
        }
    }
    
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public class wrongEndPoint extends RuntimeException{
        ErrorMessage errmsg = new ErrorMessage(new Date(),"invalid endpoint",405);
        return new ResponseEntity<Object>(errmsg, new HttpHeaders(),HttpStatus.NOT_FOUND);
    }
}
