package com.example.app.repository;

import java.time.LocalDateTime;
import com.example.app.model.WeatherData;
import com.example.app.model.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "weather-data")
public interface WeatherDataRepository extends JpaRepository<WeatherData, Long> {
    Page<WeatherData> findByTimestampAfterAndLocation(LocalDateTime date, Location location, Pageable pageable);
}
