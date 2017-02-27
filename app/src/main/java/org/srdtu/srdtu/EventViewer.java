package org.srdtu.srdtu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;

public class EventViewer extends AppCompatActivity {

    String title;
    String eCode;
    String date;
    String details;
    String venue;
    Resources res;

    TextView mTitle;
    TextView mDate;
    TextView mDetails;
    TextView mVenue;

    ImageView img;

    Button mregister;

    SharedPreferences pf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_viewer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //Initialising
        title = getIntent().getStringExtra("Title");
        mTitle = (TextView)findViewById(R.id.viewer_title);
        mDate = (TextView)findViewById(R.id.viewer_date);
        mDetails = (TextView)findViewById(R.id.viewer_description);
        mVenue = (TextView)findViewById(R.id.viewer_venue);
        mregister = (Button)findViewById(R.id.viewer_register);
        mregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent intent = new Intent(EventViewer.this,Register.class);
                intent.putExtra("Title",title);
                startActivity(intent);*/
                Set<String> events = pf.getStringSet("MyEvents",null);
                if(events == null){
                    Set<String> nev = new HashSet<String>();
                    nev.add(title);
                    pf.edit().putStringSet("MyEvents",nev).commit();
                    Log.d("pf","null");
                }
                else {
                    events.add(title);
                    pf.edit().putStringSet("MyEvents", events).apply();
                    Log.d("pf",Integer.toString(events.size()));
                }
                Uri uri = Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSfBSBez1hryPcKDhd5F7HBhABK46gMrt4CepKipYT83VRB-aQ/viewform");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        img = (ImageView)findViewById(R.id.viewer_image) ;
        eCode = EventCode.getCode(title);
        res = getResources();

        pf = getSharedPreferences("MyEvents",MODE_PRIVATE);
        Set<String> s = pf.getStringSet("MyEvents",null);
        if(s!=null && s.contains(title)){
            //mregister.setVisibility(View.GONE);
            Log.d("pf","event viewer");
        }
        else{
            Log.d("pf","event viewer :(");
        }


        //Event Data
        date = res.getString(res.getIdentifier(eCode+"2","string","org.srdtu.srdtu"));
        venue = res.getString(res.getIdentifier(eCode+"3","string","org.srdtu.srdtu"));
        details = res.getString(res.getIdentifier(eCode+"1","string","org.srdtu.srdtu"));

        //Update UI
        mTitle.setText(title);
        mDate.setText(date);
        mVenue.setText(venue);
        mDetails.setText(details);
        img.setImageDrawable(getResources().getDrawable(getID(title)));


    }

    public int getID(String s){
        switch(s){
            case "Bend it like Asimove (Robot Soccer)":
                return R.drawable.bend;

            case "Botzilla (Robot War)":
                return R.drawable.botzilla;

            case "Bomb Barrage":
                return R.drawable.bomb;

            case "Chasing a Mirage (Laser Maze)":
                return R.drawable.chasing;

            case "Code Safari":
                return R.drawable.code;

            case "Crack the Company":
                return R.drawable.crack;

            case "Creating Talks":
                return R.drawable.creating;

            case "Eureka (Research Paper)":
                return R.drawable.eureka;

            case "Fast'17 (Robot Race)":
                return  R.drawable.fast;

            case "Fastest Line Follower (LFR)":
                return R.drawable.fastest;

            case "IC ART":
                return R.drawable.ic;

            case "Java Derby":
                return R.drawable.java;

            case "Mock Stock":
                return R.drawable.mock;

            case "Quidditch":
                return R.drawable.quidditch;

            case "Quizzards":
                return R.drawable.quizzards;

            case "Silicon Valley":
                return R.drawable.silicon;

            case "Simulate One, Complete One":
                return R.drawable.simulate;

            case "Pull it that way":
                return R.drawable.pull;

            default:
                return R.drawable.eu;
        }

    }

}
