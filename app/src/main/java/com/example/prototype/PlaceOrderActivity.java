package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class PlaceOrderActivity extends AppCompatActivity {
    TextView subTotal, cartTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);

        subTotal = findViewById(R.id.subTotal);
        cartTotal = findViewById(R.id.cartTotal);

        double p = getIntent().getIntExtra("price", 0);

        cartTotal.setText("$"+p);
        subTotal.setText("$"+(p+2.98));

    }
}