package com.pamokos.db.nuskaitymas;

import com.sun.java.util.jar.pack.*;
import com.sun.org.apache.bcel.internal.generic.SWITCH;

import java.sql.*;
import java.util.Scanner;

/**
 * Created by Max on 2017.03.14.
 */
public class InsertDelete {
    Connection connection;
    Scanner sk = new Scanner(System.in);

    public InsertDelete() {
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/kcs",
                    "root",
                    "");
        } catch (Exception klaida) {
        }
    }

    public void klausimas() {
        System.out.println("Duombazės Insert ir Delete programa ");
        System.out.println("Insert = 1 ");
        System.out.println("Delete = 2 ");

    }

    public void pasirinkimas() {
        int pasirinko = sk.nextInt();
        switch (pasirinko) {
            case 1:
                Insert();
                break;
            case 2:
                Delete();
                break;


        }
    }

    private void Insert() {
        try {
            System.out.println("Pasirinkote Insert = 1 ");
            Statement statement = connection.createStatement();
            String insertTableSQL = "INSERT INTO `students`"
                    + "(`name`, `surname` , `phone` , `email`) VALUES"
                    + "(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);
            System.out.println("Iveskite varda ");
            preparedStatement.setString(1,sk.next());
            System.out.println("Iveskite pavarde ");
            preparedStatement.setString(2,sk.next());
            System.out.println("Iveskite telefono numeri");
            preparedStatement.setString(3,sk.next());
            System.out.println("Iveskite emaila ");
            preparedStatement.setString(4, sk.next());
            preparedStatement.executeUpdate();






        } catch (Exception eror) {

        }

    }

    private void Delete() {
        try {
            System.out.println("Pasirinkote Delete = 2 ");
            System.out.println("Įveskite ID ");
            Statement statement = connection.createStatement();
            String deleteFromTable =  "DELETE FROM `students` WHERE `students`.`id` = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(deleteFromTable);
            preparedStatement.setInt(1,sk.nextInt());
            preparedStatement.execute();


        } catch (Exception eror) {

        }

    }
}

