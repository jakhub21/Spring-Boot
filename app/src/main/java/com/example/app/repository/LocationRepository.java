package com.example.app.repository;

import com.example.app.model.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "locations")
public interface LocationRepository extends JpaRepository<Location, Long> {
        Page<Location> findByNameContaining(String name, Pageable pageable);
        Location findByName(String cityName);
}
