/*
 * Author: Austin Putnam & Ivan Zhang
 * Date: November 18, 2019
 * Assignment: Hotel Madison Part 1
 * Purpose: To create a ValueGuest object. 
*/
package CIS_Group_Project;

public class ValueGuest extends Guest
{
    private String savingsNumber;
    private int numberOfBookings;
    private double amountSpentWithHotel;
    
    public ValueGuest(String username, String password, String guestName) // Constructor
    {
        super(username, password, guestName);
    }
    
    public double getAmountSpentWithHotel() // Getter for amount spent at hotel
    {
        return this.amountSpentWithHotel;
    }
    
    public int getNumberOfBookings() // Getter for number of previous bookings
    {
        return this.numberOfBookings;
    }
    
    public String getSavingsNumber() // Getter for amount of savings
    {
        return this.savingsNumber;
    }
}
