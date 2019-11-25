
package CIS_Group_Project;

public class Room {
    
    private int roomID;
    public int bedOption;
    public int kitchenOption;
    public int coffeeOption;
    public int accessibleOption;
    private int roomNumber;
    private int roomBookQuantity;
    private boolean roomBooked;
    private double roomCostPerNight;
    private static int nextID = 0;
    public boolean activeStatus;
    
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
    
    public boolean bookedRoom()
    {
        boolean roomTest;
        if (this.roomBooked == false)
            roomTest = false;
        else
        {
            roomTest = true;
            //this.roomBookQuantity++;
        }
        
        return roomTest;
        
    }
    
    public void bookRoom()
    {
        this.roomBookQuantity++;
        if (this.roomBooked == false)
            roomBooked = true;    
    }
    
    public void unbookRoom()
    {
        if (this.roomBooked == true)
            roomBooked = false;
    }
    
    public void freeThisRoom()
    {
        this.roomBooked = false;
    }
    
    public int getBookedRoomQuantity()
    {
        return this.roomBookQuantity;
    }
    
    public int getRoomID()
    {
        return this.roomID;
    }
    
    public int getRoomNumber()
    {
        return this.roomNumber;
    }
    
    public int getBedOption() {
        return this.bedOption;
    }
    
    public int getKitchenOption() {
        return this.kitchenOption;
    }
    
    public int getCoffeeOption() {
        return this.coffeeOption;
    }
    
    public int getAccessibleOption() {
        return this.accessibleOption;
    }
    
    public String displayRoomStatus()
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
    
    public String roomAnalytics()
    {
        String result = "";
        result = ("Number of Times Booked: " + this.getBookedRoomQuantity() + "\n" 
                + "Room Booked Status: " + this.displayRoomStatus() + "\n"  
                );
        return result;
    }
    
    public String roomDescription()
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
    
    public boolean setRoomNumber(int roomNumber)
    {
        return false;
    }
    
    
    
    
    
    
}
