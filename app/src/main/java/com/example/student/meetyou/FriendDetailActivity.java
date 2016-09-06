package com.example.student.meetyou;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

public class FriendDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_detail);
        HashMap<String,String> obj = (HashMap) getIntent().getSerializableExtra("details");
        TextView t1 = (TextView) findViewById(R.id.textView6);
        TextView t2 = (TextView) findViewById(R.id.textView7);
        TextView t3 = (TextView) findViewById(R.id.textView8);
        TextView t4 = (TextView) findViewById(R.id.textView9);
        t1.setText(obj.get("User_name"));
        t2.setText(obj.get("User_id"));
        t3.setText(obj.get("Phone"));
        t4.setText(obj.get("Email"));

    }
}
