package com.capgemini.service.Interface;
/**
 * @author
 */

import java.util.List;

import com.capgemini.entities.Booking1;
import com.capgemini.entities.Passenger;

public interface IBookingService {
    public Booking1 addBooking(Booking1 b);
    public Booking1 modifyBooking(Booking1 b);
    public Booking1 viewBooking(int i);
    public void deleteBooking(int i);
    public void validateBooking(Booking1 b);
    public void validatePassenger(Passenger p);
	List<Booking1> viewAllBooking();

}
