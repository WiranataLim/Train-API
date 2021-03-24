package com.proifh.trainmanager.repository;

import com.proifh.trainmanager.model.Train;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, Long> {
    public List<Train> findBySharingTracks(boolean isSharingTracks);
}