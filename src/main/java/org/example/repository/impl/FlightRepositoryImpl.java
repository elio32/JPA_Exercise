package org.example.repository.impl;

import org.example.configuration.EntityManagerConfiguration;
import org.example.model.entity.Flight;
import org.example.repository.FlightRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class FlightRepositoryImpl implements FlightRepository {

    private EntityManager entityManager;

    public FlightRepositoryImpl() {
        entityManager = EntityManagerConfiguration.getEntityManager();
    }

    @Override
    public Optional<Flight> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Flight.class,id));
    }

    @Override
    public List<Flight> findAll() {
        TypedQuery<Flight> result = entityManager.createNamedQuery("allFlights",Flight.class);
        return result.getResultList();
    }



    @Override
    public List<Flight> save(Flight flight) {
        if (flight.getId()!=null){
            entityManager.getTransaction().begin();
            flight.setId(flight.getId());
            flight.setFlightNumber(flight.getFlightNumber());
            flight.setOrigin(flight.getOrigin());
            flight.setDestination(flight.getDestination());
            flight.setAirline(flight.getAirline());
            flight.setDepartureDate(flight.getDepartureDate());
            flight.setArrivalDate(flight.getArrivalDate());
            flight.setStatus(flight.getStatus());
            entityManager.getTransaction().commit();
            System.out.println("Flight updated");
        }
        else {
            entityManager.getTransaction().begin();
            entityManager.persist(flight);
            entityManager.getTransaction().commit();
            System.out.println("Flight added");
        }

        return (List<Flight>) flight;
    }

    @Override
    public List<Flight> delete(Flight flight) {
        if (flight.getId() != null){
            entityManager.getTransaction().begin();
            findById(flight.getId()).ifPresent(entityManager::remove);
            entityManager.getTransaction().commit();
        }
        return (List<Flight>) flight;
    }

    @Override
    public List<Flight> findByOrigin(String origin) {
        TypedQuery<Flight> result = entityManager.createNamedQuery("findByOrigin",Flight.class);
        result.setParameter("origin","Lufthansa");
        return result.getResultList();
    }
}
