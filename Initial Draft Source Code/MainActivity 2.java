package com.example.liangminglin.testing;

import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.app.AlertDialog.Builder;

public class MainActivity extends AppCompatActivity {

    Button b, five, ten;
    DBManager db;
    TextView t;
    TextView bt;
    TextView fin;
    double total;

    final static double fiveP = 0.05;
    final static double tenP = 0.10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t = (TextView) findViewById(R.id.hiJ);
        five = (Button) findViewById(R.id.fiveTIp);
        ten = (Button) findViewById(R.id.tenTip);
        bt = (TextView) findViewById(R.id.bt);
        fin = (TextView) findViewById(R.id.finalTotal);
        db = new DBManager(this);
        b = (Button) findViewById(R.id.bjJ);

        moveTO();
        fivePT();
        tenPT();

    }

    public void moveTO()
    {
        b.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                Cursor res = db.getAllData();

                StringBuffer buff = new StringBuffer();
                StringBuffer buff1 = new StringBuffer();
                StringBuffer buff2 = new StringBuffer();


                buff.append("Name: " + res.getString(0)+ "\n");

                buff1.append("VALUE: " + res.getString(1) + "\n");
                buff2.append("NUM: " + res.getString(2) + "\n");


               t.setText(buff+ " "+buff1 + " " +buff2);
               totalAmount();
               bt.setText("SubTotal: $" + total + "\n");
                //showMessage("Data", buff.toString());
            }

        });
    }

    public void totalAmount()
    {
        Cursor res = db.getAllData();
        StringBuffer buff = new StringBuffer();

        int count = Integer.parseInt(res.getString(2));
        double price = Double.valueOf(res.getString(1));

        total = count * price;



    }

    public void fivePT()
    {
        five.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                double finalTotal;
                double realTotal;

                finalTotal = fiveP * total;
                realTotal = finalTotal + total;

                fin.setText("FINAL TOTAL: $" + realTotal);

            }
        });

    }


    public void tenPT()
    {
        ten.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){

                double finalTotal;
                double realTotal;

                finalTotal = tenP * total;
                realTotal = finalTotal + total;


                fin.setText("FINAL TOTAL: $" + realTotal);

            }
        });

    }



}
