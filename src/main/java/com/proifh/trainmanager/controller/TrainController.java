package com.proifh.trainmanager.controller;

import java.util.List;

import com.proifh.trainmanager.model.Train;
import com.proifh.trainmanager.repository.TrainRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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
    
    Map<String, String> resp = new HashMap();

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
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/trains/{id}")
    public ResponseEntity<Object> getTrainById(@PathVariable("id") long id) {
        Optional<Train> trainData = trainRepository.findById(id);
        this.resp.put("message", "train not found");

        if (trainData.isPresent()) {
            return new ResponseEntity<>(trainData.get(), HttpStatus.OK);
        } else {

            return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/trains", params = "amenities")
    public ResponseEntity<Object> getByAmenities(@RequestParam String amenities) {
        try {
            List<Train> trainData = new ArrayList<Train>();

            trainRepository.findByAmenitiesContainingIgnoreCase(amenities).forEach(trainData::add);
            
            for(int i = 0; i< trainData.size(); i++) {
                if(trainData.get(i).getAmenities().toLowerCase().contains(amenities)) {
                    trainData = new ArrayList<Train>();
                    trainRepository.findByAmenitiesContainingIgnoreCase(amenities).
                            forEach(trainData::add);
                    break;
                }
            }
            
            if (trainData.isEmpty()) {
                this.resp.put("message", "train not found");
                return new ResponseEntity<>(resp, HttpStatus.OK);
            }

            return new ResponseEntity<>(trainData, HttpStatus.OK);
        } catch (Exception e) {
            this.resp.put("message", "invalid endpoint");
            return new ResponseEntity<>(resp, HttpStatus.METHOD_NOT_ALLOWED);
        }
    }
    
    @GetMapping("/trains/sharing-tracks")
    public ResponseEntity<List<Train>> getTrainWithSharingTracks(){
        List<Train> trainData = trainRepository.findBySharingTracks(true);
        
        return new ResponseEntity<>(trainData, HttpStatus.OK);
    }

    @DeleteMapping("/trains/{id}")
    public ResponseEntity<Object> deleteTrains(@PathVariable("id") long id) {
        Map<String, String> response = new HashMap();
	try {
            trainRepository.deleteById(id);
            response.put("message", "train removed successfully");
            return new ResponseEntity<>(response, HttpStatus.OK);
	} catch (Exception e) {
            response.put("message", "train not found");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
    }
    
    @PutMapping("/trains/{id}")
    public ResponseEntity<Object> updateTrain(@PathVariable("id") String id, @RequestBody Map<String, Object> newTrain){
        Map<String,String> response = new HashMap<>();
        try {
            long idL = Long.parseLong(id);
            
            Optional<Train> train = trainRepository.findById(idL);
            if (train.isPresent()){
                Train oldTrain = train.get();
       
                if (newTrain.containsKey("amenities")){
                    oldTrain.setAmenities((String)newTrain.get("amenities"));
                }
                if (newTrain.containsKey("description")){
                    oldTrain.setDescription((String)newTrain.get("description"));
                }
                if (newTrain.containsKey("distance-between-stop")){
                    oldTrain.setDistanceBetweenStop((String)newTrain.get("distance-between-stop"));
                }
                if (newTrain.containsKey("grade-crossing")){
                    oldTrain.setGradeCrossing((Boolean)newTrain.get("grade-crossing"));
                }
                if (newTrain.containsKey("max-speed")){
                    oldTrain.setMaxSpeed((String)newTrain.get("max-speed"));
                }
                if (newTrain.containsKey("name")){
                    oldTrain.setName((String)newTrain.get("name"));
                }
                if (newTrain.containsKey("sharing-tracks")){
                    oldTrain.setSharingTracks((Boolean)newTrain.get("sharing-tracks"));
                }
                if (newTrain.containsKey("train-frequency")){
                    oldTrain.setTrainFrequency((String)newTrain.get("train-frequency"));
                }
                
                trainRepository.save(oldTrain);
                return new ResponseEntity<>("train edited successfully", HttpStatus.OK);
            } else {
                response.put("message", "train not found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            response.put("message", "failed when edit train");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }        
    
    @PostMapping("/trains")
    public ResponseEntity<Object> newTrain(@Validated @RequestBody Train newTrain){
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
