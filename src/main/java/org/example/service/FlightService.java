package org.example.service;

import org.example.model.dto.FlightTDO;
import org.example.model.dto.UserDTO;
import org.example.model.dto.UserDetailsDTO;
import org.example.model.entity.Flight;
import org.example.model.entity.User;
import org.example.model.entity.UserDetails;

import java.util.List;

public interface FlightService {
    List<FlightTDO> loadAllFlights();
    List<FlightTDO> deleteFlight(Flight flight);
    List<FlightTDO> findFlightById(Long id);
    List<FlightTDO> saveNewFlight(Flight flight);
    List<FlightTDO> findByOrigin(String origin);
}
