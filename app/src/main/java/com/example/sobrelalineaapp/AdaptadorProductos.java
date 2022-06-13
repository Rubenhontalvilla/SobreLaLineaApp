package com.example.sobrelalineaapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AdaptadorProductos extends RecyclerView.Adapter<AdaptadorProductos.ProductosViewHolder> {

    Context context;
    TextView tvCantProductos;
    Button btnVerCarro;
    List<Producto> listaProductos;
    List<Producto> carritoCompra;

    public AdaptadorProductos(Context context, TextView tvCantProductos, Button btnVerCarro, List<Producto> listaProductos, List<Producto> carritoCompra) {
        this.context = context;
        this.tvCantProductos = tvCantProductos;
        this.btnVerCarro = btnVerCarro;
        this.listaProductos = listaProductos;
        this.carritoCompra = carritoCompra;
    }

    @NonNull
    @Override
    public ProductosViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_rv_productos, null, false);
        return new AdaptadorProductos.ProductosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductosViewHolder productosViewHolder, @SuppressLint("RecyclerView") final int i) {
        productosViewHolder.tvNomProducto.setText(listaProductos.get(i).getNomProducto());
        productosViewHolder.tvDescripcion.setText(listaProductos.get(i).getDescripcion());
        productosViewHolder.tvPrecio.setText(""+listaProductos.get(i).getPrecio());

        productosViewHolder.cbCarrito.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(productosViewHolder.cbCarrito.isChecked() == true) {
                    tvCantProductos.setText(""+(Integer.parseInt(tvCantProductos.getText().toString().trim()) + 1));
                    carritoCompra.add(listaProductos.get(i));
                } else if(productosViewHolder.cbCarrito.isChecked() == false) {
                    tvCantProductos.setText(""+(Integer.parseInt(tvCantProductos.getText().toString().trim()) - 1));
                    carritoCompra.remove(listaProductos.get(i));
                }
            }
        });

        btnVerCarro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Carrito.class);
                intent.putExtra("CarritoCompras", (Serializable) carritoCompra);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaProductos.size();
    }

    public class ProductosViewHolder extends RecyclerView.ViewHolder {

        TextView tvNomProducto, tvDescripcion, tvPrecio;
        CheckBox cbCarrito;

        public ProductosViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNomProducto = itemView.findViewById(R.id.tvNombreProducto);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
            tvPrecio = itemView.findViewById(R.id.tvPrecio);
            cbCarrito = itemView.findViewById(R.id.cbCarrito);
        }
    }
}
