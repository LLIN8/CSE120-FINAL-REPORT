package com.example.jchen415.mywaytormobileapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Payment2 extends AppCompatActivity {

    //create decimal format
    DecimalFormat numberFormat = new DecimalFormat("#.00");
    //create textview
    TextView subTotal;
    TextView totalAmount;

    //create button
    Button fivePercent;
    Button tenPercent;
    Button twentyFivePercent;
    Button cashButton;

    //create database object
    DBController db;

    //define variables
    double finalTotal = 0;
    double price = 0;
    double tipsAmount = 0;
    double total = 0;
    double taxAmount = 0;
    double subTotalAmount = 0;

    //define constant
    final double ZERO_PERCENT = 0.00;
    final double TEN_PERCENT = 0.10;
    final double TWENTY_FIVE_PERCENT = 0.25;
    final double TAX = 0.08;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        //set pointer to the object
        fivePercent = (Button) findViewById(R.id.fiveP);
        tenPercent = (Button) findViewById(R.id.tenPercent);
        twentyFivePercent = (Button) findViewById(R.id.twentyFive);

        db = new DBController(this);
        subTotal = (TextView) findViewById(R.id.subTotal);
        totalAmount = (TextView) findViewById(R.id.TotalAmoutText);

        //get the data from database
        Cursor res = db.getAllData2();
        StringBuffer buff = new StringBuffer();
        do {
            price = ((Float.valueOf(res.getString(1))) * (Integer.valueOf(res.getString(2))));
            total += price;

        } while (res.moveToNext());


        //call functions
        zeroPT();
        tenPT();
        twentyFivePT();
        cashPayment();
        checkCreditCard();

        //calculating the amount and display
        taxAmount = total * TAX;

        subTotalAmount = taxAmount + total;

        subTotal.setText("SubTotal : " + numberFormat.format(subTotalAmount));
    }

    public void zeroPT() {
        fivePercent.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                totalAmount.setText("FINAL TOTAL: $" + numberFormat.format(subTotalAmount));

            }
        });

    }

    public void tenPT() {
        tenPercent.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                tipsAmount = TEN_PERCENT * subTotalAmount;
                finalTotal = tipsAmount + subTotalAmount;

                totalAmount.setText("FINAL TOTAL: $" + numberFormat.format(finalTotal));

            }
        });

    }

    public void twentyFivePT() {
        twentyFivePercent.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {


                tipsAmount = TWENTY_FIVE_PERCENT * subTotalAmount;
                finalTotal = tipsAmount + subTotalAmount;

                totalAmount.setText("FINAL TOTAL: $" + numberFormat.format(finalTotal));

            }
        });

    }

    public void cashPayment() {
        cashButton = (Button) findViewById(R.id.cash);
        cashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Payment2.this);
                builder.setTitle("Successful Payment");
                builder.setMessage("Thank You, Your Food Will Be Right Up");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent payment = new Intent(Payment2.this, Menu2.class);
                        db.deleteData();
                        startActivity(payment);
                    }
                });
                builder.create();
                builder.show();
            }
        });
    }

    public void checkCreditCard() {
        Button cardButton = (Button) findViewById(R.id.card);
        cardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!db.checkCard()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Payment2.this);
                    builder.setTitle("No Card Exists");
                    builder.setMessage("Please Enter Card Info!");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent payment = new Intent(Payment2.this, CardRegistrationActivity.class);
                            startActivity(payment);
                            finish();
                        }
                    });
                    builder.create();
                    builder.show();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Payment2.this);
                    builder.setTitle("Successful Payment");
                    builder.setMessage("Thank You, Your Food Will Be Right Up");
                    builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent payment = new Intent(Payment2.this, Menu2.class);
                            db.deleteData();
                            startActivity(payment);
                        }
                    });
                    builder.create();
                    builder.show();
                }
            }
        });
    }
}