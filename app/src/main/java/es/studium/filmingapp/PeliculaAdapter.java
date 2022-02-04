package es.studium.filmingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.PeliculaViewHolder> {
    private List<Pelicula> items;
    private LayoutInflater mInflater;
    private final Context context;
    private final RecyclerViewOnItemClickListener recyclerViewOnItemClickListener;


    public PeliculaAdapter(List<Pelicula> items, Context context,RecyclerViewOnItemClickListener recyclerViewOnItemClickListener) {
        this.mInflater=LayoutInflater.from(context);
        this.context=context;
        this.items = items;
        this.recyclerViewOnItemClickListener= recyclerViewOnItemClickListener;

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public PeliculaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.pelicula_card,null);
        return new PeliculaAdapter.PeliculaViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final PeliculaAdapter.PeliculaViewHolder holder,final int position) {
        holder.Datos(items.get(position));

    }


    public class PeliculaViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView imagenPelicula;
        public TextView nombrePelicula;


        public PeliculaViewHolder(View v) {
            super(v);
            imagenPelicula = (ImageView) v.findViewById(R.id.imagenPelicula);
            nombrePelicula = (TextView) v.findViewById(R.id.nombrePelicula);

        }

        void Datos (final Pelicula item)
        {
            imagenPelicula.setImageResource(item.getImagen());
            nombrePelicula.setText(item.getNombre());
            imagenPelicula.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerViewOnItemClickListener.onClick(imagenPelicula,getAdapterPosition(),imagenPelicula.getId());
                }
            });
            nombrePelicula.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerViewOnItemClickListener.onClick(nombrePelicula,getAdapterPosition(),nombrePelicula.getId());
                }
            });
        }
    }
}
