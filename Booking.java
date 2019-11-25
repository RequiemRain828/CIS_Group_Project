/*
 * Author: Marin Walters
 * Date: November 18, 2019
 * Assignment: Hotel Madison Part 1
 * Purpose: To create a booking - The Booking class acts as a “cross-table” object 
            and creates a link between a Guest object and a Room object. 
*/
package CIS_Group_Project;


public class Booking {
    public Room bookedRoom;
    public Guest bookingGuest;
    public int bookingYear;
    public int checkInDay;
    public int checkOutDay;
    public int counter;
    
    private static int nextID = 1;
    
    public Booking(Guest bookingGuest, Room bookedRoom, int year, int checkIn, 
            int checkOut){
        this.bookingGuest = bookingGuest;
        this.bookedRoom = bookedRoom;
        this.bookingYear = year;
        this.checkInDay = checkIn;
        this.checkOutDay = checkOut;
        this.counter = nextID++;
    }
    
    public Guest getBookingGuest(){
        return this.bookingGuest;
    }
    
    public Room getBookedRoom(){
        return this.bookedRoom;
    }
    
    public void endBooking(){
        this.bookedRoom.freeThisRoom();
    }
    
    public String toString(){
        String result = "";
        result += this.bookingGuest.getGuestName() + " booked room " + this.bookedRoom.getRoomNumber() 
                + " in " + this.bookingYear ;
        return result; 
    }
    
    public int getCounter(){
        return this.counter;
    }
}
