package es.studium.filmingapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class SerieAdapter extends RecyclerView.Adapter<SerieAdapter.SerieViewHolder> {
    private List<Serie> items;
    private LayoutInflater mInflater;
    private final Context context;
    private final RecyclerViewOnItemClickListener recyclerViewOnItemClickListener;

    public SerieAdapter(List<Serie> items, Context context, RecyclerViewOnItemClickListener recyclerViewOnItemClickListener) {
        this.mInflater=LayoutInflater.from(context);
        this.context=context;
        this.items = items;
        this.recyclerViewOnItemClickListener=recyclerViewOnItemClickListener;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public SerieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.serie_card,null);
        return new SerieAdapter.SerieViewHolder(view);

    }



    @Override
    public void onBindViewHolder(final SerieAdapter.SerieViewHolder holder,final int position) {
        holder.Datos(items.get(position));
    }


    public class SerieViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView imagenSerie;
        public TextView nombreSerie;


        public SerieViewHolder(View v) {
            super(v);
            imagenSerie = (ImageView) v.findViewById(R.id.imagenSerie);
            nombreSerie = (TextView) v.findViewById(R.id.nombreSerie);

        }

        void Datos (final Serie item)
        {
            imagenSerie.setImageResource(item.getImagen());
            nombreSerie.setText(item.getNombre());
            imagenSerie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerViewOnItemClickListener.onClick(imagenSerie,getAdapterPosition(),imagenSerie.getId());
                }
            });
            nombreSerie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    recyclerViewOnItemClickListener.onClick(nombreSerie,getAdapterPosition(),nombreSerie.getId());
                }
            });
        }
    }
}