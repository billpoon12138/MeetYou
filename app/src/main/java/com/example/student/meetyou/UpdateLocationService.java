package com.example.student.meetyou;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.widget.Toast;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class UpdateLocationService extends IntentService {

    boolean asyncing = false;

    public UpdateLocationService() {
        super("UpdateLocationService");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "Starting ...", Toast.LENGTH_SHORT)
                .show();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        try {
            // working here

//            User.UpdateLocation(new User("U100002",1.292333, 103.776815));
//
//            Thread.sleep(1*1000);
            //get SharedPerences data
            SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            final String user_id = pref.getString("User_id", "U100001");

            while(true){
                User.UpdateLocation(new User(user_id,11.292333, 103.776815));

                Thread.sleep(1*30000);
            }
        } catch (InterruptedException e) {
        }
    }

}
