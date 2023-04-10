package org.example.mapper;

import org.example.model.dto.FlightTDO;
import org.example.model.entity.Flight;

public class FlightMapper extends AbstractMapper<Flight, FlightTDO>{
    @Override
    public Flight toEntity(FlightTDO flightTDO) {
        return null;
    }

    @Override
    public FlightTDO toDto(Flight flight) {
        FlightTDO flightTDO = new FlightTDO();
        flightTDO.setId(flight.getId());
        flightTDO.setFlightNumber(flight.getFlightNumber());
        flightTDO.setAirline(flight.getAirline());
        flightTDO.setOrigin(flight.getOrigin());
        flightTDO.setDestination(flight.getDestination());
        flightTDO.setDepartureDate(flight.getDepartureDate());
        flightTDO.setArrivalDate(flight.getArrivalDate());
        flightTDO.setStatus(flight.getStatus());
        return flightTDO;
    }
}
