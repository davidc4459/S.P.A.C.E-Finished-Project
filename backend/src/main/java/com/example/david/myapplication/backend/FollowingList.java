package com.example.david.myapplication.backend;

/**
 * Created by david on 04/03/2016.
 */
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class FollowingList {
    @Id
    String UserID;
    String UserID;

    public FollowingList() {}

    public void setUserID(String UserID)
    {this.UserID = UserID;}
    public String getUserID()
    {return UserID;}

    public void setUserID(String UserID)
    {this.UserID = UserID;}
    public String getUserID()
    {return UserID;}

}

