package es.studium.filmingapp.ui.series;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


import es.studium.filmingapp.Caratula;
import es.studium.filmingapp.Pelicula;
import es.studium.filmingapp.PeliculaAdapter;
import es.studium.filmingapp.R;
import es.studium.filmingapp.RecyclerViewOnItemClickListener;
import es.studium.filmingapp.Serie;
import es.studium.filmingapp.SerieAdapter;

public class SeriesFragment extends Fragment {

    private SeriesViewModel mViewModel;

    public static SeriesFragment newInstance() {
        return new SeriesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.series_fragment, container, false);
        metodoSeries(view);
        return view;
    }

    private void metodoSeries(View Vista) {
        // Inicializar Series
        List<Serie> items = new ArrayList<Serie>();

        items.add(new Serie(R.drawable.breaking, "Breaking Bad"));
        items.add(new Serie(R.drawable.spart, "Spartacus"));
        items.add(new Serie(R.drawable.detective, "True Detective"));
        items.add(new Serie(R.drawable.holmes, "Sherlock Holmes"));
        items.add(new Serie(R.drawable.juegotronos, "Juego de Tronos"));

        SerieAdapter SerieAdapter = new SerieAdapter(items, getContext(), new RecyclerViewOnItemClickListener() {
            @Override
            public void onClick(View view, int position,int id) {
                int idSerie = items.get(position).getImagen();
                enviar(idSerie);
            }
        });
        RecyclerView recyclerView = Vista.findViewById(R.id.myRecicleViewSeries);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(SerieAdapter);


    }


    private void enviar(int Codigo) {

        Intent intent =new Intent(getContext(), Caratula.class);
        intent.putExtra("position",Codigo);
        startActivity(intent);


    }
}