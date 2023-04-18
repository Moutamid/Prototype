package com.example.prototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prototype.adapter.CartAdapter;
import com.example.prototype.models.PizzaModel;
import com.fxn.stash.Stash;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class CheckOutActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ImageView toogle;
    DrawerLayout drawLayout;
    NavigationView navView;
    ArrayList<PizzaModel> cart;
    ImageView bag;
    TextView cartQuan, price;
    RecyclerView recycler;
    CartAdapter adapter;
    Button buy;
    double p = 0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_out);

        toogle = findViewById(R.id.toogle);
        drawLayout = findViewById(R.id.drawLayout);
        navView = findViewById(R.id.navView);
        recycler = findViewById(R.id.recycler);
        buy = findViewById(R.id.buy);
        price = findViewById(R.id.price);

        navView.setNavigationItemSelectedListener(this);

        recycler.setHasFixedSize(false);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        bag = findViewById(R.id.bag);
        cartQuan = findViewById(R.id.cartQuan);
        cart = new ArrayList<>();

        cart = Stash.getArrayList("cart", PizzaModel.class);

        cartQuan.setText(cart.size()+"");

        adapter = new CartAdapter(this, cart);
        recycler.setAdapter(adapter);

        for (int i=0; i<cart.size(); i++) {
            p = p + cart.get(i).getPrice();
            price.setText(String.format("%.2f", p));
        }

        toogle.setOnClickListener(v -> {
            if (drawLayout.isDrawerOpen(GravityCompat.START)) {
                drawLayout.closeDrawer(GravityCompat.START);
            } else {
                drawLayout.openDrawer(GravityCompat.START);
            }
        });

        buy.setOnClickListener(v -> {
            startActivity(new Intent(this, PlaceOrderActivity.class).putExtra("price", p));
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_order:
                startActivity(new Intent(CheckOutActivity.this, OrderActivity.class));
                break;
            case R.id.nav_login:
                Intent intent = new Intent(CheckOutActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
        }
        return true;
    }
}