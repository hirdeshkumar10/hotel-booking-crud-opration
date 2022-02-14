package com.sunglowsys.rest;

import com.sunglowsys.domain.HotelBooking;
import com.sunglowsys.service.HotelBookingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class HotelBookingResource {

    private final Logger log = LoggerFactory.getLogger(HotelBookingResource.class);

    private final HotelBookingService hotelBookingService;

    public HotelBookingResource(HotelBookingService hotelBookingService) {
        this.hotelBookingService = hotelBookingService;
    }

    @PostMapping("/hotel-bookings")
    public ResponseEntity<HotelBooking> createHotelBooking(@RequestBody HotelBooking hotelBooking) throws URISyntaxException {
        log.debug("Rest request to save HotelBooking: {}",hotelBooking);
        if (hotelBooking.getId() != null){
            throw new RuntimeException("Id should be null in save api calls");
        }
        HotelBooking result = hotelBookingService.create(hotelBooking);
        return ResponseEntity
                .created(new URI("/api/hotel-bookings/"+result.getId()))
                .body(result);
    }

    @PutMapping("/hotel-bookings")
    public ResponseEntity<HotelBooking> updateHotelBooking(@RequestBody HotelBooking hotelBooking){
        log.debug("Rest request to update HotelBooking: {}",hotelBooking);
        if (hotelBooking.getId() == null){
            throw new RuntimeException("Id should not be null in update api calls");
        }
        HotelBooking result = hotelBookingService.update(hotelBooking);
        return ResponseEntity
                .ok()
                .body(result);
    }

    @GetMapping("/hotel-bookings")
    public ResponseEntity<Page<HotelBooking>> findAllHotelBooking(Pageable pageable){
        log.debug("Rest request to findAll HotelBooking: {}",pageable.toString());
        Page<HotelBooking> result = hotelBookingService.findAll(pageable);
        return ResponseEntity
                .ok()
                .body(result);

    }

    @GetMapping("/hotel-bookings/{id}")
    public ResponseEntity<HotelBooking> findByIdHotelBooking(@PathVariable Long id){
        log.debug("Rest request to findById HotelBooking: {}",id);
        Optional<HotelBooking> result = hotelBookingService.findById(id);
        return ResponseEntity
                .ok()
                .body(result.get());
    }

    @DeleteMapping("/hotel-bookings/{id}")
    public ResponseEntity<Void> deleteHotelBooking(@PathVariable Long id){
        log.debug("Rest request to delete HotelBooking: {}",id);
        hotelBookingService.delete(id);
        return ResponseEntity
                .ok()
                .build();
    }
}
