package org.srdtu.srdtu;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerFragment;

public class HomeV2 extends AppCompatActivity {

    // _________________________________________________________
    public static final String API_KEY = "AIzaSyDmQwpF6cWM3O1ilNwpb2tA3ofYfMZKT6U";
    //https://www.youtube.com/watch?v=<VIDEO_ID>
    public static final String VIDEO_ID = "7R5p1aZfWSw";
    // _________________________________________________________

    Button events;
    Button myevents;
    Button contactus;
    Button share;
    Button council;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_home_v2);

        events = (Button)findViewById(R.id.homev2_events);
        myevents = (Button)findViewById(R.id.homev2_myevents);
        contactus = (Button)findViewById(R.id.homev2_contactus);
        share = (Button)findViewById(R.id.homev2_share);
        council = (Button)findViewById(R.id.homev2_council);

        //Listeners
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open events viewer
                Intent intent = new Intent(getApplicationContext(),EventsList.class);
                startActivity(intent);
            }
        });

        myevents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MyEvents.class);
                startActivity(intent);
            }
        });

        contactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open contact us page
                Intent intent = new Intent(Intent.ACTION_VIEW);
                Uri data = Uri.parse("mailto:societyofrobotics@gmail.com");
                intent.setData(data);
                startActivity(intent);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClipboardManager clipboard = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("share","https://www.facebook.com/EXCELSIOR2015/?fref=ts");
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getApplicationContext(),"Link copied to clipboard",Toast.LENGTH_LONG).show();
            }
        });

        council.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),FestCouncil.class);
                startActivity(intent);
            }
        });

        share.setVisibility(View.GONE);


        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        YouTubePlayerFragment playerFragment = (YouTubePlayerFragment)getFragmentManager()
                .findFragmentById(R.id.youtube_videoV2);

        playerFragment.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.cueVideo(VIDEO_ID);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                //Toast.makeText(YouTubePlayerFragmentActivity.this, "Error while initializing YouTubePlayer.", Toast.LENGTH_SHORT).show();
            }
        });



    }

}
