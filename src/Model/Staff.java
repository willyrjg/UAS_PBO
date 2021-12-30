/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Irfan
 */
public class Staff extends User{
    private String name = "hyu";
    private String divisi;
    public Staff(String username,String noTelp, String encryptedPassword, String name, String divisi) {
        super(username, encryptedPassword, noTelp);
        this.name = name;
        this.divisi = divisi;
    }
    
    public String getName(){
        return this.name;
    }
    public String getDivisi(){
        return this.divisi;
    }
    
}
