package es.studium.filmingapp.ui.peliculas;

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

        items.add(new Pelicula(R.drawable.caballero, "El Caballero Oscuro", "Christofer Nolan", "Cristian Bale", "Segunda parte de esta nueva triologia del hombre murcielago que pretende ser más realista que nunca", 5));
        items.add(new Pelicula(R.drawable.comunidad, "La Comunidad del Anillo", "Peter Jackson", "Elijah wood","El joven Frodo tendrá que salir de su querida Comarca en una aventura para salvar el mundo del mal", 5));
        items.add(new Pelicula(R.drawable.truco, "El Truco Final", "Chistofer Nolan", "Huck Jackman","En pleno siglo XIX, dos magos competiran por ver cual es el mejor", 4));
        items.add(new Pelicula(R.drawable.spiderman, "Spiderman", "Sam Raimi", "Tobey Maguire","Peter Parker recibe la picadura de una araña y se convertirá en el mejor superhéroe de Nueva York", 4));
        items.add(new Pelicula(R.drawable.seven, "Seven", "David Fincher", "Brad Pitt","Un veterano policia y su joven compañero investigan terroríficos crimenes relacionados con los pecados capitales", 4));


        PeliculaAdapter peliculaAdapter = new PeliculaAdapter(items, getContext(), new RecyclerViewOnItemClickListener() {
            @Override
            public void onClick(View view, int position,int id) {

                if(id==R.id.imagenPelicula) {
                    int idPelicula = items.get(position).getImagen();
                    enviarCaratula(idPelicula);
                }
                else {
                    String nombrePelicula = items.get(position).getNombre();
                    String directorPelicula = items.get(position).getDirector();
                    String actorPelicula = items.get(position).getActor();
                    String sinopsisPelicula = items.get(position).getSinopsis();
                    int puntuacionPelicula = items.get(position).getPuntuacion();



                    enviarDetalles(nombrePelicula, directorPelicula, actorPelicula, sinopsisPelicula, puntuacionPelicula);
                }
            }
        });
        RecyclerView recyclerView = Vista.findViewById(R.id.myRecycleViewPeliculas);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(peliculaAdapter);


}

    private void enviarDetalles(String nombrePelicula, String directorPelicula, String actorPelicula, String sinopsisPelicula, int puntuacionPelicula) {
        Intent intent =new Intent(getContext(), Detalles.class);
        intent.putExtra("nombre",nombrePelicula);
        intent.putExtra("director",directorPelicula);
        intent.putExtra("actor",actorPelicula);
        intent.putExtra("sinopsis",sinopsisPelicula);
        intent.putExtra("puntuacion",puntuacionPelicula);
        boolean invisible=false;
        intent.putExtra("etiqueta",invisible);

        startActivity(intent);
    }

    private void enviarCaratula(int Codigo) {

        Intent intent =new Intent(getContext(),Caratula.class);
        intent.putExtra("position",Codigo);
        startActivity(intent);


    }





}