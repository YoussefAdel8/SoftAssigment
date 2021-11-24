import java.util.ArrayList;

public class Admin {

    Database database ;


    public void verifyRegisteration(Database database,String userName)
        {
            for (int i = 0; i < database.PendingDrivers.size(); i++) {
                if (database.PendingDrivers.get(i).getUserName().equals(userName))
                {
                    database.drivers.add(database.PendingDrivers.get(i));
                    database.Users.add(database.PendingDrivers.get(i));
                    database.PendingDrivers.remove(database.PendingDrivers.get(i));
                    break;
                }

            }
        }
        public void suspendAccount(Database database,String userName)
        {
            for (int i = 0; i < database.Users.size(); i++) {
                if (database.Users.get(i).getUserName().equals(userName))
                {
                    database.suspendedUsers.add(database.Users.get(i));
                    break;
                }


            }

        }




    };

