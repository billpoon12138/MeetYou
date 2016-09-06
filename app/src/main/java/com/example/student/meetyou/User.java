package com.example.student.meetyou;

import android.util.Log;

import org.json.JSONObject;

/**
 * Created by student on 1/8/16.
 */
public class User {

    String User_name;
    String User_id;
    String Email;
    int Phone;
    String Password;
    String Gender;
    double Location_longitude;
    double Location_dimensionality;


    final static String host = "http://172.23.133.150/WCFService_MeetYou/Service.svc/";

    public User(String User_id, String Password) {
        this.User_id = User_id;
        this.Password = Password;
    }

    public User(String user_id, double location_longitude, double location_dimensionality) {
        Location_longitude = location_longitude;
        Location_dimensionality = location_dimensionality;
        User_id = user_id;
    }

    public static String Login(User u) {
        try {

            JSONObject user = new JSONObject();
            user.put("User_id", u.User_id);
            user.put("User_password", u.Password);
            String json = user.toString();
            String result = JSONParser.loginPostStream(host + "Login", json);
            result = result.substring(1, result.length() - 1);
            return result.toString();
        } catch (Exception e) {
            Log.e("Login error", e.toString());
            return "false";
        }
    }

    public static String UpdateLocation(User u){
        try{

            JSONObject user = new JSONObject();
            user.put("User_id",u.User_id);
            user.put("Location_longitude",u.Location_longitude);
            user.put("Location_dimensionality",u.Location_dimensionality);
            String json = user.toString();
            String result = JSONParser.postStream(host+"UpdateLocation",json);
            return result.toString();
        }catch (Exception e){
            Log.e("update location error", e.toString());
            return "false";
        }
    }



}
