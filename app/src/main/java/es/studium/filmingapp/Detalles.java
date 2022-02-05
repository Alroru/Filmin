package es.studium.filmingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

public class Detalles extends AppCompatActivity {
    TextView nombre;
    TextView director;
    TextView actor;
    TextView sinopsis;
    RatingBar puntuacion;
    TextView tituloTemporadas;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        nombre=findViewById(R.id.textViewNombre);
        director=findViewById(R.id.textViewDirector);
        actor=findViewById(R.id.textViewActor);
        sinopsis=findViewById(R.id.textViewSinopsis);
        puntuacion=findViewById(R.id.ratingBar);
        tituloTemporadas=findViewById(R.id.textViewTituloTemporadas);
        Bundle extras=getIntent().getExtras();
        String nombre1=extras.getString("nombre");
        String director1=extras.getString("director");
        String actor1=extras.getString("actor");
        String sinopsis1=extras.getString("sinopsis");
        int rating=extras.getInt("puntuacion");
        boolean invisible1=extras.getBoolean("etiqueta");
        nombre.setText(nombre1);
        director.setText(director1);
        actor.setText(actor1);
        sinopsis.setText(sinopsis1);
        puntuacion.setRating(rating);
        tituloTemporadas.setEnabled(invisible1);

    }
}