
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
    
    public Room (int bed, int kitch, int coffee, int accessibility, int roomNumber)
    {
        this.roomID = nextID++;
        this.bedOption = bed;
        this.kitchenOption = kitch;
        this.coffeeOption = coffee;
        this.accessibleOption = accessibility;
        this.roomNumber = roomNumber;
    }
    
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
    
    public void bookRoom()
    {
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
    
    public String roomAnalytics()
    {
        return "";
    }
    
    public String roomDescription()
    {
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
        
        String test = "Room #" + this.roomNumber + " comes fully furnished with " 
                + bed + ", a " + kitchen + ", a " + coffee 
                + ", and is classifed as a " + access + ".";
        return test;
    }
    
    public boolean setRoomNumber(int roomNumber)
    {
        return false;
    }
    
    
    
    
    
    
}
