package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection myCon = null;
        PreparedStatement myStamt = null;
        ResultSet myRes = null;

        try {
            myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
            System.out.println("Conectado");

            String sql = ("insert into empleos(id,nombre,sueldo) values(?,?,?)");

            myStamt = myCon.prepareStatement(sql);
            myStamt.setString(1,"3");
            myStamt.setString(2,"mesero");
            myStamt.setString(3,"1000000");


            int rowsAffected = myStamt.executeUpdate();


            myRes = myStamt.executeQuery("select * from empleos");

            while (myRes.next()){
                System.out.println(myRes.getString("nombre"));
            }

        }catch (Exception e){
            System.out.println(e);
            System.out.println("algo mal");
        }

    }
}