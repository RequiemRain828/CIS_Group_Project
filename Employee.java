/*
 * Author: Austin Putnam & Ivan Zhang
 * Date: November 18, 2019
 * Assignment: Hotel Madison Part 1
 * Purpose: To create an Employee object. 
*/
package CIS_Group_Project;


import java.util.*;

public class Employee {
    private int employeeID;
    private String username;
    private String password;
    private String employeeName;
    public static int nextID = 0;
    public static ArrayList<Employee> employeeArray = new ArrayList<Employee>();

    
    public Employee (String username, String password, String employeeName)
    {
        this.employeeID = nextID++;
        this.username = username;
        this.password = password;
        this.employeeName = employeeName;
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
    
    public String getEmployeeName()
    {
        return this.employeeName;
    }
    
    public String getUsername()
    {
        return this.username;
    }
    
    public void setEmployeeName(String employeeName)
    {
        this.employeeName = employeeName;
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
