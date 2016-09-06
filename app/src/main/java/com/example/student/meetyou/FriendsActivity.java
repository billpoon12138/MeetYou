package com.example.student.meetyou;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class FriendsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        final ListView list = (ListView) findViewById(R.id.listView);
        list.setOnItemClickListener(this);

        //get SharedPerences data
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        final String user_id = pref.getString("User_id", "U100001");
        new AsyncTask<Void, Void, List<Friend>>() {
            @Override
            protected List<Friend> doInBackground(Void... params) {
                return Friend.getFriends(user_id);
            }
            @Override
            protected void onPostExecute(List<Friend> result) {
                MyAdapter adapter = new MyAdapter(FriendsActivity.this, R.layout.row3, result);
                list.setAdapter(adapter);
            }
        }.execute();





        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> av, View v, int position, long id) {
        Friend friend = (Friend) av.getAdapter().getItem(position);
        Intent intent = new Intent(this, FriendDetailActivity.class);
        intent.putExtra("details", friend);
        startActivity(intent);
    }

}

// get friends asynctask

//                String user_id = "U100001";
//                new AsyncTask<String, Void, Void>() {
//                    @Override
//                    protected Void doInBackground(String... params) {
//                        List<Friend> friends =  Friend.getFriends(params[0]);
//                        return null;
//                    }
//                    @Override
//                    protected void onPostExecute(Void result) {
//                        finish();
//                    }
//                }.execute(user_id);


//  update user location asynstask

//                User user = new User("U100001",1.292333, 103.776815);
//                new AsyncTask<User, Void, Void>() {
//                    @Override
//                    protected Void doInBackground(User... params) {
//                        String isTrue =  User.UpdateLocation(params[0]);
//                        if("true".equals(isTrue)){
//                            Intent intent = new Intent(getApplicationContext(), MapsActivity.class);
//                            startActivity(intent);
//                        }
//                        return null;
//                    }
//                    @Override
//                    protected void onPostExecute(Void result) {
//                        finish();
//                    }
//                }.execute(user);