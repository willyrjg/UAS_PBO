/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Customer;
import Model.Partner;
import Model.Staff;
import Model.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaacademicapp.JavaUserManagement;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author LEGION 5
 */
public class UserDAO {

    public static ArrayList<User> getAllUsers() {
        ArrayList<User> userList = new ArrayList<User>();

        Statement statement;
        try {
            statement = DBConnector.conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from USER");

            while (resultSet.next()) {
                User newUser = new User(resultSet.getString("username"), resultSet.getString("encrypted_password"), resultSet.getString("noTelp"));

                userList.add(newUser);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return userList;
    }

    public static void addUser(User newUser) {
        String encryptedPassword = "";
        MessageDigest md;
        try {

            md = MessageDigest.getInstance("MD5");
            md.update(newUser.getEncryptedPassword().getBytes());
            byte[] digest = md.digest();
            encryptedPassword = DatatypeConverter.printHexBinary(digest).toUpperCase();

        } catch (NoSuchAlgorithmException ex) {

            Logger.getLogger(JavaUserManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement ps;
        try {

            String sql = "insert into USER (username, encrypted_password,noTelp,role) values (?, ?, ?, ?)";
            ps = DBConnector.conn.prepareStatement(sql);
            ps.setString(1, newUser.getUsername());
            ps.setString(2, encryptedPassword);
            ps.setString(3, newUser.getNoTelp());
            ps.setString(4, "user");

            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void addStaff(Staff newStaff) {
        String encryptedPassword = "";
        MessageDigest md;
        try {

            md = MessageDigest.getInstance("MD5");
            md.update(newStaff.getEncryptedPassword().getBytes());
            byte[] digest = md.digest();
            encryptedPassword = DatatypeConverter.printHexBinary(digest).toUpperCase();

        } catch (NoSuchAlgorithmException ex) {

            Logger.getLogger(JavaUserManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement ps;
        try {

            String sql = "insert into USER (username, encrypted_password, noTelp, name, divisi, role) values (?, ?, ?, ?, ?, ?)";
            ps = DBConnector.conn.prepareStatement(sql);
            ps.setString(1, newStaff.getUsername());
            ps.setString(2, encryptedPassword);
            ps.setString(3, newStaff.getNoTelp());
            ps.setString(4, newStaff.getName());
            ps.setInt(5, Integer.parseInt(newStaff.getDivisi()));
            ps.setString(6, "staff");

            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void addCustomer(Customer newCustomer) {
        String encryptedPassword = "";
        MessageDigest md;
        try {

            md = MessageDigest.getInstance("MD5");
            md.update(newCustomer.getEncryptedPassword().getBytes());
            byte[] digest = md.digest();
            encryptedPassword = DatatypeConverter.printHexBinary(digest).toUpperCase();

        } catch (NoSuchAlgorithmException ex) {

            Logger.getLogger(JavaUserManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement ps;
        try {

            String sql = "insert into USER (username, encrypted_password, noTelp, name, purchaseDate, role) values (?, ?, ?, ?, ?, ?)";
            ps = DBConnector.conn.prepareStatement(sql);
            ps.setString(1, newCustomer.getUsername());
            ps.setString(2, encryptedPassword);
            ps.setString(3, newCustomer.getNoTelp());
            ps.setString(4, newCustomer.getName());
            ps.setString(5, newCustomer.getDate());
            ps.setString(6, "customer");

            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static void addPartner(Partner newPartner) {
        String encryptedPassword = "";
        MessageDigest md;
        try {

            md = MessageDigest.getInstance("MD5");
            md.update(newPartner.getEncryptedPassword().getBytes());
            byte[] digest = md.digest();
            encryptedPassword = DatatypeConverter.printHexBinary(digest).toUpperCase();

        } catch (NoSuchAlgorithmException ex) {

            Logger.getLogger(JavaUserManagement.class.getName()).log(Level.SEVERE, null, ex);
        }
        PreparedStatement ps;
        try {

            String sql = "insert into USER (username, encrypted_password, noTelp, name, companyName, address, role) values (?, ?, ?, ?, ?, ?, ?)";
            ps = DBConnector.conn.prepareStatement(sql);
            ps.setString(1, newPartner.getUsername());
            ps.setString(2, encryptedPassword);
            ps.setString(3, newPartner.getNoTelp());
            ps.setString(4, newPartner.getName());
            ps.setString(5, newPartner.getCompanyName());
            ps.setString(6, newPartner.getAdress());
            ps.setString(7, "partner");

            ps.execute();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static int getUserLength() throws SQLException {
        String sql = "SELECT COUNT(*) FROM user";
        Statement st;
        ResultSet rs;
        st = DBConnector.conn.createStatement();
        rs = st.executeQuery(sql);
        int count = 0;
        while (rs.next()) {
            count++;
        }
        return count;

    }

    public static ArrayList searchUser(String kiwor, boolean staff, boolean customer, boolean partner) {

        Statement statement;
        try {
            statement = DBConnector.conn.createStatement();
            if (staff) {
                ArrayList<Staff> userList = new ArrayList<Staff>();
                ResultSet resultSet = statement.executeQuery("SELECT * from user where role='staff' and username like '%" + kiwor + "%'");

                while (resultSet.next()) {
                    Staff newUser = new Staff(resultSet.getString("username"), resultSet.getString("noTelp"), resultSet.getString("encrypted_password"), resultSet.getString("name"), resultSet.getString("divisi"));

                    userList.add(newUser);
                }
                return userList;

            }
            if (customer) {
                ArrayList<Customer> userList = new ArrayList<Customer>();

                ResultSet resultSet = statement.executeQuery("SELECT * from user where role='customer' and username like '%" + kiwor + "%'");

                while (resultSet.next()) {
                    Customer newUser = new Customer(resultSet.getString("username"), resultSet.getString("noTelp"), resultSet.getString("encrypted_password"), resultSet.getString("name"), resultSet.getString("purchaseDate"));

                    userList.add(newUser);
                }
                return userList;

            }
            if (partner) {
                ArrayList<User> userList = new ArrayList<User>();

                ResultSet resultSet = statement.executeQuery("SELECT * from user where role='partner' and username like '%" + kiwor + "%'");

                while (resultSet.next()) {
                    Partner newUser = new Partner(resultSet.getString("username"), resultSet.getString("encrypted_password"), resultSet.getString("noTelp"), resultSet.getString("name"), resultSet.getString("companyName"), resultSet.getString("address"));

                    userList.add(newUser);
                }
                return userList;
            } else {
                ArrayList<User> userList = new ArrayList<User>();

                ResultSet resultSet = statement.executeQuery("SELECT * from user where  username like '%" + kiwor + "%'");

                while (resultSet.next()) {
                    User newUser = new User(resultSet.getString("username"), resultSet.getString("encrypted_password"), resultSet.getString("noTelp"));

                    userList.add(newUser);
                }
                return userList;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

}
