package com.capgemini.dao.Interface;

import java.util.List;

import com.capgemini.entities.Booking1;

public interface IBookingDao {
    public Booking1 addBooking(Booking1 b);
    public Booking1 modifyBooking(Booking1 b);
    public Booking1 viewBooking(int i);
    public List<Booking1> viewAllBooking();
    public void deleteBooking(int i);
}
