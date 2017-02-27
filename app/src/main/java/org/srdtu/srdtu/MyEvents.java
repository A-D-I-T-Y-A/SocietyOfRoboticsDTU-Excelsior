package org.srdtu.srdtu;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MyEvents extends AppCompatActivity {

    SharedPreferences pf;
    Set<String> mevents;
    List<String> myev;

    private RecyclerView recyclerView;
    private EventAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_events);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        pf = getSharedPreferences("MyEvents",MODE_PRIVATE);
        mevents = pf.getStringSet("MyEvents",null);
        if(mevents!= null && !mevents.isEmpty()){
            myev = new ArrayList<String>(mevents);
            recyclerView = (RecyclerView) findViewById(R.id.myevent_recycler_view);
            mAdapter = new EventAdapter(myev,getApplicationContext());
            RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getApplicationContext(),2);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(mAdapter);

        }

    }

}
