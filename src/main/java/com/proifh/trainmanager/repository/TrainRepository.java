package com.proifh.trainmanager.repository;

import com.proifh.trainmanager.model.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TrainRepository extends JpaRepository<Train, Long> {
    List<Train> findByPublished(boolean published);

    List<Train> findByTitleContaining(String title);
}