package com.proifh.trainmanager.model;

public class Train {

    private long id;
    private String name,
            description,
            distance_between_stop,
            max_speed,
            train_frequency,
            amenities;
    private boolean sharing_tracks, grade_crossing;

    public Train(long id, String name, 
            String description, String distance_between_stop, 
            String max_speed, boolean sharing_tracks, boolean grade_crossing, 
            String train_frequency, String amenities) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.distance_between_stop = distance_between_stop;
        this.max_speed = max_speed;
        this.train_frequency = train_frequency;
        this.amenities = amenities;
        this.sharing_tracks = sharing_tracks;
        this.grade_crossing = grade_crossing;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getDistance_between_stop() {
        return distance_between_stop;
    }

    public void setDistance_between_stop(String distance_between_stop) {
        this.distance_between_stop = distance_between_stop;
    }

    public String getMax_speed() {
        return max_speed;
    }

    public void setMax_speed(String max_speed) {
        this.max_speed = max_speed;
    }

    public String getTrain_frequency() {
        return train_frequency;
    }

    public void setTrain_frequency(String train_frequency) {
        this.train_frequency = train_frequency;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public boolean isSharing_tracks() {
        return sharing_tracks;
    }

    public void setSharing_tracks(boolean sharing_tracks) {
        this.sharing_tracks = sharing_tracks;
    }

    public boolean isGrade_crossing() {
        return grade_crossing;
    }

    public void setGrade_crossing(boolean grade_crossing) {
        this.grade_crossing = grade_crossing;
    }
    
    
}
