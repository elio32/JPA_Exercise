package org.example.service;

import org.example.model.dto.BookingDTO;
import org.example.model.entity.Booking;

import java.util.Date;
import java.util.List;

public interface BookingService {
    List<BookingDTO> loadAllBookings();
    List<BookingDTO> deleteBooking(Booking booking);
    List<BookingDTO> findBookingById(Long id);
    List<BookingDTO> saveNewBooking(Booking booking);
    List<BookingDTO> findByBookingDate(Date bookingDate);
}
