import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = 0;
        String name, Phone, email, password, license;
        int ID = 0;
        Admin admin = new Admin();
        Database database = new Database();
        System.out.println("to register as driver press 1 \nto register as passenger press 2");
       while (true) {
           n = input.nextInt();
           if (n == 1) {
               System.out.println("Enter your username");
               name = input.next();
               System.out.println("enter your phone number");
               Phone = input.next();
               System.out.println("Enter your email");
               email = input.next();
               System.out.println("Enter your password");
               password = input.next();
               System.out.println("Enter your license");
               license = input.next();
               System.out.println("Enter your national Id");
               ID = input.nextInt();
               Driver driver = new Driver(name, Phone, email, password, license, ID);
               driver.register(database, driver);
               admin.verifyRegisteration(database, name);
               driver.login(database, name, password);
               driver.addAreas("giza");
               Passenger passenger = new Passenger("dd","121","adead","sada");
               passenger.requestRide("giza","cairo",database);
               Trip trip = new Trip(passenger.trip.getSource(),passenger.trip.getDestination());
               driver.getNotification(trip,database);

           } else if (n == 2) {
               System.out.println("Enter your username");
               name = input.next();
               System.out.println("enter your phone number");
               Phone = input.next();
               System.out.println("Enter your email");
               email = input.next();
               System.out.println("Enter your password");
               password = input.next();
               User passenger = new Passenger(name, Phone, email, password);
               passenger.register(database, passenger);
               passenger.login(database, name, password);


           }
           else if (n==3)
           {
               break;

           }
           else {
               System.out.println("enter valid choice");
               System.exit(0);


           }
       }
        }
    }
