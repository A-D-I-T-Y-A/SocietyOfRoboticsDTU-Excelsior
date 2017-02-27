package org.srdtu.srdtu;

/**
 * Created by Aditya on 1/23/2017.
 */

import android.app.usage.UsageEvents;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.MyViewHolder> {

    private List<String> eventList;
    Context mcontext;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView event_name;
        public ImageView event_image;
        //Bitmap bmp;

        public MyViewHolder(View view) {
            super(view);
            event_name = (TextView) view.findViewById(R.id.event_item_name);
            event_image = (ImageView) view.findViewById(R.id.event_item_image);
        }
    }


    public EventAdapter(List<String> eventList, Context context) {
        this.eventList = eventList;
        mcontext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.event_list_item, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        //Movie movie = eventList.get(position);
        holder.event_image.setImageDrawable(mcontext.getResources().getDrawable(getID(eventList.get(position))));
        holder.event_name.setText(eventList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext,EventViewer.class);
                intent.putExtra("Title",eventList.get(position));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mcontext.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return eventList.size();
    }

    public int getID(String s){
        switch(s){
            case "Bend it like Asimove (Robot Soccer)":
                return R.drawable.bend1;

            case "Botzilla (Robot War)":
                return R.drawable.botzilla1;

            case "Bomb Barrage":
                return R.drawable.bomb1;

            case "Chasing a Mirage (Laser Maze)":
                return R.drawable.chasing1;

            case "Code Safari":
                return R.drawable.code1;

            case "Crack the Company":
                return R.drawable.crack1;

            case "Creating Talks":
                return R.drawable.creating1;

            case "Eureka (Research Paper)":
                return R.drawable.eureka1;

            case "Fast'17 (Robot Race)":
                return  R.drawable.fast1;

            case "Fastest Line Follower (LFR)":
                return R.drawable.fastest1;

            case "IC ART":
                return R.drawable.ic1;

            case "Java Derby":
                return R.drawable.java1;

            case "Mock Stock":
                return R.drawable.mock1;

            case "Quidditch":
                return R.drawable.quidditch1;

            case "Quizzards":
                return R.drawable.quizzards1;

            case "Silicon Valley":
                return R.drawable.silicon1;

            case "Simulate One, Complete One":
                return R.drawable.simulate1;

            case "Pull it that way":
                return R.drawable.pull1;

            default:
                return R.drawable.eu;
        }

    }

}

