package com.proifh.trainmanager.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
@Table(name = "train")
public class Train {
    
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "description", columnDefinition="TEXT")
    private String description;
    
    @JsonProperty("distance-between-stop")
    @Column(name = "distance_between_stop")
    private String distanceBetweenStop;
    
    @JsonProperty("max-speed")
    @Column(name = "max_speed")
    private String maxSpeed;
    
    @JsonProperty("sharing-tracks")
    @Column(name = "sharing_tracks")
    private boolean sharingTracks;
    
    @JsonProperty("grade-crossing")
    @Column(name = "grade_crossing")
    private boolean gradeCrossing;
    
    @JsonProperty("train-frequency")
    @Column(name = "train_frequency")
    private String trainFrequency;
    
    @Column(name = "amenities")
    private String amenities;

    public Train() {
    }

    public Train(String name, String description, String distanceBetweenStop, String maxSpeed, boolean sharingTracks, boolean gradeCrossing, String trainFrequency, String amenities) {
        this.name = name;
        this.description = description;
        this.distanceBetweenStop = distanceBetweenStop;
        this.maxSpeed = maxSpeed;
        this.sharingTracks = sharingTracks;
        this.gradeCrossing = gradeCrossing;
        this.trainFrequency = trainFrequency;
        this.amenities = amenities;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDistanceBetweenStop() {
        return distanceBetweenStop;
    }

    public void setDistanceBetweenStop(String distanceBetweenStop) {
        this.distanceBetweenStop = distanceBetweenStop;
    }

    public String getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(String maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public boolean isSharingTracks() {
        return sharingTracks;
    }

    public void setSharingTracks(boolean sharingTracks) {
        this.sharingTracks = sharingTracks;
    }

    public boolean isGradeCrossing() {
        return gradeCrossing;
    }

    public void setGradeCrossing(boolean gradeCrossing) {
        this.gradeCrossing = gradeCrossing;
    }

    public String getTrainFrequency() {
        return trainFrequency;
    }

    public void setTrainFrequency(String trainFrequency) {
        this.trainFrequency = trainFrequency;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }    
}
