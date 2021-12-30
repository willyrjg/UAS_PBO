/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import DAO.UserDAO;
import java.util.ArrayList;

/**
 *
 * @author LEGION 5
 */
public class User {

    /**
     * @return the encryptedPassword
     */
    public String getEncryptedPassword() {
        return encryptedPassword;
    }
    private String username;
    private String encryptedPassword;
    private String noTelp;
    
    public static ArrayList<User> userList = new ArrayList<User>();
    
    public static boolean validateUsername(String username)
    {
        for(int i = 0; i < userList.size(); i++)
        {
            if (username.equalsIgnoreCase(userList.get(i).username))
            {
                return false;
            }
        }
        
        return true;
    }
    
    public User(String username, String encryptedPassword,String noTelp)
    {
        this.username = username;
        this.encryptedPassword = encryptedPassword;
        this.noTelp = noTelp;
        // create new activity log
        
        Activity.activityList.add(new Activity(Activity.USER_CREATED, username));
        
        userList.add(this);
        
        
    }
    public String getNoTelp(){
        return this.noTelp;
    }
    
    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param encryptedPassword the encryptedPassword to set
     */
    public void setEncryptedPassword(String encryptedPassword) {
        
        this.encryptedPassword = encryptedPassword;
    }
    
    public boolean updateUsername(String newUsername)
    {
        if (newUsername.equalsIgnoreCase(username))
        {
            Activity.activityList.add(new Activity(Activity.UPDATE_FAILED_USERNAME_EXIST, username));
            return false;
        }
        
        if (!User.validateUsername(newUsername))
        {
            Activity.activityList.add(new Activity(Activity.UPDATE_FAILED_USERNAME_EXIST, username));
            return false;
        }
        
        Activity.activityList.add(new Activity(Activity.UPDATE_USERNAME, username));
        username = newUsername;
        
        return true;
    }
    
    public boolean logIn(String username, String encryptedPassword)
    {
        User tempUser;
        
        String classType = "";
        
        try {
            Employee temp = (Employee)this;
            classType = "javaacademicapp.Employee";
        }
        catch(ClassCastException e)
        {
            classType = "javaacademicapp.Customer";
        }
        
        System.out.println(classType);
        
        for(int i = 0; i < userList.size(); i++)
        {
            tempUser = userList.get(i);
            if (username.equalsIgnoreCase(tempUser.username))
            {
                if (encryptedPassword.equals(tempUser.getEncryptedPassword()))
                {
                    if (classType.equals("javaacademicapp.Employee"))
                    {
                        Activity.activityList.add(new Activity(Activity.LOGIN_SUCCESS_EMPLOYEE, username));
                    }
                    else
                    {
                        Activity.activityList.add(new Activity(Activity.LOGIN_SUCCESS_CUSTOMER, username));
                    }
                    return true;
                    
                }
                else
                {
                    Activity.activityList.add(new Activity(Activity.LOGIN_FAILED_WRONG_PASSWORD_EMPLOYEE, username));
                    return false;
                }
            }
            
        }
        Activity.activityList.add(new Activity(Activity.LOGIN_FAILED_USER_NOT_FOUND_EMPLOYEE, username));
        return false;
    }
    
}
