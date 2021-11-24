
import java.util.ArrayList;

public class Driver extends User {
    Database database ;
    Trip trip ;
    private String driverLicense = "";
    private int nationalId;
    private ArrayList<String> rides;
    private ArrayList<String> favouriteAreas = new ArrayList<String>();
    private ArrayList<Rate> userRating;

    public Passenger getNotification(Trip trip, Database database)
    {
        for (int i = 0; i < database.pendingTrips.size(); i++) {
            if (favouriteAreas.contains(trip.getSource()))
            {
                for (int j = 0; j <database.passengers.size() ; j++) {


                    if (database.passengers.get(j).trip.getSource().equals(trip.getSource())) {
                        System.out.println(database.passengers.get(j).getUserName() +" "+ database.passengers.get(j).trip.getSource() +" "+ database.passengers.get(j).trip.getDestination());
                        return database.passengers.get(j);
                    }
                }

            }

        }

    return null;}

    public void addAreas(String area)
    {
        favouriteAreas.add(area);

    }


    public Driver() {
        userRating = new ArrayList<>();
        favouriteAreas = new ArrayList<>();
        rides = new ArrayList<>();
    }

    public Driver(String userName, String mobileNumber, String email, String password, String driverLicense, int nationalId) {
        this.userName = userName;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.password = password;
        this.driverLicense = driverLicense;
        this.nationalId = nationalId;
    }

    @Override
    public void register(Database database, User user) {
        database.PendingDrivers.add((Driver) user);
    }

    @Override
    public User login(Database database, String userName, String password) {
        for (int i = 0; i < database.drivers.size(); i++) {
            if (database.drivers.get(i).getUserName().equals(userName) && database.drivers.get(i).getPassword().equals(password)) {
                if (database.suspendedUsers.contains(database.drivers.get(i))) {
                    System.out.println("user is suspended");
                    return null;
                } else {
                    System.out.println("welcome " + database.drivers.get(i).getUserName());
                    return database.drivers.get(i);
                }
            }
        }
        System.out.println("not match input");
        return null;
    }

    public void setDriverLicense(String driverLicense) {
        this.driverLicense = driverLicense;
    }

    public void setNationalId(int nationalId) {
        this.nationalId = nationalId;
    }

    public int getNationalId() {
        return nationalId;
    }

    public String getDriverLicense() {
        return driverLicense;
    }

    public double getAverageRating() {
        double total = 0.0;
        for (var rate : userRating) {
            total += rate.value;
        }
        return total / userRating.size();
    }

    public void rate(String username, int rate) {
        userRating.add(new Rate(username, rate));
    }

    public ArrayList<Rate> getAllRates() {
        return userRating;
    }

}

class Rate {
    String username;
    int value;

    Rate(String username, int value) {
        value = Math.min(value, 5);
        value = Math.max(value, 1);
        this.username = username;
        this.value = value;
    }
}