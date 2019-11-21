
package CIS_Group_Project;

import java.util.Scanner;
import java.util.ArrayList;

public class HotelMadison
{
    private static ArrayList<Employee> employees = new ArrayList();
    private static ArrayList<Guest> guests = new ArrayList();
    public static void main(String[] args) 
    {
        Employee e1 = new Employee ("putna2ag" , "QWERTY1", "Austin Putnam");
        employees.add(e1);
        
        Employee e2 = new Employee ("bcarson","12345a","Ben Carson");
        employees.add(e2);
        
        Guest g1 = new Guest("trobbins", "password", "Tim Robbins");
        guests.add(g1);
        
        Guest g2 = new Guest("mthorton" , "alphaprotocol", "Mike Thorton");
        guests.add(g2);
        
        Scanner keyboardInput = new Scanner(System.in);
        
        System.out.println("Enter 1 to login as a Guest");
        System.out.println("Enter 2 to login as an Employee\n");
        
        System.out.print("Please enter your choice: ");
        
        int choice = keyboardInput.nextInt();
        
        switch(choice)
        {
            
            case 1:
                checkGuest();
                
                break;
                
     
            case 2:
                checkEmployee();
                employeeMenu();
                break;
                

        }
        
    }
    
    public static void checkGuest()
    {
        Scanner keyboardInput = new Scanner (System.in);
        int x = 0;
        do
        {        
            System.out.print("Please enter your name: ");
            String usernameTest = keyboardInput.nextLine();
                    
            System.out.print("Please enter your password: ");
            String passwordTest = keyboardInput.nextLine();
                    
            for(int i =0; i< guests.size(); i++)
            {
                if (guests.get(i).checkCredentials(usernameTest, passwordTest) == true)
                {
                    System.out.println("\nWelcome, " + usernameTest + "!");
                    x = 1;
                    break;
                }
                       
                if (i == guests.size() - 1 && 
                        guests.get(i).checkCredentials(usernameTest, passwordTest) == false)
                {
                    System.out.println("Sorry, your username or password is incorrect. Please try again.");
                }
            }
        }
                
        while(x==0);
                
    }
   
    public static void checkEmployee()
    {
        Scanner keyboardInput = new Scanner (System.in);
        int x = 0;
        do
        {        
            System.out.print("Please enter your name: ");
            String usernameTest = keyboardInput.nextLine();
                    
            System.out.print("Please enter your password: ");
            String passwordTest = keyboardInput.nextLine();
                    
            for(int i =0; i< employees.size(); i++)
            {
                if (employees.get(i).checkCredentials(usernameTest, passwordTest) == true)
                {
                    System.out.println("\nWelcome, " + usernameTest + "!");
                    x = 1;
                    break;
                }
                       
                if (i == employees.size() - 1 && 
                        employees.get(i).checkCredentials(usernameTest, passwordTest) == false)
                {
                    System.out.println("Sorry, your username or password is incorrect. Please try again.");
                }
            }
        }
                
        while(x == 0);
                
    }
    
    public static void employeeMenu()
    {   Scanner input = new Scanner(System.in);
        int menuChoice;
        
        do
        {
        System.out.println("------------------");
        System.out.println("Option 1");
        System.out.println("Option 2");
        System.out.println("Option 3");
        System.out.println("Option 4");
        System.out.println("Option 5");
        System.out.println("Please enter an option");
        menuChoice = input.nextInt();
        System.out.println("---------------------");
        } while (menuChoice != 6);
        switch(menuChoice) {
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            default:
                System.out.print("Invalid option, Please enter an option between 1-6");
        }
    }
    
    public static void guestMenu()
    {
        Scanner input = new Scanner(System.in);
        int menuChoice;
        
        do
        {
        System.out.println("------------------");
        System.out.println("Option 1");
        System.out.println("Option 2");
        System.out.println("Option 3");
        System.out.println("Please enter an option");
        menuChoice = input.nextInt();
        System.out.println("---------------------");
        } while (menuChoice != 3);
    }
}
   
   
