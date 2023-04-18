package com.example.prototype;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.prototype.models.Extras;
import com.example.prototype.models.PizzaModel;
import com.fxn.stash.Stash;
import com.google.android.material.checkbox.MaterialCheckBox;

import java.util.ArrayList;

public class ProductDetailActivity extends AppCompatActivity {
    ArrayList<PizzaModel> cart, pizzaModels;
    ArrayList<Extras> extras;
    int pos, defaultPos;
    Button addToCart;
    double price, curPrice;
    int quantity = 1;
    ImageView pizzaImage, next, prev, add, sub;
    TextView name, quant, priceTv;
    MaterialCheckBox tomato, salami, sausage, cheddar, braised, pepper, fanta, sprite, pepsi, water;
    Extras tomatoEX, salamiEX, sausageEX, cheddarEX, braisedEX, pepperEX, fantaEX, spriteEX, pepsiEX, waterEX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);

        pos = getIntent().getIntExtra("pos", 0);

        defaultPos = -1;

        pizzaImage = findViewById(R.id.pizzaImage);
        priceTv = findViewById(R.id.price);
        next = findViewById(R.id.next);
        prev = findViewById(R.id.prev);
        add = findViewById(R.id.addQuan);
        sub = findViewById(R.id.subQuan);
        name = findViewById(R.id.pizzaName);
        quant = findViewById(R.id.quantityText);
        addToCart = findViewById(R.id.addToCart);

        tomato = findViewById(R.id.tomato);
        salami = findViewById(R.id.salami);
        sausage = findViewById(R.id.sausage);
        cheddar = findViewById(R.id.cheddar);
        braised = findViewById(R.id.braised);
        pepper = findViewById(R.id.pepper);
        fanta = findViewById(R.id.fanta);
        sprite = findViewById(R.id.sprite);
        pepsi = findViewById(R.id.pepsi);
        water = findViewById(R.id.water);

        tomatoEX = new Extras("Tomato", 1.5);
        salamiEX = new Extras("Salami", 2.5);
        sausageEX = new Extras("Sausage", 2.5);
        cheddarEX = new Extras("Cheddar", 1.5);
        braisedEX = new Extras("Braised", 3.5);
        pepperEX = new Extras("Pepper", 1.5);

        waterEX = new Extras("Water", 1.5);
        pepsiEX = new Extras("Pepsi", 2.5);
        fantaEX = new Extras("Fanta", 2.5);
        spriteEX = new Extras("Sprite", 3.5);

        extras = new ArrayList<>();
        cart = new ArrayList<>();
        pizzaModels = new ArrayList<>();

        pizzaModels = Stash.getArrayList("Pizza", PizzaModel.class);
        cart = Stash.getArrayList("cart", PizzaModel.class);

        pizzaImage.setImageResource(pizzaModels.get(pos).getImage());
        name.setText(pizzaModels.get(pos).getName());
        curPrice = pizzaModels.get(pos).getPrice();
        price = curPrice;
        priceTv.setText(curPrice + "");

        checkStates();

        add.setOnClickListener(v -> {
            quantity++;
            quant.setText(quantity + "");
            price = price + curPrice;
            priceTv.setText(String.format("%.2f", price));
        });
        sub.setOnClickListener(v -> {
            if (quantity>1){
                quantity--;
                quant.setText(quantity + "");
                price = price - curPrice;
                priceTv.setText(String.format("%.2f", price));
            }
        });

        next.setOnClickListener(v -> {
            setViews(true);
        });

        prev.setOnClickListener(v -> {
            setViews(false);
        });

        addToCart.setOnClickListener(v -> {
            cart.add(new PizzaModel(pizzaModels.get(pos).getImage(), pizzaModels.get(pos).getName(), price, extras, quantity));
            Stash.put("cart", cart);
        });

    }

    private void checkStates() {
        water.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                price = price + 1.5;
                priceTv.setText(String.format("%.2f", price));
                extras.add(waterEX);
            } else {
                price = price - 1.5;
                priceTv.setText(String.format("%.2f", price));
                extras.remove(waterEX);
            }
        });

        fanta.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                price = price + 2.5;
                priceTv.setText(String.format("%.2f", price));
                extras.add(fantaEX);
            } else {
                price = price - 2.5;
                priceTv.setText(String.format("%.2f", price));
                extras.remove(fantaEX);
            }
        });

        pepsi.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                price = price + 2.5;
                priceTv.setText(String.format("%.2f", price));
                extras.add(pepsiEX);
            } else {
                price = price - 2.5;
                priceTv.setText(String.format("%.2f", price));
                extras.remove(pepsiEX);
            }
        });

        sprite.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                price = price + 3.5;
                priceTv.setText(String.format("%.2f", price));
                extras.add(spriteEX);
            } else {
                price = price - 3.5;
                priceTv.setText(String.format("%.2f", price));
                extras.remove(spriteEX);
            }
        });

        // -----------------------------------------------------------

        sausage.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                price = price + 2.5;
                priceTv.setText(String.format("%.2f", price));
                extras.add(sausageEX);
            } else {
                price = price - 2.5;
                priceTv.setText(String.format("%.2f", price));
                extras.remove(sausageEX);
            }
        });

        salami.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                price = price + 2.5;
                priceTv.setText(String.format("%.2f", price));
                extras.add(salamiEX);
            } else {
                price = price - 2.5;
                priceTv.setText(String.format("%.2f", price));
                extras.remove(salamiEX);
            }
        });

        tomato.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                price = price + 1.5;
                priceTv.setText(String.format("%.2f", price));
                extras.add(tomatoEX);
            } else {
                price = price - 1.5;
                priceTv.setText(String.format("%.2f", price));
                extras.remove(tomatoEX);
            }
        });

        cheddar.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                price = price + 1.5;
                priceTv.setText(String.format("%.2f", price));
                extras.add(cheddarEX);
            } else {
                price = price - 1.5;
                priceTv.setText(String.format("%.2f", price));
                extras.remove(cheddarEX);
            }
        });

        pepper.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                price = price + 1.5;
                priceTv.setText(String.format("%.2f", price));
                extras.add(pepperEX);
            } else {
                price = price - 1.5;
                priceTv.setText(String.format("%.2f", price));
                extras.remove(pepperEX);
            }
        });

        braised.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                price = price + 3.5;
                priceTv.setText(String.format("%.2f", price));
                extras.add(braisedEX);
            } else {
                price = price - 3.5;
                priceTv.setText(String.format("%.2f", price));
                extras.remove(braisedEX);
            }
        });

    }

    private void setViews(boolean b) {
        if (b){
            if (pos < 5){
                pos++;
                pizzaImage.setImageResource(pizzaModels.get(pos).getImage());
                name.setText(pizzaModels.get(pos).getName());
                curPrice = pizzaModels.get(pos).getPrice();
                price = curPrice;
                priceTv.setText(curPrice + "");
                quantity = 1;
                quant.setText(quantity + "");
                extras.clear();
            }
        } else {
            if (pos>0) {
                pos--;
                pizzaImage.setImageResource(pizzaModels.get(pos).getImage());
                name.setText(pizzaModels.get(pos).getName());
                curPrice = pizzaModels.get(pos).getPrice();
                price = curPrice;
                priceTv.setText(curPrice + "");
                quantity = 1;
                extras.clear();
                quant.setText(quantity + "");
            }
        }
    }
}