package com.moviles.api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.moviles.api.modelos.Pokemon;
import com.moviles.api.modelos.pokemonResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Retrofit retrofit;
    private static final String BASEURL = "https://pokeapi.co/api/v2/";
    private pokemonListAdapter pokemonAdapter;
    private RecyclerView reciclador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reciclador = findViewById(R.id.recicladorPokemon);
        pokemonAdapter = new pokemonListAdapter(this);
        reciclador.setAdapter(pokemonAdapter);
        GridLayoutManager grid = new GridLayoutManager(this,3);
        reciclador.setLayoutManager(grid);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        obtenerDatosPokemon();
    }

    private void obtenerDatosPokemon(){
        APIService servicio = retrofit.create(APIService.class);
        Call<pokemonResponse> respuesta = servicio.obtenerListaPokemon();

        respuesta.enqueue(new Callback<pokemonResponse>() {
            @Override
            public void onResponse(Call<pokemonResponse> call, Response<pokemonResponse> response) {
                if(response.isSuccessful()){
                    pokemonResponse respuestaApi = response.body();
                    ArrayList<Pokemon> listaPokemon = respuestaApi.getresults();
                    for (int i =0; i<listaPokemon.size();i++){
                        //les queda como tarea asignarlo a un adapter y mostralos en pantalla
                        Pokemon pokemon = listaPokemon.get(i);
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Error"+response.errorBody(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<pokemonResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error consulta", Toast.LENGTH_SHORT).show();
            }
        });
    }
}