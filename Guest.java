


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GitHub.CIS_Group_Project;


/**
 *
 * @author Ivan
 */
public class Guest {
    private int guestID;
    private String username;
    private String password;
    private String guestName;
    private static int nextID = 0;
    
    public Guest(String username, String password, String guestName)
    {
        this.guestID = nextID++;
        this.username = username;
        this.password = password;
        this.guestName = guestName;
    }
    
    public boolean checkCredentials(String username, String password)
    {
        boolean credentials = false;
        if (this.username.equals(username) && this.password.equals(password))
                {
                    credentials = true;
                }
        return credentials;
    }
     public String getGuestName()
    {
        return this.guestName;
    }
    
    public String getUsername()
    {
        return this.username;
    }
    
    public void setGuestName(String guestName)
    {
        this.guestName = guestName;
    }
    
     public int setPassword(String oldP, String newP)
    { int x=0;
        if (this.password.equals(oldP))
        {
            this.password=newP;
            x=1;
        }
       
        return x;
    }
}
