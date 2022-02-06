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
import es.studium.filmingapp.Detalles;
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

        items.add(new Serie(R.drawable.breaking, "Breaking Bad","Vince Gilligan","Bryan Cranston","Un tranquilo profesor de química cambiadrasticamente su vida al enterarse que tiene cancer",4,"6"));
        items.add(new Serie(R.drawable.detective, "True Detective","Cary Fukunaga","Matthew McConaughey","Dos detectives muy diferentes investigan un crimen en los pantanos de Lousiana",4,"3"));
        items.add(new Serie(R.drawable.spart, "Spartacus","Steven S. DeKnight","Andy Whitfield","Narra la vida del célebre Espartaco desde su captura a manos de los romanos hasta su rebelión",4,"4"));
        items.add(new Serie(R.drawable.holmes, "Sherlock","Paul McGuigan","Benedict Cumberbatch"," Se trata de una actualización contemporánea de las aventuras del detective Sherlock Holmes",4,"4"));
        items.add(new Serie(R.drawable.juegotronos, "Juego de Tronos","David Benioff","Peter Dinklage","Relata las vivencias de un grupo de personajes de distintas casas nobiliarias para tener el control del Trono de Hierro",5,"8"));

        SerieAdapter SerieAdapter = new SerieAdapter(items, getContext(), new RecyclerViewOnItemClickListener() {
            @Override
            public void onClick(View view, int position,int id) {
                if (id == R.id.imagenSerie) {
                    int idSerie = items.get(position).getImagen();
                    enviarCaratula(idSerie);
                }    else{
                    String nombreSerie = items.get(position).getNombre();
                    String directorSerie=items.get(position).getDirector();
                    String actorSerie=items.get(position).getActor();
                    String sinopsisSerie=items.get(position).getSinopsis();
                    int puntuacionSerie=items.get(position).getPuntuacion();
                    String temporadasSeries=items.get(position).getTemporadas();



                    enviarDetalles(nombreSerie,directorSerie,actorSerie,sinopsisSerie,puntuacionSerie,temporadasSeries);
                }
            }
        });
        RecyclerView recyclerView = Vista.findViewById(R.id.myRecicleViewSeries);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(SerieAdapter);


    }

    private void enviarDetalles(String nombreSerie, String directorSerie, String actorSerie, String sinopsisSerie, int puntuacionSerie,String temporadasSerie) {
        Intent intent =new Intent(getContext(), Detalles.class);
        intent.putExtra("nombre",nombreSerie);
        intent.putExtra("director",directorSerie);
        intent.putExtra("actor",actorSerie);
        intent.putExtra("sinopsis",sinopsisSerie);
        intent.putExtra("puntuacion",puntuacionSerie);
        intent.putExtra("temporadas",temporadasSerie);
        boolean invisible=true;
        intent.putExtra("etiqueta",invisible);

        startActivity(intent);
    }


    private void enviarCaratula(int Codigo) {

        Intent intent =new Intent(getContext(), Caratula.class);
        intent.putExtra("position",Codigo);
        startActivity(intent);


    }
}