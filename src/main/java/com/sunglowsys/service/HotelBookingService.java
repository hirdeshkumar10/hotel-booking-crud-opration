package com.sunglowsys.service;

import com.sunglowsys.domain.HotelBooking;

import java.util.List;
import java.util.Optional;

public interface HotelBookingService {

    HotelBooking create(HotelBooking hotelBooking);

    HotelBooking update(HotelBooking hotelBooking);

    List<HotelBooking> findAll();

    Optional<HotelBooking> findById(Long id);

    void delete(Long id);
}
