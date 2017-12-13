package com.example.liangminglin.mywaitor;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class payActivity extends AppCompatActivity {

    Button cashButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        cashButton = (Button) findViewById(R.id.cashButton);
        cashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(com.example.liangminglin.mywaitor.payActivity.this);
                builder.setTitle("Successful Payment");
                builder.setMessage("Thank You, Your Food Will Be Right Up");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent payment= new Intent(com.example.liangminglin.mywaitor.payActivity.this, MainActivity.class);
                        startActivity(payment);
                    }
                });
                builder.create();
                builder.show();
            }
        });
    }
}
