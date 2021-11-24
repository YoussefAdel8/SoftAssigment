import java.util.ArrayList;

public class Passenger extends User {
    Database database ;
    Trip trip ;
    String source , destination ;
    public Passenger(String userName,String mobileNumber,String email,String password){
        this.userName= userName;
        this.password= password;
        this.email= password ;
        this.mobileNumber= mobileNumber;
    };

    @Override
    public void register(Database database, User user) {
        database.passengers.add((Passenger) user);
        database.Users.add(user);
    }

    @Override
    public User login(Database database, String userName, String password) {
        for (int i = 0; i < database.passengers.size(); i++) {
            if (database.passengers.get(i).getUserName().equals(userName) && database.passengers.get(i).getPassword().equals(password)) {
              if (database.suspendedUsers.contains(database.passengers.get(i)))
              {
                  System.out.println("user is suspended");
                  return null;
              }
              else {
                  return database.passengers.get(i);
              }
            }

        }
        System.out.println("not match input");
        return null;

    }
    public void requestRide(String source, String destination,Database database)
    {
        this.trip = new Trip(source,destination);
        database.pendingTrips.add(trip);
    }
}

