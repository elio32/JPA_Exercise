package org.example.service;

import org.example.model.dto.FlightDTO;
import org.example.model.entity.Flight;

import java.util.List;

public interface FlightService {
    List<FlightDTO> loadAllFlights();
    List<FlightDTO> deleteFlight(Flight flight);
    List<FlightDTO> findFlightById(Long id);
    List<FlightDTO> saveNewFlight(Flight flight);
    List<FlightDTO> findByOrigin(String origin);
}
