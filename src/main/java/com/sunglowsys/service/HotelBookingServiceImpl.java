package com.sunglowsys.service;

import com.sunglowsys.domain.HotelBooking;
import com.sunglowsys.repository.HotelBookingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelBookingServiceImpl implements HotelBookingService{

    private final Logger log = LoggerFactory.getLogger(HotelBooking.class);

    private final HotelBookingRepository hotelBookingRepository;

    public HotelBookingServiceImpl(HotelBookingRepository hotelBookingRepository) {
        this.hotelBookingRepository = hotelBookingRepository;
    }

    @Override
    public HotelBooking create(HotelBooking hotelBooking) {
        log.debug("Request to save HotelBooking: {}",hotelBooking);
        return hotelBookingRepository.save(hotelBooking);
    }

    @Override
    public HotelBooking update(HotelBooking hotelBooking) {
        log.debug("Request to update HotelBooking: {}",hotelBooking);
        return hotelBookingRepository.save(hotelBooking);
    }

    @Override
    public Page<HotelBooking> findAll(Pageable pageable) {
        log.debug("Request to findAll HotelBooking: {}",pageable.toString());
        return hotelBookingRepository.findAll(pageable);
    }

    @Override
    public Optional<HotelBooking> findById(Long id) {
        log.debug("Request to findById HotelBooking: {}",id);
        return hotelBookingRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete HotelBooking: {}",id);
        hotelBookingRepository.deleteById(id);

    }
}
