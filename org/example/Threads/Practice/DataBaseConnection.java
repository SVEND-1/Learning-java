package org.example.Threads.Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
    private static DataBaseConnection instance;
    private final UserDB userDB;

    public DataBaseConnection() {
        this.userDB = new UserDB(сonnect());
    }

    public UserDB getUserDB() {
        return userDB;
    }

    public static synchronized DataBaseConnection getInstance() {
        if (instance == null) {
            instance = new DataBaseConnection();
        }
        return instance;
    }

    private Connection сonnect(){
        final String userdb = "postgres";
        final String passworddb = "svend123";
        final String urldb = "jdbc:postgresql://localhost:5432/Thread";

        try{
            Connection connection = DriverManager.getConnection(urldb, userdb, passworddb);
            return connection;
        } catch (SQLException e) {
            System.out.println("Подключение к базе данных не получилось");
        }
        return null;
    }
}
