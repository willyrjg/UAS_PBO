/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaacademicapp;

import DAO.DBConnector;
import DAO.UserDAO;
import Model.Activity;
import Model.Customer;
import Model.Partner;
import Model.Staff;
import Model.User;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;
import java.time.ZonedDateTime;

/**
 *
 * @author LEGION 5
 */

/*
Pada kelas main, lakukan aksi-aksi berikut secara berurut.
    1. Buat 5 buat user baru!
    2. Ubah username 2 user yang telah anda buat!
    3. Coba ubah username salah satu user dengan menggunakan username yang sama dengan username yang 
    ada!
    4. Coba ubah username 2 user yang lain dengan menggunakan username yang telah ada!
    5. Cetak seluruh activity yang telah ada!
    6. Cetak seluruh activity yang terjadi pada hari ini. 
    7. Lakukan login 2 kali dengan menggunakan user yang berbeda!
    8. Lakukan failed login 2 kali dengan menggunakan user yang berbeda!
    9. Cetak seluruh activity yang dilakukan oleh 2 user tertentu. 
    10. Cetak 10 activity terakhir.
 */
public class JavaUserManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

//        Inisialisasi Database
        DBConnector.initiateDB();

//        Tambah 5 user ke database
        User user1 = new User("Willy", "Willy123", "08221234567");
        User user2 = new User("Hans", "Hans123", "08227849578");
        User user3 = new User("Aldo", "Aldo123", "08227849453");
        User user4 = new User("Pudge", "Pudge123", "083376278478");
        User user5 = new User("Magnus", "Magnus123", "08227648905");

        UserDAO.addUser(user1);
        UserDAO.addUser(user2);
        UserDAO.addUser(user3);
        UserDAO.addUser(user4);
        UserDAO.addUser(user5);

//         Tambah 5 Staff ke database
        Staff staff1 = new Staff("Willy", "08221234567", "Willy123", "Willy Agusto Rajagukguk", "1");
        Staff staff2 = new Staff("Hans", "08227849578", "Hans123", "Fazral Hans", "2");
        Staff staff3 = new Staff("Aldo", "08227843738", "Aldo123", "Aldo Paulenta Panjaitan", "1");
        Staff staff4 = new Staff("Pudge", "08227849453", "Pudge123", "Pudge the butcher", "3");
        Staff staff5 = new Staff("Magnus", "08227648905", "Magnus123", "Magnus the elephant", "2");

        UserDAO.addStaff(staff1);
        UserDAO.addStaff(staff2);
        UserDAO.addStaff(staff3);
        UserDAO.addStaff(staff4);
        UserDAO.addStaff(staff5);

//        Tambah 5 Customer ke Database
        Customer cus1 = new Customer("Willy", "08221234567", "Willy123", "Willy Agusto Rajagukguk", ZonedDateTime.now().toString());
        Customer cus2 = new Customer("Hans", "08227849578", "Hans123", "Fazral Hans", ZonedDateTime.now().toString());
        Customer cus3 = new Customer("Aldo", "08227843738", "Aldo123", "Aldo Paulenta Panjaitan", ZonedDateTime.now().toString());
        Customer cus4 = new Customer("Pudge", "08227849453", "Pudge123", "Pudge the butcher", ZonedDateTime.now().toString());
        Customer cus5 = new Customer("Magnus", "08227648905", "Magnus123", "Magnus the elephant", ZonedDateTime.now().toString());

        UserDAO.addCustomer(cus1);
        UserDAO.addCustomer(cus2);
        UserDAO.addCustomer(cus3);
        UserDAO.addCustomer(cus4);
        UserDAO.addCustomer(cus5);

//        Tambah 5 Partner
        Partner par1 = new Partner("budi", "budi123", "12366445", "Budiman", "Budi Corp", "Jakarta");
        Partner par2 = new Partner("sudar", "sudar123", "553564635", "Sudarso", "Sudar Corp", "Papua");
        Partner par3 = new Partner("anto", "anto123", "546735353", "Antoman", "Anto Corp", "Bandung");
        Partner par4 = new Partner("joni", "joni123", "545774545", "Jonikun", "Joni Corp", "Medan");
        Partner par5 = new Partner("ironpride", "iron123", "5456453", "Iron Pride", "Trans Corp", "Makassar");

        UserDAO.addPartner(par1);
        UserDAO.addPartner(par2);
        UserDAO.addPartner(par3);
        UserDAO.addPartner(par4);
        UserDAO.addPartner(par5);

        (new UserManagementFrame()).setVisible(true);

    }

}
