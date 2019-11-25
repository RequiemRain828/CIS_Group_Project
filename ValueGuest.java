/*
 * Author: Austin Putnam & Ivan Zhang
 * Date: November 18, 2019
 * Assignment: Hotel Madison Part 1
 * Purpose: To create a ValueGuest object. 
*/
package CIS_Group_Project;

public class ValueGuest extends Guest{
    private String savingsNumber;
    private int numberOfBookings;
    private double amountSpentWithHotel;
    public ValueGuest(String username, String password, String guestName)
    {
        super(username, password, guestName);
    }
    
    public double getAmountSpentWithHotel()
    {
        return this.amountSpentWithHotel;
    }
    
    public int getNumberOfBookings()
    {
        return this.numberOfBookings;
    }
    
    public String getSavingsNumber()
    {
        return this.savingsNumber;
    }
}
