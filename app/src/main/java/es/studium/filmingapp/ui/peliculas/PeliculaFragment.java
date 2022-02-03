package es.studium.filmingapp.ui.peliculas;

import android.content.Context;
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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import es.studium.filmingapp.Caratula;
import es.studium.filmingapp.Pelicula;
import es.studium.filmingapp.PeliculaAdapter;
import es.studium.filmingapp.R;
import es.studium.filmingapp.RecyclerViewOnItemClickListener;

public class PeliculaFragment extends Fragment {
    private PeliculaViewModel mViewModel;
    public static PeliculaFragment newInstance() {
        return new PeliculaFragment();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.pelicula_fragment, container, false);
        metodoPeliculas(view);
        return view;

    }
    private void metodoPeliculas(View Vista) {
        // Inicializar Peliculas
        List<Pelicula> items = new ArrayList<Pelicula>();

        items.add(new Pelicula(R.drawable.caballero, "El Caballero Oscuro"));
        items.add(new Pelicula(R.drawable.comunidad, "La Comunidad del Anillo"));
        items.add(new Pelicula(R.drawable.truco, "El Truco Final"));
        items.add(new Pelicula(R.drawable.spiderman, "Spiderman"));
        items.add(new Pelicula(R.drawable.seven, "Seven"));


        PeliculaAdapter peliculaAdapter = new PeliculaAdapter(items, getContext(), new RecyclerViewOnItemClickListener() {
            @Override
            public void onClick(View view, int position) {
                int idPelicula = items.get(position).getImagen();
                enviar(idPelicula);
            }
        });
        RecyclerView recyclerView = Vista.findViewById(R.id.myRecycleViewPeliculas);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(peliculaAdapter);


}

    private void enviar(int Codigo) {

        Intent intent =new Intent(getContext(),Caratula.class);
        intent.putExtra("position",Codigo);
        startActivity(intent);


    }
}