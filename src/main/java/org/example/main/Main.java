package org.example.main;

import org.example.model.Employee;
import org.example.repository.EmployeeRepository;
import org.example.repository.Repository;
import org.example.util.DatabaseConnection;
import org.example.view.SwingApp;

import java.sql.Connection;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {

       /* try (Connection myCon = DatabaseConnection.getInstance()) {
            Repository<Employee> repository = new EmployeeRepository();


            System.out.println("<-------------Probando el segundo metodo, getById--------->");
            System.out.println(repository.getById(1));

            System.out.println("<------------Probando el metodo de inserción---------->");
            Employee employee = new Employee();
            employee.setId(11);
            employee.setFirstName("Sergio Ismael");
            employee.setFirstSurname("Ayala");
            employee.setSecondSurname("Hernandez");
            employee.setEmail("SergioAyala9208@gmail.com");
            employee.setSalary(6000000.0F);
            repository.save(employee);

            System.out.println("<------------Probando el metodo de inserción---------->");
            Employee employee2 = new Employee();
            employee2.setFirstName("Linda");
            employee2.setFirstSurname("Sarmiento");
            employee2.setSecondSurname("Camacho");
            employee2.setEmail("Linda@gmail.com");
            employee2.setSalary(6000000.0F);
            repository.save(employee2);

            System.out.println("<----------------Listado todo--------------->");
            repository.findAll().forEach(System.out::println);

            repository.delete(12);

            System.out.println("<----------------Listado todo--------------->");
            repository.findAll().forEach(System.out::println);

        }*/

        SwingApp app = new SwingApp();

        app.setVisible(true);
    }
}