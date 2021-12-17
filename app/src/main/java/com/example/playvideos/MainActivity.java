package com.example.playvideos;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    VideoView videoView;
    ListView listView;
    ArrayList<String> videolist;
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView=findViewById(R.id.videoview);
        listView=findViewById(R.id.lvideo);
        videolist=new ArrayList<>();
        videolist.add("morning_meditation_because_you_deserve_to_feel_good_today");
        videolist.add("morning_yoga_for_beginners");
        videolist.add("meditation_you_can_do_anywhere");
        videolist.add("morning_maditation_for_positive_energy");
        adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,videolist);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.morning_meditation_because_you_deserve_to_feel_good_today));
                        break;
                    case 1:
                        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.morning_yoga_for_beginners));
                        break;
                    case 2:
                        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.meditation_you_can_do_anywhere));
                        break;
                    case 3:
                        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.morning_maditation_for_positive_energy));
                        break;
                    default:break;
                }
                videoView.setMediaController(new MediaController(MainActivity.this));
                videoView.requestFocus();
                videoView.start();
            }
        });
    }
}