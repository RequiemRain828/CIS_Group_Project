package Group_Project;


public class Booking {
    public Room bookedRoom;
    public Guest bookingGuest;
    public int bookingYear;
    public int checkInDay;
    public int checkOutDay;
    
    private static int nextID = 0;
    
    public Booking(Guest bookingGuest, Room bookedRoom, int year, int checkIn, 
            int checkOut){
        this.bookingGuest = bookingGuest;
        this.bookedRoom = bookedRoom;
        this.bookingYear = year;
        this.checkInDay = checkIn;
        this.checkOutDay = checkOut; 
    }
    
    public void endBooking(){
        
    }
}
