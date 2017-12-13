package com.example.liangminglin.mywaitor;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.*;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.*;
import android.text.*;



public class MainActivity extends AppCompatActivity {

    private ImageButton friedChicken;
    private Button payment_Buttom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        friedChicken = (ImageButton) findViewById(R.id.fried_Chicken);
        payment_Buttom = (Button) findViewById(R.id.payment_Button);

        friedChicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent fChicken = new Intent(MainActivity.this, NewActivity.class);
                startActivity(fChicken);
            }
        });

        payment_Buttom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent payment= new Intent(MainActivity.this, paymentActivity.class);
                startActivity(payment);
            }
        });
    }


}