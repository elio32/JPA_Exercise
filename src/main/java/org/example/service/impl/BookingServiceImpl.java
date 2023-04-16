package org.example.service.impl;

import org.example.mapper.BookingMapper;
import org.example.model.dto.BookingDTO;
import org.example.model.entity.Booking;
import org.example.repository.impl.BookingRepositoryImpl;
import org.example.service.BookingService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class BookingServiceImpl implements BookingService {

    private final BookingRepositoryImpl bookingRepository;
    private final BookingMapper bookingMapper;

    public BookingServiceImpl() {
        this.bookingMapper = new BookingMapper();
        this.bookingRepository = new BookingRepositoryImpl();
    }

    @Override
    public List<BookingDTO> loadAllBookings() {
        return bookingRepository.findAll().stream().map(bookingMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public List<BookingDTO> deleteBooking(Booking booking) {
        return bookingRepository.delete(booking).stream().map(bookingMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public List<BookingDTO> findBookingById(Long id) {
        return bookingRepository.findById(id).stream().map(bookingMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public List<BookingDTO> saveNewBooking(Booking booking) {
        return bookingRepository.save(booking).stream().map(bookingMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public List<BookingDTO> findByBookingDate(Date bookingDate) {
        return bookingRepository.findByBookingDate(bookingDate).stream().map(bookingMapper::toDto).collect(Collectors.toList());

    }
}
