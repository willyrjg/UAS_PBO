/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Irfan
 */
public class Partner extends User{
    String companyName;
    String address;
    private String name;
    public Partner(String username, String encryptedPassword, String noTelp,String name,String companyName, String address) {
        super(username, encryptedPassword, noTelp);
        this.address = address;
        this.companyName = companyName;
        this.name = name;
    }

    public String getCompanyName(){
        return this.companyName;
    }
    public String getAdress(){
        return this.address;
    }
    public String getName(){
        return this.name;
    }
}
