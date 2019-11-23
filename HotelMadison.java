package CIS_Group_Project;


import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class HotelMadison
{
    public static ArrayList<Employee> employee = new ArrayList();
    public static ArrayList<Guest> guest = new ArrayList();
    public static ArrayList<Room> room = new ArrayList<Room>();
    public static ArrayList<Booking> booking = new ArrayList();
    
    
    public static void main(String[] args) 
    {

        Employee e1 = new Employee ("admin" , "1234", "Austin Putnam");
        employee.add(e1);
        
        Employee e2 = new Employee ("bcarson","12345a","Ben Carson");
        employee.add(e2);
        
        Guest g1 = new Guest("guest", "pass", "Tim Robbins");
        guest.add(g1);
        
        Guest g2 = new Guest("mthorton" , "alphaprotocol", "Mike Thorton");
        guest.add(g2);
        
        Room r1 = new Room(1, 1, 1, 1, 1);
        room.add(r1);
        
        Room r2 = new Room(1, 1, 1 ,1 , 2);
        room.add(r2);
        
        Scanner keyboardInput = new Scanner(System.in);
        
        System.out.println("Enter 1 to login as a Guest");
        System.out.println("Enter 2 to login as an Employee\n");
        
        System.out.print("Please enter your choice: ");
        
        int choice = keyboardInput.nextInt();
        
        switch(choice)
        {
            
            case 1:
                Guest theGuest = checkGuest();
                guestMenu(theGuest);
                break;
                     
            case 2:               
                checkEmployee();
                break;
        }
        
    }
    
    public static Guest checkGuest()
    {
        Guest theGuest = null;
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
                    theGuest = guest.get(i);
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
        
        return theGuest; 
                
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
                bookingReport();
                break;
            case 2:
                checkoutGuest();
                break;
            case 3:
                newguest();
                break;
            case 4:
                editguest();
                break;
            case 5:
                 newemployee();
                break;
            case 6:
                editemployee();
                break;
            case 7:
                room = makeRooms(room);
                break;
            case 8:
                editRooms(room);
                break;
            case 9:
                System.out.print("Exiting Program...");
                break;
            default:
                System.out.print("Invalid option, Please enter an option between 1-9\n");
        }
        } while (menuChoice != 9);
    }
    
    public static void guestMenu(Guest theGuest)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Be our guest!");
        String menuChoice = ""; 
        boolean menuChoiceCheck = true; 
        
        do {
            System.out.println("\n*** Guest Main Menu ***"
                + "\n-------------------------");
            System.out.println("1. Book a Room");
            System.out.println("2. See Booking Report");
            System.out.println("3. Edit Personal Information");
            System.out.println("4. Exit Program");
            System.out.print("Enter Choice: ");
            menuChoice = input.next();
            
            do {
                if (menuChoice.equals("1") || menuChoice.equals("2")
                        || menuChoice.equals("3") || menuChoice.equals("4")){
                    menuChoiceCheck = false;
                } else {
                    System.out.print("Invalid input. Please enter 1, 2, 3 or 4: ");
                    menuChoice = input.next();
                }
            } while (menuChoiceCheck);
            
            handleGuestChoice(menuChoice, theGuest);
            
        } while (!menuChoice.equals("4"));
        System.out.println("\nProgram Exiting. . . ");
        
    }
    
    public static void handleGuestChoice(String menuChoice, Guest guest){
        switch (menuChoice) {
            case "1": bookARoom(guest); break;
            case "2": guestReport(guest); break;
            case "3": editGuestInfo(guest); break;
            case "4": break;
            default: System.out.println("\nInvalid Menu Choice. Try again!");
        }
    }
    
    public static void bookARoom(Guest guest){
        
        Scanner input = new Scanner(System.in);
        String bedOption = ""; 
        String kitchenOption = "";
        String coffeeOption = "";
        String accessibleOption = "";

        System.out.println("\n*** Guest Book a Room ***"
                + "\n-------------------------");
        boolean bedOptionCheck = false; 
        do {
            System.out.println("Select a Bed Option:");
            System.out.println("1. 1 Queen Bed");
            System.out.println("2. 2 Queen Beds");
            System.out.println("3. 1 King Bed");
            System.out.print("Enter Choice: ");
            bedOption = input.next();
            
            if (bedOption.equals("1")){
                bedOptionCheck = true;
            } else if(bedOption.equals("2")) {
                bedOptionCheck = true;
            } else if(bedOption.equals("3")) {
                bedOptionCheck = true;
            } else {
                System.out.println("\nInvalid input. Please enter 1, 2, or 3.");
            }
        } while (!bedOptionCheck);
        
        boolean kitchenOptionCheck = false; 
        do {
            System.out.println("\nSelect a Kitchen Option:");
            System.out.println("1. Microwave");
            System.out.println("2. Fridge + Microwave");
            System.out.print("Enter Choice: ");
            kitchenOption = input.next();
            
            if (kitchenOption.equals("1")){
                kitchenOptionCheck = true;
            } else if(kitchenOption.equals("2")) {
                kitchenOptionCheck = true;
            } else {
                System.out.println("\nInvalid input. Please enter 1 or 2.");
            }
        } while (!kitchenOptionCheck);
        
        boolean coffeeOptionCheck = false;
        do {
            System.out.println("\nSelect a Coffee Option:");
            System.out.println("1. 1-Cup Std. Coffee Machine");
            System.out.println("2. Keurig Hot K200 Machine");
            System.out.print("Enter Choice: ");
            coffeeOption = input.next();
            
            if (coffeeOption.equals("1")){
                coffeeOptionCheck = true;
            } else if(coffeeOption.equals("2")) {
                coffeeOptionCheck = true;
            } else {
                System.out.println("\nInvalid input. Please enter 1 or 2.");
            }
        } while (!coffeeOptionCheck);
        
        boolean accessibleOptionCheck = false; 
        do {
            System.out.println("\nSelect a Accessibility Option:");
            System.out.println("1. Standard Room");
            System.out.println("2. Enhanced Accessibility Room");
            System.out.print("Enter Choice: ");
            accessibleOption = input.next();
            
            if (accessibleOption.equals("1")){
                accessibleOptionCheck = true;
            } else if(accessibleOption.equals("2")) {
                accessibleOptionCheck = true;
            } else {
                System.out.println("\nInvalid input. Please enter 1 or 2.");
            }
        } while (!accessibleOptionCheck);
        
        
        
        int count = 0; 
        String roomChoice = "";
        
        
        ArrayList<Room> preferredRooms = new ArrayList();
        ArrayList<Room> availableRooms = new ArrayList();
        
        for(int i = 0; i < room.size(); i++) {
            if (Integer.parseInt(bedOption) == room.get(i).getBedOption()
                    && Integer.parseInt(kitchenOption) == room.get(i).getKitchenOption()
                    && Integer.parseInt(coffeeOption) == room.get(i).getCoffeeOption()
                    && Integer.parseInt(accessibleOption) == room.get(i).getAccessibleOption()
                    && !(room.get(i).bookedRoom())){
                if(count == 0){
                    System.out.println("\n(The following rooms are available that meet your preferences)");
                }
                preferredRooms.add(room.get(i));
                count++;
                System.out.println(count + ". Room " + room.get(i).getRoomNumber());
            }
        }
        
        if (count > 0){
            System.out.print("\nEnter the value next to the room you'd like to book: ");
            roomChoice = input.next();
            
            
            Room chosenRoom = preferredRooms.get(Integer.parseInt(roomChoice) - 1);
            
            boolean check = false;
            System.out.println("You have chosen Room #" + chosenRoom.getRoomNumber() + ". "
                    + chosenRoom.roomDescription());
            System.out.print("\nIs this the room you'd like to book? "
                    + "(Yes (y) or No (n)): ");
            String bookRoom = "";
            
            do {
                bookRoom = input.next();
                if (bookRoom.equals("y")){
                    for(int i = 0; i < room.size(); i++){
                        if (chosenRoom.getRoomID() == room.get(i).getRoomID()){
                            room.get(i).bookRoom();
                        }
                    }
                    chosenRoom.bookRoom();
                    Booking newBooking = new Booking(guest, chosenRoom, 2019, 1, 1);
                    booking.add(newBooking);
                    System.out.println("Thank you for booking Room #" + newBooking.getBookedRoom().getRoomNumber());
                    check = true;
                    
                } else if(bookRoom.equals("n")){ 
                    System.out.println("Please go back to the main menu and try with new preferences.");
                    break;
                } else {
                    System.out.println("Invalid input. Please enter Yes (y) or No (n): ");
                }
            } while (!check);
            
  
        } else {
            System.out.println("\nThe following rooms are currently available:");
            System.out.println("(There are no rooms available with all of your preferences.)\n");
            
            count = 0;
            for (int i = 0; i < room.size(); i++) {
                if(!room.get(i).bookedRoom()){
                    availableRooms.add(room.get(i));
                    count++;
                    System.out.println(count + ". " + room.get(i).roomDescription());
                }
            }
            System.out.print("\nEnter the value next to the room you'd like to book: ");
            roomChoice = input.next();
            System.out.println("You have chosen " + availableRooms.get(Integer.parseInt(roomChoice) - 1).roomDescription());
            System.out.print("\nIs this the room you'd like to book? "
                + "(Yes (y) or No (n): ");
            
            Room chosenRoom = availableRooms.get(Integer.parseInt(roomChoice) - 1);
            boolean check = false;
            String bookRoom = "";
            do {
                bookRoom = input.next();
                if (bookRoom.equals("y")){
                    for(int i = 0; i < room.size(); i++){
                        if (chosenRoom.getRoomID() == room.get(i).getRoomID()){
                            room.get(i).bookRoom();
                        }
                    }
                    chosenRoom.bookRoom();
                    Booking newBooking = new Booking(guest, chosenRoom, 2019, 1, 1);
                    booking.add(newBooking);
                    System.out.println("Thank you for booking Room #" + newBooking.getBookedRoom().getRoomNumber());
                    check = true;
                } else if(bookRoom.equals("n")){ 
                    System.out.println("Please go back to the main menu and try with new preferences.");
                    break;
                } else {
                    System.out.println("Invalid input. Please enter Yes (y) or No (n): ");
                }
            } while (!check);
            
        }
               
        
    }
    
    public static void guestReport(Guest guest){
        int count = 0; 
        System.out.println("\n*** Guest Report ***"
                + "\n-------------------------");
        Guest temp = null; 
        for (int i = 0; i < booking.size(); i++){
            if (booking.get(i).getBookingGuest().getGuestName().equals(guest.getGuestName())){
                count++;
                System.out.println(count + ". "+ booking.get(i).toString());
            } 
        }
        
        if (count == 0){
            System.out.println("You have not booked a room yet.");
        }
    }
    
    public static void editGuestInfo(Guest guest){
        Scanner input = new Scanner(System.in);
        System.out.println("\n*** Edit Guest Info ***"
                + "\n-------------------------");
        System.out.print("You cannot edit your username or password. "
                + "\nWould you like to edit the name on your account? "
                + "(Yes (y) or No (n)): ");
        boolean correctResponse = false;
        String editNameInput = "";
        String newName = "";
        
        do {
            editNameInput = input.nextLine().toLowerCase();
            if(editNameInput.equals("y")){
                System.out.print("\nEnter your new name: ");
                newName = input.nextLine();
                guest.setGuestName(newName);
                correctResponse = true;
            } else if (editNameInput.equals("n")){
                correctResponse = true;
                break; 
            } else {
                System.out.println("Please enter \"y\" for Yes or \"n\" for No. ");
            }
        } while (!correctResponse);
    }
    
    public static void checkoutGuest()
    {
         int f=0;    
        Scanner keyboardInput = new Scanner(System.in);
        do{
        System.out.print("Please enter room number: ");
        String rooms = keyboardInput.nextLine();
        room.get(Integer.parseInt(rooms)).freeThisRoom();
        System.out.println("Room #" + rooms);
       
                     
                System.out.println("Plese select from one of the choice provided:\n "
                    + "1.Continue Entering \n "
                    + "2.Done entering \n"
                    + "--------------------------------");
             System.out.print("Enter choice here:");
                     String choice=keyboardInput.nextLine();
                         switch (choice) {
                                 case "1":
                                     break;
                                 case "2":
                                     f++;
                                     break;
                                 default:
                                     System.out.println("Wrong Choice plese try again");
                                     break;
                             }
            }while(f==0);
    }
    
    public static void bookingReport()
    {
          {       
         int x=1;
            int y=1;
            int f=0;   
        String choice ;
        String valued;

        Scanner in1= new Scanner(System.in);
        Scanner in = new Scanner(System.in);
        Scanner in3= new Scanner(System.in);

        do{
            do{
              System.out.println("1. Display All Rooms: ");
              System.out.println("2. Select one Room to display: ");
              valued=in3.nextLine();
              switch (valued) {
            case "1":
                y++;
                
                break;
            case "2":
                y++;
                
                break;
            default:
                System.out.println("Wrong Option! Please try Again! ");
                break;}
            } while(y==1);
                    if(valued.equals("1"))
                    {
                        for (int i = 0; i < room.size(); i ++){
                System.out.println(room.get(i).roomDescription() + ", Room Price $:" + room.get(i).roomAnalytics()); 
            }

                    }
                   else if (valued.equals("2"))
                   {
                    System.out.println("Please enter a room # to select");
                    int roomChoice = in1.nextInt();
                    for (int i = 0; i < room.size(); i++){
                    if (room.get(i).getRoomNumber() == (roomChoice))
                    {
                    System.out.print(room.get(i).roomDescription());
                    }
                }
            }
                         
                  f=0;    
            do{         
                System.out.println("Plese select from one of the choices provided:\n "
                    + "1.Continue Selecting Rooms to display \n "
                    + "2.Exit Report Menu \n"
                    + "--------------------------------");
             System.out.print("Enter choice here:");
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
                                     System.out.println("Wrong Choice! Plese try again! ");
                                     break;
                             }
            }while(f==0);
                   
        }while(x==0);
        }
    }
    
    public static void handleReportMenu(int menuChoice)
    {
        Scanner in = new Scanner(System.in);
        switch (menuChoice) {
        case 1:
            for (int i = 0; i < room.size(); i ++){
                System.out.println(room.get(i).roomDescription() + ", Room Price $:" + room.get(i).roomAnalytics()); 
            }
            break;
        case 2:
            System.out.println("Please enter a room #");
            int roomChoice = in.nextInt();
            for (int i = 0; i < room.size(); i++){
            if (room.get(i).getRoomNumber() == (roomChoice))
            {
                System.out.print(room.get(i).roomDescription());
            }
                //+ ", Room Price $: " + rooms.get(roomChoice).getRoomPrice());           
            }
            break;
        case 3:
            System.out.print("Leaving Room Report Menu...");
            break;
        default:
            System.out.print("Not a valid choice");
        }
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
            int f=0;   
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
                         System.out.print("Enter Password: ");
                         passWord=in1.nextLine();
                         System.out.print("Enter Guest Name: ");
                         name=in1.nextLine();
                         Guest guestNew =new Guest(userName, passWord, name) ;
                         guest.add(guestNew);        
                         System.out.println("Your ID is: "+counter);
                         counter++;
                    
                         

                    }
                   else if (valued.equals("2"))
                   {
                         System.out.print("Enter UserName: ");
                         userName=in1.nextLine();
                         System.out.print("Enter Password: ");
                         passWord=in1.nextLine();
                         System.out.print("Enter Guest Name: ");
                         name=in1.nextLine();
                         Guest guestNew =new Guest(userName, passWord, name) ;
                         guest.add(guestNew);        
                         System.out.println("Your ID is: "+counter);
                         counter++;
                   }
                         
                  f=0;    
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
            Scanner in4 = new Scanner(System.in);


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
                             choice=in4.nextLine();
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
                        System.out.println("Wrong number please try Again");
                        break;
                }
                                }while(f==0);

           }while(x==0);         
        }
        public static ArrayList makeRooms(ArrayList roomList)
        {
               
        Scanner keyboardIn = new Scanner(System.in);
        Scanner keyboardIn1 = new Scanner(System.in);

 
        int x = 0;
        String bedOption;
        do {
                   int y = 0;

        do {
            
        
        System.out.println("Please select bed option: " + "\n"
        + "1. 1 Queen bed" + "\n"
        + "2. 2 Queen beds" + "\n"
        + "3. 1 King bed" + "\n");
        bedOption = keyboardIn1.nextLine();    
        
       
      
       if (bedOption.equals("1"))
       {  y++;}
                
       else if(bedOption.equals("2"))
       {  y++;}
              
       else if (bedOption.equals("3"))
       {  y++;}     
        else
       { System.out.println("\n"+"Invalid choice. Please enter one of the choices selected. ");}
        
        }while(y==0);
                
                
        
       String kitchenOption;
         y = 0;
       do {
            
        
        System.out.println("\n"+"Please select kitchen option: " + "\n"
        + "1. Microwave" + "\n"
        + "2. Fridge + Microwave" + "\n");
      
        kitchenOption = keyboardIn1.nextLine();    
        
       
      
       if (kitchenOption.equals("1"))
       {  y++;}
                
       else if(kitchenOption.equals("2"))
       {  y++;} 
       else
       { System.out.println("\n"+"Invalid choice. Please enter one of the choices . ");}
        
        }while(y==0);
        
        y = 0;
        
     y = 0;

     String coffeeOption;
     do {
            
        
        System.out.println("\n"+"Please select coffee option: " + "\n"
        + "1. 1-Cup Std. Coffee Machine" + "\n"
        + "2. Keurig Hot K200 Machine" + "\n");
      
        coffeeOption = keyboardIn1.nextLine();    
        
       
      
       if (coffeeOption.equals("1"))
       {  y++;}
                
       else if(coffeeOption.equals("2"))
       {  y++;} 
       else
       { System.out.println("\n"+"Invalid choice. Please enter one of the choices selected. ");}
        
        }while(y==0);
		
		y = 0;
        
       
       String accessibilityOption; 
       y = 0;
do {
            
        
        System.out.println("\n"+"Please select accessibility option: " + "\n"
        + "1. Standard Room" + "\n"
        + "2. Enhanced Accessibility Room" + "\n");
      
        accessibilityOption = keyboardIn1.nextLine();    
        
       
      
       if (accessibilityOption.equals("1"))
       {  y++;}
                
       else if(accessibilityOption.equals("2"))
       {  y++;} 
       else
       { System.out.println("\n"+"Invalid choice. Please enter one of the choices selected. ");}
        
        }while(y==0);
		
		y = 0;
        
        
        // This room number will actually be pulled from array 
        // Room will need to be added to the arrayList of rooms
        // Room number will be ArrayList[i]
    int counter = roomList.size() ;
        
        

        
        Room newRoom = new Room(Integer.parseInt(bedOption), Integer.parseInt(kitchenOption), Integer.parseInt(coffeeOption), 
                Integer.parseInt(accessibilityOption), (counter) );
        
        roomList.add(newRoom);
        
        System.out.println("\n" + "Room number of new room: " + counter + "\n");
       
        System.out.println("\n" + "Would you like to create another room? " + "\n"
        + "1. Yes" + "\n"
        + "2. No" + "\n");
        x = keyboardIn.nextInt();
        
            System.out.println();
            
        }while (x == 1);
        return roomList;    
        }
        public static ArrayList editRooms(ArrayList room)
        {
                 Scanner keyboardIn = new Scanner(System.in);
        Scanner keyboardIn1 = new Scanner(System.in); 
        Scanner keyboardIn2 = new Scanner(System.in);
       
        
        String x = "0";
        do {
        
        System.out.println("Please enter room number to edit: ");
        String roomNumberToEdit = keyboardIn.nextLine();
        
        Room roomToEdit = (Room) room.get(Integer.parseInt(roomNumberToEdit));
        
        System.out.println(roomToEdit.roomDescription());
        
        System.out.println("Please select room property to edit: " + "\n"
        + "\n" +"1. Bedding" + "\n"
        + "2. Kitchen" + "\n"
        + "3. Coffee machine" + "\n"
        + "4. Accessibility" + "\n"
        + "5. Make room Active/Inactive"); 
        
    
        String editSelection = keyboardIn.nextLine();
       int y;
        do{
        y = 0;
            switch (editSelection){
            case "1":
                System.out.println("\n"+"Please select new bedding option for this room: " + "\n"
                + "1. 1 Queen Bed" + "\n"
                + "2. 2 Queen Beds" + "\n"
                + "3. 1 King Bed" + "\n");
                roomToEdit.bedOption = keyboardIn1.nextInt();
                y++;
                break;
            case "2":
                System.out.println("\n"+"Please select new kitchen option for this room: " + "\n"
                + "1. Microwave" + "\n"
                + "2. Fridge + Microwave" + "\n");
                roomToEdit.kitchenOption = keyboardIn1.nextInt();
                y++;
                break;
            case "3":
                System.out.println("\n"+"Please select new coffee option for this room: " + "\n"
                + "1. 1-Cup Std. Coffee Machine" + "\n"
                + "2. Keurig Hot K200 Machine" + "\n");
                roomToEdit.kitchenOption = keyboardIn1.nextInt();
                y++;
                break;
            case "4":
                System.out.println("\n"+"Please select new accessibility option for this room: " + "\n"
                + "1. Standard Room" + "\n"
                + "2. Enhanced Accessibility Room" + "\n");
                roomToEdit.accessibleOption = keyboardIn1.nextInt();
                y++;
                break;
            case "5":
                System.out.println("\n" + "Please select activation option for this room: " + "\n"
                + "1. Make room active" + "\n"
                + "2. Make room inactive" + "\n");
                String activationChange = keyboardIn2.next();
                switch (activationChange)
                {
                    case "1":
                        roomToEdit.activeStatus = true;
                        System.out.println("Room is now Active.");
                        y++;
                        break;
                    case "2":
                        roomToEdit.activeStatus = false;
                        System.out.println("Room is now Inactive");
                        y++;
                        break;
                    default:
                        System.out.println("\n"+"Invalid choice. Please select one of the choices provided " + "\n");
                }
                break;
            default: 
                System.out.println("\n"+"Invalid choice. Please enter one of the choices provided. " + "\n");
                y = 1;
                break;
                
        }
        }while(y==0);
                
          System.out.println("\n" + "Would you like to edit another room? " + "\n"
          + "1. Yes" + "\n"
          + "2. No" + "\n");
          x = keyboardIn.nextLine();
          
        } while (x.equals("1"));
          return room;   
        }
                        
}