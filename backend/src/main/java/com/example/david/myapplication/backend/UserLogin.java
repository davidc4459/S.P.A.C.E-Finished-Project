package com.example.david.myapplication.backend;

/**
 * Created by david on 01/02/2016.
 */
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class UserLogin {
    @Id
    String UserID;
    public UserLogin() {}

    public void setUserID(String UserID)
    {this.UserID = UserID;}
    public String getUserID()
    {return UserID;}

}
