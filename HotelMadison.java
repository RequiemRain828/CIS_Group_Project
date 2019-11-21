
package GitHub.CIS_Group_Project;




import java.util.Scanner;
import java.util.ArrayList;

public class HotelMadison
{
    private static ArrayList<Employee> employee = new ArrayList();
    private static ArrayList<Guest> guest = new ArrayList();
    public static void main(String[] args) 
    {

        Employee e1 = new Employee ("putna2ag" , "QWERTY1", "Austin Putnam");
        employee.add(e1);
        
        Employee e2 = new Employee ("bcarson","12345a","Ben Carson");
        employee.add(e2);
        
        Guest g1 = new Guest("trobbins", "password", "Tim Robbins");
        guest.add(g1);
        
        Guest g2 = new Guest("mthorton" , "alphaprotocol", "Mike Thorton");
        guest.add(g2);
        
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
                break;
        }
        
    }
    
    public static void checkGuest()
    {
        Scanner keyboardInput = new Scanner (System.in);
        int x = 0;
        do
        {        
            System.out.print("Please enter your username: ");
            String usernameTest = keyboardInput.nextLine();
                    
            System.out.print("Please enter your password: ");
            String passwordTest = keyboardInput.nextLine();
                    
            for(int i =0; i< guest.size(); i++)
            {
                if (guest.get(i).checkCredentials(usernameTest, passwordTest) == true)
                {
                    System.out.println("\nWelcome, " + usernameTest + "!");
                  
                    x = 1;
                    break;
                }
                       
                if (i == guest.size() - 1 && 
                        guest.get(i).checkCredentials(usernameTest, passwordTest) == false)
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
            System.out.print("Please enter your username: ");
            String usernameTest = keyboardInput.nextLine();
                    
            System.out.print("Please enter your password: ");
            String passwordTest = keyboardInput.nextLine();
                    
            for(int i =0; i< employee.size(); i++)
            {
                
                if (employee.get(i).checkCredentials(usernameTest, passwordTest) == true)
                {
                    System.out.println("\nWelcome, " + usernameTest + "!");
                      employeeMenu();
                    x = 1;
                    break;
                }
                       
                if (i == employee.size() - 1 && 
                        employee.get(i).checkCredentials(usernameTest, passwordTest) == false)
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
        System.out.println("1. Run a Booking Report");
        System.out.println("2. Check a Guest out");
        System.out.println("3. Create a Guest Account");
        System.out.println("4. Edit  Guest Account");
        System.out.println("5. Create an Employee Account");
        System.out.println("6. Edit an Employee Account");
        System.out.println("7. Create Guest Rooms");
        System.out.println("8. Edit or make a Room Inactive");
        System.out.println("9. Exit Program");
        System.out.print("Please enter an option: ");
        menuChoice = input.nextInt();
        System.out.println("---------------------");
        
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
                 newemployee();
                break;
            case 6:
                editemployee();
                break;
            default:
                System.out.print("Invalid option, Please enter an option between 1-6");
        }
        } while (menuChoice != 9);
    }
    
    public static void guestMenu()
    {
        System.out.print("Guest Menu");
        
    }
    
    public static void bookingReport()
    {
        
    }
    
    public static void guestOut()
    {
        
    }
    
    public static void createGuest()
    {
        
    }
   public static void newemployee()
    {       
//ArrayList<Employee> employees = employee;

    int x=1;
String choice ;
String userName;
String passWord;
String name;
int  counter=employee.size();

Scanner in = new Scanner(System.in);
Scanner in1= new Scanner(System.in);
Scanner in2= new Scanner(System.in);



        do{
            

                   
                         System.out.print("Enter UserName: ");
                         userName=in1.nextLine();
                         System.out.print("Enter Password: ");
                         passWord=in1.nextLine();
                         System.out.print("Enter Employee Name: ");
                         name=in1.nextLine();
                         Employee employee1 =new Employee(userName, passWord, name) ;
                         employee.add(employee1);        
                         System.out.println("Your ID is: "+counter);
                         counter++;

                         
                 int f=0;    
            do{         
                System.out.println("Plese select from one of the coice provided:\n "
                    + "1.Continue Entering \n "
                    + "2.Done entering \n"
                    + "--------------------------------");
             System.out.print("Enter choce here:");
                     choice=in.nextLine();
                         switch (choice) {
                                 case "1":
                                     f++;
                                     x=0;
                                     break;
                                 case "2":
                                     f++;
                                     x++;
                                     break;
                                 default:
                                     System.out.println("Wrong Choice plese try again");
                                     break;
                             }
            }while(f==0);
        }while(x==0);
        

    }
public static void editemployee()
{
    String choice;
    int x=0;
    int y=0;
    String passWordold;
    String passWordnew;
    String name;
    
    
    Scanner in = new Scanner(System.in);
    Scanner in3 = new Scanner(System.in);

    Scanner in1 = new Scanner(System.in);
    Scanner in2 = new Scanner(System.in);
    int z=0;
    String EmployeeID;
do{
    do{
    System.out.println("Pleas Enter EmployeeID:");
                         EmployeeID=in.nextLine(); 
                         
                          switch (EmployeeID) {
                                 case "1":
                                     z++;
                                    
                                     break;
                                 case "2":
                                     z++;
                                     
                                     break;
                                 default:
                                     System.out.println("Wrong Choice plese try again");
                                     break;
                             }
    }while(z==0);  
    
    System.out.print("Enter Employee Name: ");
                         name=in3.nextLine();
                         employee.get(Integer.parseInt(EmployeeID)).setEmployeeName(name);
          do{               
                     System.out.print("Enter old  Password: ");
                     passWordold=in1.nextLine();
                     System.out.print("Enter new  Password: ");
                     passWordnew=in2.nextLine();
                    y=employee.get(Integer.parseInt(EmployeeID)).setPassword(passWordold, passWordnew);
                     if (y==0)
                     {
                         System.out.println("Wrong PassWord please try Again");
                     }
                        
                        
                       
          }while(y==0);    
           int f=0; 
          do{
             System.out.println("Plese select from one of the coice provided:\n "
                    + "1.Continue Editing \n "
                    + "2.Done Editing \n"
                    + "--------------------------------");
             System.out.print("Enter choce here:");
                     choice=in.nextLine();
        switch (choice) {
            case "1":
                f++;
                x=0;
                break;
            case "2":
                f++;
                x=1;
                break;
            default:
                System.out.println("Wrong PassWord please try Again");
                break;
        }
                        }while(f==0);

   }while(x==0);         
                         
}
       

   public static void newguest()
{       
 int x=1;
    int y=1;
String choice ;
String userName;
String passWord;
String name;
String valued;
int  counter=guest.size();

Scanner in = new Scanner(System.in);
Scanner in1= new Scanner(System.in);
Scanner in2= new Scanner(System.in);
Scanner in3= new Scanner(System.in);




        do{
            do{
              System.out.println("Is guest a Value guest: \n"
                      + "1.Yes \n"
                      + "2.No");
              valued=in3.nextLine();
              switch (valued) {
            case "1":
                y++;
                
                break;
            case "2":
                y++;
                
                break;
            default:
                System.out.println("Wrong PassWord please try Again");
                break;}
            } while(y==1);
                    if(valued.equals("1"))
                    {
                         System.out.print("Enter UserName: ");
                         userName=in1.nextLine();
                         System.out.print("Enter  Password: ");
                         passWord=in1.nextLine();
                         System.out.print("Enter Employee Name: ");
                         name=in1.nextLine();
                         Guest guestNew =new Guest(userName, passWord, name) ;
                         guest.add(guestNew);        
                         System.out.println("Your ID is: "+counter);
                         counter++;
                    
                         
                 int f=0;    
            do{         
                System.out.println("Plese select from one of the coice provided:\n "
                    + "1.Continue Entering \n "
                    + "2.Done entering \n"
                    + "--------------------------------");
             System.out.print("Enter choce here:");
                     choice=in.nextLine();
                         switch (choice) {
                                 case "1":
                                     f++;
                                     x=0;
                                     break;
                                 case "2":
                                     f++;
                                     x++;
                                     break;
                                 default:
                                     System.out.println("Wrong Choice plese try again");
                                     break;
                             }
            }while(f==0);
                    }
                   else if (valued.equals("2"))
                   {
                         System.out.print("Enter  UserName: ");
                         userName=in1.nextLine();
                         System.out.print("Enter  Password: ");
                         passWord=in1.nextLine();
                         System.out.print("Enter Employee Name: ");
                         name=in1.nextLine();
                         Guest guestNew =new Guest(userName, passWord, name) ;
                         guest.add(guestNew);        
                         System.out.println("Your ID is: "+counter);
                         counter++;
                   }
                         
                 int f=0;    
            do{         
                System.out.println("Plese select from one of the coice provided:\n "
                    + "1.Continue Entering \n "
                    + "2.Done entering \n"
                    + "--------------------------------");
             System.out.print("Enter choce here:");
                     choice=in.nextLine();
                         switch (choice) {
                                 case "1":
                                     f++;
                                     x=0;
                                     break;
                                 case "2":
                                     f++;
                                     x++;
                                     break;
                                 default:
                                     System.out.println("Wrong Choice plese try again");
                                     break;
                             }
            }while(f==0);
                   
        }while(x==0);
        
     
//        System.out.println(Iven.getUsername());

}
public static void editguest()
{
    String choice;
    int x=0;
    int y=0;
    String passWordold;
    String passWordnew;
    String name;
   
    Scanner in = new Scanner(System.in);
    Scanner in3 = new Scanner(System.in);

    Scanner in1 = new Scanner(System.in);
    Scanner in2 = new Scanner(System.in);

    int guestID;
do{
    System.out.println("Pleas Enter GuestID:");
                         guestID=in.nextInt(); 
                         System.out.print("Enter Guest Name: ");
                         name=in3.nextLine();
                         guest.get(guestID).setGuestName(name);
                        
          do{               
                     System.out.print("Enter old  Password: ");
                     passWordold=in1.nextLine();
                     System.out.print("Enter new  Password: ");
                     passWordnew=in2.nextLine();
                     y=guest.get(guestID).setPassword(passWordold, passWordnew);
                     if (y==0)
                     {
                         System.out.println("Wrong PassWord please try Again");
                     }
                        
                        
                       
          }while(y==0);    
           int f=0; 
          do{
             System.out.println("Plese select from one of the coice provided:\n "
                    + "1.Continue Editing \n "
                    + "2.Done Editing \n"
                    + "--------------------------------");
             System.out.print("Enter choce here:");
                     choice=in.nextLine();
        switch (choice) {
            case "1":
                f++;
                x=0;
                break;
            case "2":
                f++;
                x=1;
                break;
            default:
                System.out.println("Wrong PassWord please try Again");
                break;
        }
                        }while(f==0);

   }while(x==0);         
}
                        
}

   

