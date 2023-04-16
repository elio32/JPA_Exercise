package org.example.mapper;

import org.example.model.dto.FlightDTO;
import org.example.model.entity.Flight;

public class FlightMapper extends AbstractMapper<Flight, FlightDTO>{
    @Override
    public Flight toEntity(FlightDTO flightDTO) {
        return null;
    }

    @Override
    public FlightDTO toDto(Flight flight) {
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setId(flight.getId());
        flightDTO.setFlightNumber(flight.getFlightNumber());
        flightDTO.setAirline(flight.getAirline());
        flightDTO.setOrigin(flight.getOrigin());
        flightDTO.setDestination(flight.getDestination());
        flightDTO.setDepartureDate(flight.getDepartureDate());
        flightDTO.setArrivalDate(flight.getArrivalDate());
        flightDTO.setStatus(flight.getStatus());
        return flightDTO;
    }
}
