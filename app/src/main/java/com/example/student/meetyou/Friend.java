package com.example.student.meetyou;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by student on 1/8/16.
 */
public class Friend  extends HashMap<String, String> {

//    String User_id;
//    String User_name;
//    int Phone;
//    String Email;
//    String Gender;
//    float Location_longitude;
//    float Location_dimensionality;

    final static String host = "http://172.23.133.150/WCFService_MeetYou/Service.svc/";

    public Friend(String User_id, String User_name, String Phone, String Email, String Gender) {
        put("User_id", User_id);
        put("User_name", User_name);
        put("Phone", Phone);
        put("Email", Email);
        put("Gender", Gender);
    }

    public Friend(String User_id, String User_name, String Phone, String Email, String Gender,
                  String Location_longitude, String Location_dimensionality) {
        put("User_id", User_id);
        put("User_name", User_name);
        put("Phone", Phone);
        put("Email", Email);
        put("Gender", Gender);
        put("Location_longitude", Location_longitude);
        put("Location_dimensionality", Location_dimensionality);
    }

    public static List<Friend> getFriends(String user_id){
        List<Friend> friends = new ArrayList<Friend>();
        try {
            JSONArray jsons = JSONParser.getJSONArrayFromUrl
                    (host + "Friends/"+user_id);
            int nnn = jsons.length();
            for(int i = 0; i < jsons.length(); i ++){
                JSONObject json = jsons.getJSONObject(i);
                String id = json.getString("User_id");
                String name = json.getString("User_name");
                int phone = json.getInt("Phone");
                String email = json.getString("Email");
                String gender = json.getString("Gender");
                double llll = json.getDouble("Location_longitude");
                float longitude = (float)json.getDouble("Location_longitude");
                float dimensionality = (float)json.getDouble("Location_dimensionality");
                Friend friend = new Friend(id, name, Integer.toString(phone), email, gender,
                        String.valueOf(longitude), String.valueOf(dimensionality));
                friends.add(friend );
            }

        } catch (Exception e) {
        }
        return friends;
    }
}
