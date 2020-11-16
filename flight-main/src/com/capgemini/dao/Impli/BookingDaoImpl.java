package com.capgemini.dao.Impli;


import com.capgemini.dao.Interface.IBookingDao;
import com.capgemini.entities.Booking1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingDaoImpl implements IBookingDao {
	
    private static Map<Integer, Booking1> bookingData = new HashMap<>();
    
    static
    {
    	
    }
    
    @Override
    public Booking1 addBooking(Booking1 b) {
    	
    	if (b != null) {
    		bookingData.put(b.getBookingId(),b);
    		return b;
    	}
    	else {
    		return null;
    	}
    }

    @Override
    public Booking1 viewBooking(int i) {
        Booking1 b = null;
		try {
			b=bookingData.get(i);
			return b;
		} catch (NullPointerException e) {
			return null;
		}
    }

	@Override
	public List<Booking1> viewAllBooking() {
		Collection<Booking1> coll=bookingData.values();
		List<Booking1> lists = new ArrayList<>(coll);
		return lists;
	}
	
    @Override
    public void deleteBooking(int i) {
        
    	try {
			bookingData.remove(i);
		} catch (NullPointerException e) {
			
		}
    	
    }

	@Override
	public Booking1 modifyBooking(Booking1 b) {
		if (b != null) {
    		bookingData.put(b.getBookingId(),b);
    		return b;
    	}
    	else {
    		return null;
    	}
	}

}
