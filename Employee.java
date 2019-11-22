/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CIS_Group_Project;


import java.util.*;

/**
 *
 * @author Ivan
 */
public class Employee {
    private int employeeID;
    private String username;
    private String password;
    private String employeeName;
    public static int nextID = 0;
    public static ArrayList<Employee> employeeArray = new ArrayList<Employee>();

    
    public Employee (String username, String password, String employeeName)
    {
//        this.employeeArray.add(new Employee(username, password, employeeName));
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
