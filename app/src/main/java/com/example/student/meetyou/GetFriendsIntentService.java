package com.example.student.meetyou;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.widget.Toast;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class GetFriendsIntentService extends IntentService {


    public GetFriendsIntentService() {
        super("GetFriendsIntentService");
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

            while(true){
                User.UpdateLocation(new User("U100002",11.292333, 103.776815));

                Thread.sleep(1*30000);
            }
        } catch (InterruptedException e) {
        }
    }
}
