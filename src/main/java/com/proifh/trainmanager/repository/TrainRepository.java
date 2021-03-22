package com.proifh.trainmanager.repository;

import com.proifh.trainmanager.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, Long> {
    
}