package com.example.prototype;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import com.fxn.stash.Stash;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener  {
    ImageView toogle;
    NavigationView navView;
    DrawerLayout drawLayout;
    ArrayList<PizzaModel> pizzaModels;
    ArrayList<Extras> extras;

    CardView add1,add2,add3,add4,add5,add6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Constants.checkApp(this);

        toogle = findViewById(R.id.toogle);
        drawLayout = findViewById(R.id.drawLayout);
        add1 = findViewById(R.id.add1);
        add2 = findViewById(R.id.add2);
        add3 = findViewById(R.id.add3);
        add4 = findViewById(R.id.add4);
        add5 = findViewById(R.id.add5);
        add6 = findViewById(R.id.add6);

        pizzaModels = new ArrayList<>();
        extras = new ArrayList<>();

        addPizza();

        add1.setOnClickListener(v -> {
          startActivity(new Intent(this, ProductDetailActivity.class).putExtra("pos", 0));
        });

        add2.setOnClickListener(v -> {
          startActivity(new Intent(this, ProductDetailActivity.class).putExtra("pos", 1));
        });

        add3.setOnClickListener(v -> {
          startActivity(new Intent(this, ProductDetailActivity.class).putExtra("pos", 2));
        });

        add4.setOnClickListener(v -> {
          startActivity(new Intent(this, ProductDetailActivity.class).putExtra("pos", 3));
        });

        add5.setOnClickListener(v -> {
          startActivity(new Intent(this, ProductDetailActivity.class).putExtra("pos", 4));
        });

        add6.setOnClickListener(v -> {
          startActivity(new Intent(this, ProductDetailActivity.class).putExtra("pos", 5));
        });

//        ActionBarDrawerToggle tog = new ActionBarDrawerToggle(
//                this,
//                drawLayout, toolbar,
//                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        navView.setNavigationItemSelectedListener(this);
//        drawLayout.addDrawerListener(tog);
//        tog.syncState();

        toogle.setOnClickListener(v -> {
            if (drawLayout.isDrawerOpen(GravityCompat.START)) {
                drawLayout.closeDrawer(GravityCompat.START);
            } else {
                drawLayout.openDrawer(GravityCompat.START);
            }
        });

    }

    private void addPizza() {
        PizzaModel model1 = new PizzaModel(R.drawable.p1, "Margherita", 14.80, extras);
        PizzaModel model2 = new PizzaModel(R.drawable.p2, "Pepperoni", 12.09, extras);
        PizzaModel model3 = new PizzaModel(R.drawable.p3, "Buffalo", 13.99, extras);
        PizzaModel model4 = new PizzaModel(R.drawable.p4, "Cheese", 8.99, extras);
        PizzaModel model5 = new PizzaModel(R.drawable.p5, "Veggie", 9.99, extras);
        PizzaModel model6 = new PizzaModel(R.drawable.p6, "Hawaiian", 12.99, extras);

        pizzaModels.add(model1);
        pizzaModels.add(model2);
        pizzaModels.add(model3);
        pizzaModels.add(model4);
        pizzaModels.add(model5);
        pizzaModels.add(model6);

        Stash.put("Pizza", pizzaModels);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}