package org.srdtu.srdtu;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;

public class Register extends AppCompatActivity {

    EditText mname;
    EditText memail;
    EditText mphone;
    EditText mcollege;
    EditText mbranch;
    EditText myear;
    TextView mevent;

    Button mRegister;

    ProgressDialog progressDialog;

    String name,email,phone,branch,college,year,event;

    SharedPreferences pf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        event = getIntent().getStringExtra("Title");

        mname = (EditText)findViewById(R.id.register_name);
        memail = (EditText)findViewById(R.id.register_email);
        mphone = (EditText)findViewById(R.id.register_contact);
        mcollege = (EditText)findViewById(R.id.register_college);
        mbranch = (EditText)findViewById(R.id.register_branch);
        myear = (EditText)findViewById(R.id.register_year);
        mevent = (TextView)findViewById(R.id.register_event);
        mRegister = (Button)findViewById(R.id.register_submit);
        pf = getSharedPreferences("MyEvents",MODE_PRIVATE);



        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 3 FIX THIS
                /* if(validate()){
                    new SubmitData().execute("abc");
                }*/
                Set<String> events = pf.getStringSet("MyEvents",null);
                if(events == null){
                    Set<String> nev = new HashSet<String>();
                    nev.add(event);
                    pf.edit().putStringSet("MyEvents",nev).commit();
                    Log.d("pf","null");
                }
                else {
                    events.add(event);
                    pf.edit().putStringSet("MyEvents", events).apply();
                    Log.d("pf",Integer.toString(events.size()));
                }
            }
        });

        mevent.setText(event);

    }

    // Check valid form information
    private boolean validate(){
        if( (!mname.getText().toString().isEmpty()) && mname.getText().toString() != ""){
            name = mname.getText().toString();
        }
        else
            return false;

        if( (!memail.getText().toString().isEmpty()) && memail.getText().toString() != "" &&
                memail.getText().toString().contains("@") ){
            email = memail.getText().toString();
        }
        else
            return false;

        if( (!mphone.getText().toString().isEmpty()) && mphone.getText().toString() != ""){
            phone = mphone.getText().toString();
        }
        else
            return false;

        if( (!mcollege.getText().toString().isEmpty()) && mcollege.getText().toString() != ""){
            college = mcollege.getText().toString();
        }
        else
            return false;

        if( (!mbranch.getText().toString().isEmpty()) && mbranch.getText().toString() != ""){
            branch = mbranch.getText().toString();
        }
        else
            return false;

        if( (!myear.getText().toString().isEmpty()) && myear.getText().toString() != ""){
            year = myear.getText().toString();
        }
        else
            return false;
        return true;
    }

    private class SubmitData extends AsyncTask<String,Void,String > {

        @Override
        protected void onPreExecute(){

            progressDialog = new ProgressDialog(Register.this);
            progressDialog.setMessage("Registering...");
            progressDialog.setTitle("Register");
            progressDialog.setCancelable(true);
            progressDialog.show();
        }


        @Override
        protected String doInBackground(String... params) {
            return "success";
        }
        @Override
        protected void onPostExecute(String s){
            progressDialog.dismiss();

            Set<String> events = pf.getStringSet("MyEvents",null);

            events.add(event);
            pf.edit().putStringSet("MyEvents",events).apply();

        }
    }

}
