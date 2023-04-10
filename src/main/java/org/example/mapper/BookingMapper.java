package org.example.mapper;

import org.example.model.dto.BookingTDO;
import org.example.model.entity.Booking;

public class BookingMapper extends AbstractMapper<Booking, BookingTDO>{
    @Override
    public Booking toEntity(BookingTDO bookingTDO) {
        return null;
    }

    @Override
    public BookingTDO toDto(Booking booking) {
        BookingTDO bookingTDO = new BookingTDO();
        bookingTDO.setId(booking.getId());
        bookingTDO.setBookingDate(booking.getBookingDate());
        bookingTDO.setStatus(booking.getStatus());
        return bookingTDO;
    }
}
