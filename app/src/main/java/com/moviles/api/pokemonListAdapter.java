package com.moviles.api;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moviles.api.modelos.Pokemon;

import java.util.ArrayList;

public class pokemonListAdapter extends RecyclerView.Adapter<pokemonListAdapter.ViewHolder> {
    Context context;
    private ArrayList<Pokemon> datos;
    public pokemonListAdapter(Context contexto){
        this.context = contexto;
        datos = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View vista = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_pokemon,viewGroup);
        return new ViewHolder(vista);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Pokemon pokemon = datos.get(position);
        holder.nombrePokemon.setText(pokemon.getName());
        Glide.whit(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/back/"+pokemon.getNumber()+".png")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imagenPokemon);
    }

    public int getItemCount(){
        return datos.size();
    }

    public void adicionarListaPokemon(ArrayList<Pokemon> lista){
        datos.addAll(lista);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imagenPokemon;
        private TextView nombrePokemon;

        public ViewHolder(View vista){
            super(vista);
            imagenPokemon = vista.findViewById(R.id.fotoPokemon);
            nombrePokemon = vista.findViewById(R.id.nombrePokemon);
        }
    }
}
