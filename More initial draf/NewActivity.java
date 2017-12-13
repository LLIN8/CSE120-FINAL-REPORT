package com.example.liangminglin.mywaitor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class NewActivity extends AppCompatActivity {

    DBControll control;
    private Button confirm;
    TextView count;
    int counts = 0;

    TextView name;
    TextView price;
    EditText numberCount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        count = (TextView) findViewById(R.id.countOrder);

        confirm = (Button) findViewById(R.id.confirmButton);
        numberCount = (EditText) findViewById(R.id.countOrder);
        name = (TextView) findViewById(R.id.friendChickens);
        price = (TextView) findViewById(R.id.numberPriceText);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                String fName = name.getText().toString();
                String itemPrice = price.getText().toString();

                MenuDish newDish = new MenuDish();

                newDish.setCustomer_Name("ABC");
                newDish.setDish_Name(fName);
                newDish.setDish_Price(itemPrice);
                newDish.setDish_Quantity(5);

                control.insertMenuDish(newDish);




                Intent confirmB= new Intent(NewActivity.this, MainActivity.class);

                startActivity(confirmB);
            }
        });

    }

    public void countOrders(View v){
        counts++;
        count.setText(Integer.toString(counts));

    }


    public void dCountOrders(View v){
        if(counts > 0)
        {
            counts--;
        }
        count.setText(Integer.toString(counts));

    }
}
