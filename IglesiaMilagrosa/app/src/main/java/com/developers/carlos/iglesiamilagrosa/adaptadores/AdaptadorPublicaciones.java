package com.developers.carlos.iglesiamilagrosa.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.developers.carlos.iglesiamilagrosa.R;
import com.developers.carlos.iglesiamilagrosa.modelos.Publicacion;

import java.util.List;

/**
 * Created by carlos on 09/09/16.
 */
public class AdaptadorPublicaciones extends RecyclerView.Adapter<AdaptadorPublicaciones.ViewHolder> {


    private final List<Publicacion> items;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView titulo;
        public TextView descripcion;
        public TextView fecha;
        public ImageView imagen;
        public ImageView favorito;


        public ViewHolder(View v) {
            super(v);

            titulo = (TextView) v.findViewById(R.id.titulo2);
            descripcion = (TextView) v.findViewById(R.id.descripcion2);
            fecha = (TextView) v.findViewById(R.id.fecha2);
            imagen = (ImageView) v.findViewById(R.id.imagen2);
            favorito = (ImageView) v.findViewById(R.id.favorito2);
        }
    }


    public AdaptadorPublicaciones(List<Publicacion> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_publicacion2, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Publicacion item = items.get(i);

        Glide.with(viewHolder.itemView.getContext())
                .load(item.getImagen())
                .centerCrop()
                .into(viewHolder.imagen);
        viewHolder.titulo.setText(item.getTitulo());
        viewHolder.fecha.setText(item.getFecha());
        viewHolder.descripcion.setText(item.getDescripcion());
        if(item.isFavorito()){
            viewHolder.favorito.setImageResource(R.drawable.favorito);
        }
    }


}
