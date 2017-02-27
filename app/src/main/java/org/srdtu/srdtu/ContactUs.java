package org.srdtu.srdtu;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ContactUs extends AppCompatActivity {

    EditText ename;
    EditText eemail;
    EditText edetails;
    Button submit;

    String name;
    String email;
    String details;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ename = (EditText)findViewById(R.id.contactus_name);
        eemail = (EditText)findViewById(R.id.contactus_email);
        edetails = (EditText)findViewById(R.id.contactus_details);
        submit = (Button)findViewById(R.id.contactus_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //todo 2 , sending response
                if(validate()){
                    new SubmitData().execute("abc");
                }
            }
        });
    }

    // Check valid form information
    private boolean validate(){
        if( (!ename.getText().toString().isEmpty()) && ename.getText().toString() != ""){
            name = ename.getText().toString();
        }
        else
            return false;

        if( (!eemail.getText().toString().isEmpty()) && eemail.getText().toString() != "" &&
                eemail.getText().toString().contains("@") ){
            email = eemail.getText().toString();
        }
        else
            return false;

        if( (!edetails.getText().toString().isEmpty()) && edetails.getText().toString() != ""){
            details = edetails.getText().toString();
        }
        else
            return false;

        return true;
    }

    private class SubmitData extends AsyncTask<String,Void,String > {

        @Override
        protected void onPreExecute(){
            /*ProgressDialog.show(getApplicationContext(), "Submit", "Submitting...", true, true,
                    new DialogInterface.OnCancelListener() {
                        @Override
                        public void onCancel(DialogInterface dialog) {
                            Toast.makeText(getApplicationContext(),"Response not Submitted",Toast.LENGTH_SHORT);
                            dialog.dismiss();
                        }
                    });*/

            progressDialog = new ProgressDialog(ContactUs.this);
            progressDialog.setMessage("Submitting...");
            progressDialog.setTitle("Submit");
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
        }
    }

}
