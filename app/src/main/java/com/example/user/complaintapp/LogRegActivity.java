package com.example.user.complaintapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogRegActivity extends AppCompatActivity {
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_reg);
        b1=(Button)findViewById(R.id.log);
        b2=(Button)findViewById(R.id.reg);
        //login
        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent myIntent1 = new Intent(
                        LogRegActivity.this,Login.class);
                startActivity(myIntent1);

            }
        });
        //register
    b2.setOnClickListener(new View.OnClickListener() {

        public void onClick(View v) {
            Intent myIntent1 = new Intent(
                    LogRegActivity.this,LogRegActivity.class);
            startActivity(myIntent1);

        }
    });





}
}
