package org.example.service.impl;

import org.example.mapper.FlightMapper;
import org.example.model.dto.FlightTDO;
import org.example.model.entity.Flight;
import org.example.repository.FlightRepository;
import org.example.repository.impl.FlightRepositoryImpl;
import org.example.service.FlightService;

import java.util.List;
import java.util.stream.Collectors;

public class FlightServiceImpl implements FlightService {

    private final FlightRepositoryImpl flightRepository;
    private final FlightMapper flightMapper;

    public FlightServiceImpl() {
        this.flightMapper = new FlightMapper();
        this.flightRepository = new FlightRepositoryImpl();
    }

    @Override
    public List<FlightTDO> loadAllFlights() {
        return flightRepository.findAll().stream().map(flightMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public List<FlightTDO> deleteFlight(Flight flight) {
        return flightRepository.delete(flight).stream().map(flightMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public List<FlightTDO> findFlightById(Long id) {
        return flightRepository.findById(id).stream().map(flightMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public List<FlightTDO> saveNewFlight(Flight flight) {
        return flightRepository.save(flight).stream().map(flightMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public List<FlightTDO> findByOrigin(String origin) {
        return flightRepository.findByOrigin(origin).stream().map(flightMapper::toDto).collect(Collectors.toList());
    }
}
