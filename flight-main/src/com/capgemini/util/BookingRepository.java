package com.capgemini.util;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.entities.Booking1;


public class BookingRepository {
	private static List<Booking1>bookList=new ArrayList<Booking1>();
	public BookingRepository()
	{
		super();
		bookList.add(new Booking1());
	}
	
	public List<Booking1> getBookList() {
		return bookList;
	}
}

