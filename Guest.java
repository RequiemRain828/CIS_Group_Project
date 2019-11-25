/*
 * Author: Austin Putnam
 * Date: November 18, 2019
 * Assignment: Hotel Madison Part 1
 * Purpose: To create a Guest object. 
*/
package CIS_Group_Project;


public class Guest 
{
    private int guestID;
    private String username;
    private String password;
    private String guestName;
    private static int nextID = 0;
    
    public Guest(String username, String password, String guestName) // Constructor
    {
        this.guestID = nextID++;
        this.username = username;
        this.password = password;
        this.guestName = guestName;
    }
    
    public boolean checkCredentials(String username, String password) // Checks login credentials
    {
        boolean credentials = false;
        if (this.username.equals(username) && this.password.equals(password))
                {
                    credentials = true;
                }
        return credentials;
    }
     public String getGuestName() // Getter for guest name
    {
        return this.guestName;
    }
    
    public String getUsername() // Getter for guest username
    {
        return this.username;
    }
    
    public void setGuestName(String guestName) // Setter for guest name
    {
        this.guestName = guestName;
    }
    
     public int setPassword(String oldP, String newP) // Allows user to change passwords
    { 
         int x=0;
         if (this.password.equals(oldP))
         {
             this.password=newP;
             x = 1;
         }
       
         return x;
    }
}
