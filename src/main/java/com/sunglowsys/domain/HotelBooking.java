package com.sunglowsys.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "hotel_booking")
public class HotelBooking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String checkInDate;

    @Column(nullable = false)
    private String checkOutDate;

    @Column(nullable = false)
    private Integer totalGuest;

    @Column(nullable = false)
    private Integer noOfNights;

    @Column(nullable = false)
    private Integer noOfRooms;

    @Column(nullable = false)
    private Float bookingAmount;


    public HotelBooking() {
    }

    public HotelBooking(Long id, String checkInDate, String checkOutDate, Integer totalGuest, Integer noOfNights, Integer noOfRooms, Float bookingAmount) {
        this.id = id;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalGuest = totalGuest;
        this.noOfNights = noOfNights;
        this.noOfRooms = noOfRooms;
        this.bookingAmount = bookingAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Integer getTotalGuest() {
        return totalGuest;
    }

    public void setTotalGuest(Integer totalGuest) {
        this.totalGuest = totalGuest;
    }

    public Integer getNoOfNights() {
        return noOfNights;
    }

    public void setNoOfNights(Integer noOfNights) {
        this.noOfNights = noOfNights;
    }

    public Integer getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public Float getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(Float bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HotelBooking that = (HotelBooking) o;
        return Objects.equals(id, that.id) && Objects.equals(checkInDate, that.checkInDate) && Objects.equals(checkOutDate, that.checkOutDate) && Objects.equals(totalGuest, that.totalGuest) && Objects.equals(noOfNights, that.noOfNights) && Objects.equals(noOfRooms, that.noOfRooms) && Objects.equals(bookingAmount, that.bookingAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, checkInDate, checkOutDate, totalGuest, noOfNights, noOfRooms, bookingAmount);
    }

    @Override
    public String toString() {
        return "HotelBooking{" +
                "id=" + id +
                ", checkInDate='" + checkInDate + '\'' +
                ", checkOutDate='" + checkOutDate + '\'' +
                ", totalGuest=" + totalGuest +
                ", noOfNights=" + noOfNights +
                ", noOfRooms=" + noOfRooms +
                ", bookingAmount=" + bookingAmount +
                '}';
    }
}
