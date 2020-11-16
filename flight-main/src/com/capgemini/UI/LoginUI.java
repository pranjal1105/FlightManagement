package com.capgemini.UI;

import com.capgemini.dao.Impli.BookingDaoImpl;
import com.capgemini.dao.Impli.FlightDaoImpl;
import com.capgemini.dao.Impli.ScheduleDaoImpl;
import com.capgemini.dao.Impli.UserDaoImpl;
import com.capgemini.entities.Airport;
import com.capgemini.entities.Booking;
import com.capgemini.entities.Flight;
import com.capgemini.entities.Schedule;
import com.capgemini.entities.ScheduledFlight;
import com.capgemini.entities.Users;
import com.capgemini.service.Impli.BookingServiceImpl;
import com.capgemini.service.Impli.IFlightServiceImpl;
import com.capgemini.service.Impli.ScheduleServiceImpl;
import com.capgemini.service.Impli.UserServiceImpl;
import com.capgemini.service.Interface.IBookingService;
import com.capgemini.service.Interface.IFlightService;
import com.capgemini.service.Interface.IUserService;
import com.capgemini.service.Interface.ScheduleService;

import java.time.LocalDateTime;
//import com.capgemini.util.MyDBConnection;
/**
 *
 */
//import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class LoginUI {
    /**
     *
     * @param args
     */

    public static void main(String[] args)
    {
        //Connection con = MyDBConnection.getConnection();
        //LoginUI ui = new LoginUI();
        LoginUI.runUi();

    }

    static void runUi() {
        /**
         * Login Details and SignUp Details
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("LOGIN PRESS 1");
        System.out.println("SIGNUP PRESS 2");
        System.out.println("EXIT PRESS 3");
        System.out.println("Enter your choice");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter UserID");
                int uid = sc.nextInt();
                System.out.println("Enter Password");
                String pass = sc.next();
                UserServiceImpl us = new UserServiceImpl(new UserDaoImpl());
                Users u = us.validateUser(uid, pass);
                if (u != null) {
                    if (u.getUserType().equals("A")) {
                        displayAdminPanel(u);
                    } else {
                        displayCustomerPanel(u.getUserName());
                    }
                } else {
                    System.out.println("Invalid User Data!!");
                    runUi();

                }
                break;

            case 2:
                IUserService us1 = new UserServiceImpl(new UserDaoImpl());
                System.out.println("Do you want to signUp");
                System.out.println("Enter the userId");
                int i = sc.nextInt();
                System.out.println("Enter the UserName :");
                String name = sc.next();
                System.out.println("Enter the password");
                String pass1 = sc.next();
                System.out.println("Enter the UserPhone :");
                long phone = sc.nextLong();
                System.out.println("Enter the Email :");
                String email = sc.next();
                System.out.println("Enter the userType either C or A");
                String userType = sc.next();
                Users u1 = new Users(i, name, pass1, phone, email, userType);
                us1.addUser(u1);
                System.out.println("New user created");
                runUi();
                break;
            case 3:
                System.out.println("Terminate");
                sc.close();
                return;
            default:
                System.out.println("Invalid Choice");
                break;
        }

        sc.close();
    }

    private static void displayAdminPanel(Users user)
    /**
     * Display all the Admin control methods
     */
    {
        System.out.println("Welcome " + user.getUserName() + "! You are Admin.");
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 1 to add Flight Details");
        System.out.println("Press 2 to modify Flight details");
        System.out.println("Press 3 to remove Flight details");
        System.out.println("press 4 to search a flight by id");
        System.out.println("Press 5 to add Schedule Details");
        System.out.println("Press 6 to remove ScheduleFlight details");
   
        System.out.println("press 7 to search a Schedule Flight");
        System.out.println("press 8 to List all Users1");
        System.out.println("press 9 to Logout");
        System.out.println("Enter your choice");
        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {

            case 1:
                IFlightService serviceFlight1 = new IFlightServiceImpl(new FlightDaoImpl());
                System.out.println("Enter the flight number");
                int fn = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the flight model");
                String fm = sc.next();
                System.out.println("Enter the flight seat capacity");
                int fsc = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the flight carrier name");
                String fcn = sc.next();
                Flight f = new Flight(fn, fm, fsc, fcn);
                serviceFlight1.addFlight(f);
                displayAdminPanel(user);
                break;

            case 2:
                IFlightService serviceFlight2 = new IFlightServiceImpl(new FlightDaoImpl());
                System.out.println("Enter the  Flight number which is to be modify");
                int fn1 = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the new flight model");
                String fm1 = sc.next();
                System.out.println("Enter the new seat Capacity");
                int sc1 = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the new Flight carrier name");
                String fcn1 = sc.next();
                Flight f1 = new Flight(fn1, fm1, sc1, fcn1);
                serviceFlight2.modifyFlight(f1);
                displayAdminPanel(user);
                break;

            case 3:
                IFlightService serviceFlight3 = new IFlightServiceImpl(new FlightDaoImpl());
                System.out.println("Enter the  Flight number which is to be Delete");
                int fn2 = sc.nextInt();
                sc.nextLine();
                serviceFlight3.deleteFlight(fn2);
                displayAdminPanel(user);
                break;

            case 4:
                IFlightService serviceFlight4 = new IFlightServiceImpl(new FlightDaoImpl());
                System.out.println("Enter the  Flight number");
                int fn3 = sc.nextInt();
                sc.nextLine();
                Flight f2 = serviceFlight4.viewFlight(fn3);
                System.out.println(f2);
                displayAdminPanel(user);
                break;

            case 5:
                ScheduleService serviceScheduleFlight1 = new ScheduleServiceImpl(new ScheduleDaoImpl());
                System.out.println("Enter flight details");
                System.out.println("Enter the flight number");
                int fnn = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the flight model");
                String fmm = sc.next();
                System.out.println("Enter the flight seat capacity");
                int fscc = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the flight carrier name");
                String fcnn = sc.next();
                Flight f4 = new Flight(fnn, fmm, fscc, fcnn);
                System.out.println("Enter source airport details");
                sc.nextLine();
                System.out.println("Enter airport name");
                String sAirportName=sc.nextLine();
                System.out.println("Enter airport location");
                String sAirportLocation=sc.nextLine();
                System.out.println("Enter airport code");
                String sAirportCode=sc.nextLine();
                Airport source=new Airport(sAirportName,sAirportLocation,sAirportCode);
                System.out.println("Enter destination airport details");
                //sc.nextLine();
                System.out.println("Enter airport name");
                String dAirportName=sc.nextLine();
                System.out.println("Enter airport location");
                String dAirportLocation=sc.nextLine();
                System.out.println("Enter airport code");
                String dAirportCode=sc.nextLine();
                Airport destination=new Airport(dAirportName,dAirportLocation,dAirportCode);
                System.out.println("Enter arrival date time");
                String arrivalDateTime=sc.nextLine();
                LocalDateTime at = LocalDateTime .parse(arrivalDateTime);
                String departureDateTime=sc.nextLine();
                LocalDateTime dt = LocalDateTime .parse(departureDateTime);
                Schedule sch=new Schedule(source,destination,at,dt);
                //LocalDateTime newDate = dateInput(stringInput("Enter a date (like 3/3/17): "));
                System.out.println("Enter available seats");
                int availSeats=sc.nextInt();
                sc.nextLine();
                ScheduledFlight scf=new ScheduledFlight(f4,availSeats,sch);
                serviceScheduleFlight1.scheduleFlight(scf);
                displayAdminPanel(user);
                break;
            case 6:
                ScheduleService serviceScheduleFlight3 = new ScheduleServiceImpl(new ScheduleDaoImpl());
                System.out.println("Enter the  ScheduleFlight Id which is to be Delete");
                int scf3 = sc.nextInt();
                sc.nextLine();
                serviceScheduleFlight3.deleteScheduledFlight(scf3);
                displayAdminPanel(user);
                break;

            case 7:
                ScheduleService serviceScheduleFlight4 = new ScheduleServiceImpl(new ScheduleDaoImpl());
                System.out.println("Enter the Schedule Flight id");
                int fid1 = sc.nextInt();
                sc.nextLine();
                System.out.println(serviceScheduleFlight4.viewScheduledFlight(fid1));
                displayAdminPanel(user);
                break;
            case 8:
            	UserServiceImpl us = new UserServiceImpl(new UserDaoImpl());
            	List<Users> list = us.viewAllUser();
            	for (Users u : list) {
            		System.out.println(u);
            	}
            	System.out.println();
            	displayAdminPanel(user);
            	break;
            case 9:
                System.out.println("LogoutSuccessfully");
                runUi();
                sc.close();
                return;
            default: {
                System.out.println("Incorrect choice");
                displayAdminPanel(user);
                break;
            }
        }
        
        sc.close();
    }

    private static void displayCustomerPanel(String userName)
    /**
     * Display all the Customer methods
     */
    {
        System.out.println("Welcome " + userName + "! You are Customer.");
        Scanner sc = new Scanner(System.in);
        System.out.println("Press 1 to do Booking");
        System.out.println("Press 2 to cancel Booking details");
        System.out.println("Press 3 to view Booking Details of specific id");
        System.out.println("Press 4 to view all flight details");
        System.out.println("Press 5 to Logout");
        System.out.println("Enter your choice");
        int choice = sc.nextInt();

        switch (choice) {

            case 1:
                //IBookingService serviceBooking1 = new BookingServiceImpl(new BookingDaoImpl());
                //System.out.println("Enter the Booking id");
                //int id = sc.nextInt();
                //System.out.println("Enter the date");
                //String date = sc.next();
                //System.out.println("Enter the ticketCost");
                //double tc = sc.nextDouble();
                //System.out.println("Enter the no of passengers");
                //int noofPassengers = sc.nextInt();
                //Booking b = new Booking(id, date, tc, noofPassengers);
                //serviceBooking1.addBooking(b);
                displayCustomerPanel(userName);
                break;


            case 2:
                IBookingService serviceBooking3 = new BookingServiceImpl(new BookingDaoImpl());
                System.out.println("Enter the Booking id which is to be deleted");
                int id2 = sc.nextInt();
                serviceBooking3.deleteBooking(id2);
                displayCustomerPanel(userName);
                break;

            case 3:
                //IBookingService serviceBooking4 = new BookingServiceImpl(new BookingDaoImpl());
                //System.out.println("Enter the Booking id to view the details");
                //int id3 = sc.nextInt();
                //Booking b2 = serviceBooking4.viewBooking(id3);
                //System.out.println(b2);
                displayCustomerPanel(userName);
                break;

            case 4:
                IFlightService serviceFlight = new IFlightServiceImpl(new FlightDaoImpl());
                //System.out.println("Enter the Flight id");
                //int id4 = sc.nextInt();
                List<Flight> flights = serviceFlight.viewAllFlight();
                for (Flight i : flights)
                    System.out.println(i);
                displayCustomerPanel(userName);
                break;
            case 5:
                System.out.println("LogoutSuccessfully");
                runUi();
                sc.close();
                return;

            default: {
                System.out.println("Incorrect choice");
                displayCustomerPanel(userName);
            }
        }
        sc.close();
    }
}
