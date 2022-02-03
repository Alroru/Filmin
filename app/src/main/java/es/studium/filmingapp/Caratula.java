package es.studium.filmingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import es.studium.filmingapp.ui.peliculas.PeliculaFragment;

public class Caratula extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caratula);


        imageView=findViewById(R.id.imageViewCaratula);
        Bundle extras=getIntent().getExtras();
        int imagen=extras.getInt("position");
        imageView.setImageResource(imagen);
    }
}