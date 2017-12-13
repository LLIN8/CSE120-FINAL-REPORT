package com.example.liangminglin.testing;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import android.content.Intent;

import org.w3c.dom.Text;

public class Insert extends AppCompatActivity {

    int count = 0;
    DBManager db;
    final static int price = 5;
    Test tes;
    TextView t;

    Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        confirm = (Button) findViewById(R.id.confirmB);
        db = new DBManager(this);
        insertData();

    }

    public void insertData()
    {
        confirm.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                tes = new Test();

                tes.setNAME("FRIED CHICKEN");
                tes.setNUM(Integer.toString(count));
                tes.setVALUE(Integer.toString(price));

                db.insertTest(tes);



                startActivity(new Intent(Insert.this, MainActivity.class));
            }
        });
    }

    public void countOrder(View v)
    {
        count ++;
    }

    public void dCountOrder(View v)
    {
        if(count > 0)
        {
            count--;
        }
    }
}
