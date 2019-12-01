/*
 * Author: Austin Putnam, Marin Walters & Ivan Zhang
 * Date: November 18, 2019
 * Assignment: Hotel Madison Part 1
 * Purpose: To create a Room object. 
*/
package CIS_Group_Project;

public class Room 
{
    
    private int roomID;
    public int bedOption;
    public int kitchenOption;
    public int coffeeOption;
    public int accessibleOption;
    private int roomNumber;
    private int roomBookQuantity;
    private boolean roomBooked;
    public double roomCostPerNight;
    private static int nextID = 0;
    public boolean roomStatus;
    
    // Constructor
    public Room (int bed, int kitch, int coffee, int accessibility, int roomNumber, double roomPrice) 
    {
        this.roomID = nextID++;
        this.bedOption = bed;
        this.kitchenOption = kitch;
        this.coffeeOption = coffee;
        this.accessibleOption = accessibility;
        this.roomNumber = roomNumber;
        this.roomCostPerNight = roomPrice;
        
    }
    
    public boolean roomStatus() //Checks to see if room is currently active
    {
        boolean result;
        // Room is active
        if (this.roomStatus == false)
        {
            result = false;
        }
        else
        {
        // Room is inactive
            result = true;
        }
        return result;
    }
    
    /*
    * @author Marin Walters
    */
    public boolean bookedRoom()
    {
        boolean roomTest;
        if (this.roomBooked == false)
            roomTest = false;
        else
        {
            roomTest = true;
        }
        
        return roomTest;
        
    }
    
    /*
    * @author Marin Walters
    */
    public void bookRoom()
    {
        this.roomBookQuantity++;
        if (this.roomBooked == false)
            roomBooked = true;    
    }
    
    /*
    * @author Marin Walters
    */
    public void unbookRoom()
    {
        if (this.roomBooked == true)
            roomBooked = false;
    }
    
    public void freeThisRoom() // Unbooks a room
    {
        this.roomBooked = false;

    }
    
    public int getBookedRoomQuantity() // Getter for the number of booked rooms
    {
        return this.roomBookQuantity;
    }
    
    public int getRoomID() // Getter for the room ID
    {
        return this.roomID;
    }
    
    public int getRoomNumber() // Getter for the room number
    {
        return this.roomNumber;
    }
    
    public int getBedOption() // Getter for the bed option
    {
        return this.bedOption;
    }
    
    public int getKitchenOption() // Getter for the kitchen option
    {
        return this.kitchenOption;
    }
    
    public int getCoffeeOption() // Getter for the coffee option
    {
        return this.coffeeOption;
    }
    
    public int getAccessibleOption() // Getter for the room's accessibility
    {
        return this.accessibleOption;
    }
    
    public String displayRoomStatus()  // Displays the room's current activity status
    {
        String status  = "";
        if(this.roomStatus)
        {
           status = "Inactive";
           
        }
        else
        {
            status = "Active";
        }
        return status;
    }
    
    public String displayRoomBooked() // Display's the room's booking status
    {
        String booked = "";
        if(this.roomBooked)
        {
           booked = "Booked";
           
        }
        else
        {
            booked = "Available";
        }
        return booked;
    }
    
    public String roomAnalytics() // Returns information about a selected room
    {
        String result = "";
        result = ("Number of Times Booked: " + this.getBookedRoomQuantity() + "\n" 
                + "Room Booked Status: " + this.displayRoomBooked() + "\n"  
                + "Room active Status: " + this.displayRoomStatus() + "\n");
        return result;
    }
    
    public String roomDescription() //Describes the amenities and features of a room
    {
        String desc = "";
        String bed = "";
        String coffee = "";
      
        String kitchen = "";
        String access = "";
        
        switch(this.bedOption)
        {
            case 1:
                bed = "1 Queen Bed";
                break;
            case 2:
                bed = "2 Queen Beds";
                break;
            case 3:
                bed = "1 King Bed";
                break;
        }
        
        switch(this.kitchenOption)
        {
            case 1:
                kitchen = "Microwave";
                break;
            case 2:
                kitchen = "Fridge + Microwave";
                break;
        }
        
        switch(this.coffeeOption)
        {
            case 1:
                coffee = "1-Cup Std. Coffee Machine";
                break;
            case 2:
                coffee = "Keurig Hot K200 Coffee Machine";
                break;
        }
        
        switch(this.accessibleOption)
        {
            case 1:
                access = "Standard Room";
                break;
            case 2:
                access = "Enhanced Accessibility Room";
                break;
        }
        
        desc = ("Room Number: " + this.getRoomNumber() + " comes fully furnished with \n" 
                + bed + ", a " + kitchen + ", a " + coffee + "\n"
                + "and is classifed as a " + access + "\n"
                + "Room Price Per Night is $" + this.roomCostPerNight + "\n"
                );
        return desc;
    }
    
    public boolean setRoomNumber(int roomNumber) // Setter for room number
    {
        return false;
    }
        
}
