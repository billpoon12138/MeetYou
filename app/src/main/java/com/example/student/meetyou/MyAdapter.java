package com.example.student.meetyou;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class MyAdapter extends ArrayAdapter<Friend> {

    private List<Friend> items;

    public MyAdapter(Context context, int resource, List<Friend> items) {
        super(context, resource, items);
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext()
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.row3, null);
        Friend friend = items.get(position);

        if (friend != null) {
            TextView name = (TextView) v.findViewById(R.id.text1);
            name.setText(friend.get("User_name"));
            TextView id = (TextView) v.findViewById(R.id.text2);
            id.setText(friend.get("User_id"));
            final ImageView image = (ImageView) v.findViewById(R.id.imageView);

//            new AsyncTask<String, Void, Bitmap>() {
//                Bitmap b;
//                @Override
//                protected Bitmap doInBackground(String... id) {
//                    String url= String.format("http://dkiong.no-ip.biz/site/static/photo/%s.jpg",id[0]);
//                    try {
//                        InputStream in = new URL(url).openStream();
//                        b = BitmapFactory.decodeStream(in);
//                    } catch (Exception ex) {
//                        Log.e("Bitmap Error", ex.toString());
//                    }
//                    return b;
//                }
//                @Override
//                protected void onPostExecute(Bitmap bitmap) {
//                    image.setImageBitmap(bitmap);
//                }
//            }.execute(friend.get("id"));

        }
        return v;
    }
}