package org.example.repository;

import org.example.model.entity.Flight;

import java.util.List;

public interface FlightRepository extends Repository<Flight,Long>{

    List<Flight> findByOrigin(String origin);
}
