package org.example.repository.impl;

import org.example.configuration.EntityManagerConfiguration;
import org.example.model.entity.Booking;
import org.example.repository.BookingRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class BookingRepositoryImpl implements BookingRepository {

    private final EntityManager entityManager;

    public BookingRepositoryImpl() {
        entityManager = EntityManagerConfiguration.getEntityManager();
    }

    @Override
    public List<Booking> findByBookingDate(Date bookingDate) {
        TypedQuery<Booking> result = entityManager.createNamedQuery("findByBookingDate",Booking.class);
        result.setParameter("bookingDate","10/12/2023");
        return result.getResultList();
    }

    @Override
    public Optional<Booking> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Booking.class,id));
    }

    @Override
    public List<Booking> findAll() {
        TypedQuery<Booking> result = entityManager.createNamedQuery("allBookings",Booking.class);
        return result.getResultList();
    }

    @Override
    public List<Booking> save(Booking booking) {
        if (booking.getId()!=null){
            entityManager.getTransaction().begin();
            booking.setId(booking.getId());
            booking.setBookingDate(booking.getBookingDate());
            booking.setFlights(booking.getFlights());
            booking.setUser(booking.getUser());
            booking.setStatus(booking.getStatus());
            entityManager.getTransaction().commit();
            System.out.println("User updated");
        }
        else {
            entityManager.getTransaction().begin();
            entityManager.persist(booking);
            entityManager.getTransaction().commit();
            System.out.println("User added");
        }
        return (List<Booking>) booking;
    }

    @Override
    public List<Booking> delete(Booking booking) {

        if (booking.getId() != null){
            entityManager.getTransaction().begin();
            findById(booking.getId()).ifPresent(entityManager::remove);
            entityManager.getTransaction().commit();
        }
        return (List<Booking>) booking;
    }
}
