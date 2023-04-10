package org.example.service;

import org.example.model.dto.BookingTDO;
import org.example.model.entity.Booking;

import java.util.Date;
import java.util.List;

public interface BookingService {
    List<BookingTDO> loadAllBookings();
    List<BookingTDO> deleteBooking(Booking booking);
    List<BookingTDO> findBookingById(Long id);
    List<BookingTDO> saveNewBooking(Booking booking);
    List<BookingTDO> findByBookingDate(Date bookingDate);
}
