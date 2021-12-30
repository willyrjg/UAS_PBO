/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LEGION 5
 */
public class DBConnector {
    
    public static Connection conn;
    public static void initiateDB()
    {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/java_user_management", "root", "");
            System.out.println("connection is established");
        } catch (SQLException ex) {
            System.out.println("Connection is not working!");
        }
    }
}
