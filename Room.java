/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CIS_Group_Project;

/**
 *
 * @author Ivan
 */
public class Room {
    private int roomID;
    private int bedOption;
    private int kitchenOption;
    private int coffeeOption;
    private int accessibleOption;
    private int roomNumber;
    private int roomBookQuantity;
    private boolean roomBooked;
    private double roomCostPerNight;
    private static int nextID = 0;
    
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
        if (this.roomBooked == true)
            roomTest = false;
        else
        {
            this.roomBooked = true;
            roomTest = true;
            this.roomBookQuantity++;
            
        }
        
        return roomTest;
        
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
    
    public double getRoomPrice()
    {
        return this.roomCostPerNight;
    }
    
    public String roomAnalytics()
    {
        String newString = "";
        newString = " Number of Times Booked: " + this.getBookedRoomQuantity() + ", Is Room booked? " + this.roomBooked;
        return newString;
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
                + ", and is classifed as a " + access + "." + "Room Cost Per Night: " 
                + this.roomCostPerNight;
        
        return test;
    }
    
    public boolean setRoomNumber(int roomNumber)
    {
        return false;
    }
    
    public void setRoomPrice(double roomPrice)
    {
        this.roomCostPerNight = roomPrice; 
    }
}
