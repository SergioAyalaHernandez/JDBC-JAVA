package org.example.main;

import org.example.util.DatabaseConnection;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        try (Connection myCon = DatabaseConnection.getInstance();
             Statement myStamt = myCon.createStatement();
             ResultSet myRes = myStamt.executeQuery("select * from Employee");
        ) {
            while (myRes.next()) {
                System.out.println(myRes.getString("firstname"));
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("algo mal");
        }
    }
}