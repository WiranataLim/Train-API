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

    @GetMapping("/trains/")
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

    @GetMapping("/trains")
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
    
    @PutMapping("/trains/{id}")
    public ResponseEntity<Object> updateTrain(@PathVariable("id") String id, @RequestBody Train newTrain){
        Map<String,String> response = new HashMap<>();
        try {
            long idL = Long.parseLong(id);
            
            Optional<Train> train = trainRepository.findById(idL);
            if (train.isPresent()){
                Train oldTrain = train.get();
                oldTrain.setAmenities(newTrain.getAmenities());
                oldTrain.setDescription(newTrain.getDescription());
                oldTrain.setDistanceBetweenStop(newTrain.getDistanceBetweenStop());
                oldTrain.setGradeCrossing(newTrain.isGradeCrossing());
                oldTrain.setMaxSpeed(newTrain.getMaxSpeed());
                oldTrain.setName(newTrain.getName());
                oldTrain.setSharingTracks(newTrain.isSharingTracks());
                oldTrain.setTrainFrequency(newTrain.getTrainFrequency());
                trainRepository.save(oldTrain);
                return new ResponseEntity<>("train edited successfully", HttpStatus.OK);
            } else {
                response.put("message", "train not found");
                return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
            }
        } catch (NumberFormatException e){
            response.put("message", "failed when edit train");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
