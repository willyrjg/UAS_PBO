/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.ZonedDateTime;
import java.util.ArrayList;

/**
 *
 * @author LEGION 5
 */
public class Activity {
    public static final int LOGIN_SUCCESS_EMPLOYEE = 11;
    public static final int LOGIN_FAILED_USER_NOT_FOUND_EMPLOYEE = 12;
    public static final int LOGIN_FAILED_WRONG_PASSWORD_EMPLOYEE = 13;
    
    public static final int LOGIN_SUCCESS_CUSTOMER = 16;
    public static final int LOGIN_FAILED_USER_NOT_FOUND_CUSTOMER = 17;
    public static final int LOGIN_FAILED_WRONG_PASSWORD_CUSTOMER = 18;
    
    public static final int USER_CREATED = 21;
    public static final int USER_CREATION_FAILED_USERNAME_EXIST = 22;
    
    public static final int UPDATE_USERNAME = 31;
    public static final int UPDATE_FAILED_USERNAME_EXIST = 32;
    
    private int activityId;
    
    private ZonedDateTime activityDateTime;
    
    private String actorUsername;
    
    private int activityType;
    
    public static ArrayList<Activity> activityList = new ArrayList<Activity>();
    
    public static int currentActivityId;
    
    public Activity(int activityType, String actorUsername)
    {
        
        this.activityType = activityType;
        this.actorUsername = actorUsername;
        
        this.activityDateTime = ZonedDateTime.now();
        
        this.activityId = currentActivityId;
        
        currentActivityId++;
        
    }
    
    public static void printAllActivities()
    {
        /*
        activityList.forEach((tempActivity) -> {
            System.out.println(tempActivity.actorUsername + " : " + 
                    tempActivity.activityType + " at " +
                    tempActivity.activityDateTime.toString()); 
        });
        */
        Activity tempActivity;
        
        for (int i = 0; i < activityList.size(); i++)
        {
            tempActivity = activityList.get(i);
            
            System.out.println(tempActivity.activityId + " : " +
                    tempActivity.actorUsername + " -> " + 
                    tempActivity.activityType + " at " +
                    tempActivity.activityDateTime.toString());
        }
    }
    
    public static void printTodayActivity()
    {
        activityList.forEach((tempActivity) -> {
            
            ZonedDateTime now = ZonedDateTime.now();
            
            // zonedDateTime.toLocalDate().equals(LocalDate.now(zonedDateTime.getZone()));
            
            if (now.getYear() == tempActivity.getActivityDateTime().getYear() &&
                    now.getDayOfYear() == tempActivity.getActivityDateTime().getDayOfYear())
            {
                System.out.println(tempActivity.actorUsername + " : " + 
                        tempActivity.activityType + " at " +
                        tempActivity.activityDateTime.toString()); 
            }
        });
    }
    
    public static void printLastTenActivities()
    {
        Activity tempActivity;
        
        for(int i = activityList.size()-1, j = 0; i >= 0 && j < 10; i--, j++)
        {
            tempActivity = activityList.get(i);
            System.out.println(tempActivity.actorUsername + " : " + 
                        tempActivity.activityType + " at " +
                        tempActivity.activityDateTime.toString()); 
        }
    }

    /**
     * @return the activityId
     */
    public int getActivityId() {
        return activityId;
    }

    /**
     * @return the activityDateTime
     */
    public ZonedDateTime getActivityDateTime() {
        return activityDateTime;
    }

    /**
     * @return the actorUsername
     */
    public String getActorUsername() {
        return actorUsername;
    }

    /**
     * @return the activityType
     */
    public int getActivityType() {
        return activityType;
    }
    
}
