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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        nombre=findViewById(R.id.textViewNombre);
        puntuacion=findViewById(R.id.ratingBar);
        Bundle extras=getIntent().getExtras();
        String nombre1=extras.getString("position");
        nombre.setText(nombre1);
        puntuacion.setRating(2);
    }
}