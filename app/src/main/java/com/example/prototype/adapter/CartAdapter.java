package com.example.prototype.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prototype.R;
import com.example.prototype.models.PizzaModel;

import java.util.ArrayList;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartVH> {

    Context context;
    ArrayList<PizzaModel> list;

    public CartAdapter(Context context, ArrayList<PizzaModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CartVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cart_item, parent, false);
        return new CartVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartVH holder, int position) {
        PizzaModel model = list.get(holder.getAdapterPosition());

        holder.srNum.setText("#" + (holder.getAdapterPosition() + 1));
        holder.name.setText(model.getName());
        holder.price.setText("$" + String.format("%.2f", model.getPrice()));
        holder.qt.setText(""+model.getQuantity());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CartVH extends RecyclerView.ViewHolder{
        TextView srNum, name, qt, price;
        public CartVH(@NonNull View itemView) {
            super(itemView);
            srNum = itemView.findViewById(R.id.srNum);
            name = itemView.findViewById(R.id.name);
            qt = itemView.findViewById(R.id.qt);
            price = itemView.findViewById(R.id.price);
        }
    }

}
