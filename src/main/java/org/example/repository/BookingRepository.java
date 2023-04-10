package org.example.repository;

import org.example.model.entity.Booking;

import java.util.Date;
import java.util.List;

public interface BookingRepository extends Repository<Booking,Long>{
    List<Booking> findByBookingDate(Date bookingDate);
}
