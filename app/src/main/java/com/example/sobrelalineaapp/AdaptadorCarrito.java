package com.example.sobrelalineaapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.List;

public class AdaptadorCarrito extends RecyclerView.Adapter<AdaptadorCarrito.ProductosViewHolder> {

    Context context;
    List<Producto> carrito;
    TextView tvTotal;
    double total = 0;

    public AdaptadorCarrito(Context context, List<Producto> carrito, TextView tvTotal) {
        this.context = context;
        this.carrito = carrito;
        this.tvTotal = tvTotal;

        for(int i = 0 ; i < carrito.size() ; i++) {
            total = total + Double.parseDouble(""+carrito.get(i).getPrecio());
        }

        tvTotal.setText(""+total);

    }

    @NonNull
    @Override
    public ProductosViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rv_carrito, null, false);
        return new AdaptadorCarrito.ProductosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductosViewHolder productosViewHolder, final int i) {
        productosViewHolder.tvNomProducto.setText(carrito.get(i).getNomProducto());
        productosViewHolder.tvDescripcion.setText(carrito.get(i).getDescripcion());
        productosViewHolder.tvPrecio.setText(""+carrito.get(i).getPrecio());

    }

    @Override
    public int getItemCount() {
        return carrito.size();
    }

    public class ProductosViewHolder extends RecyclerView.ViewHolder {

        TextView tvNomProducto, tvDescripcion, tvPrecio;

        public ProductosViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNomProducto = itemView.findViewById(R.id.tvNombreProducto);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
        }
    }
}
