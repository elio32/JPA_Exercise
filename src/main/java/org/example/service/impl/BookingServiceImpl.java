package org.example.service.impl;

import org.example.mapper.BookingMapper;
import org.example.model.dto.BookingTDO;
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
    public List<BookingTDO> loadAllBookings() {
        return bookingRepository.findAll().stream().map(bookingMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public List<BookingTDO> deleteBooking(Booking booking) {
        return bookingRepository.delete(booking).stream().map(bookingMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public List<BookingTDO> findBookingById(Long id) {
        return bookingRepository.findById(id).stream().map(bookingMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public List<BookingTDO> saveNewBooking(Booking booking) {
        return bookingRepository.save(booking).stream().map(bookingMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public List<BookingTDO> findByBookingDate(Date bookingDate) {
        return bookingRepository.findByBookingDate(bookingDate).stream().map(bookingMapper::toDto).collect(Collectors.toList());

    }
}
