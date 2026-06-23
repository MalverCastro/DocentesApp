package com.example.docentesapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DocenteAdapter extends RecyclerView.Adapter<DocenteAdapter.ViewHolder> {

    private List<Docente> listaDocentes;

    public DocenteAdapter(List<Docente> listaDocentes) {
        this.listaDocentes = listaDocentes;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtNombre;
        TextView txtCorreo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtCorreo = itemView.findViewById(R.id.txtCorreo);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View vista = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_docente, parent, false);

        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Docente docente = listaDocentes.get(position);

        holder.txtNombre.setText(
                docente.getNombre() + " " + docente.getApellidos());

        holder.txtCorreo.setText(
                docente.getEmail());
    }

    @Override
    public int getItemCount() {
        return listaDocentes.size();
    }
}