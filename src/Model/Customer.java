/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.time.ZonedDateTime;

/**
 *
 * @author LEGION 5
 */
public class Customer extends User {
    private String idNumber;
    private String name;
    private String lastpurchase;

    public Customer(String username, String noTelp, String encryptedPassword, String name, String lastpurchase)
    {
        super(username, encryptedPassword, noTelp);
        this.name =name;
        this.lastpurchase = lastpurchase;
    }
    
    /**
     * @return the idNumber
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * @param idNumber the idNumber to set
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
    
    public String getName(){
        return this.name;
    }
    public String getDate(){
        return this.lastpurchase;
    }
    
    
    
    
}
