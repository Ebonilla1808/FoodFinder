package sv.edu.utec.foodfinder.adaptadores;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.net.URI;
import java.util.ArrayList;

import sv.edu.utec.foodfinder.R;
import sv.edu.utec.foodfinder.entidades.EntRestauranteCategoria;

public class ListUbicacionesAdapter
        extends  RecyclerView.Adapter<ListUbicacionesAdapter.RestaurantesViewHolder>
        implements View.OnClickListener{

    private ArrayList<EntRestauranteCategoria> ubicacionesList;
    private ArrayList<EntRestauranteCategoria> ubicacionesListOriginal;
    private View.OnClickListener listener;

    Context context;

    public ListUbicacionesAdapter(ArrayList<EntRestauranteCategoria> ubicacionesList, Context context) {
        this.context = context;
        this.ubicacionesList = ubicacionesList;
        ubicacionesListOriginal = new ArrayList<>();
        ubicacionesListOriginal.addAll(ubicacionesList);
    }

    @Override
    public void onClick(View v) {

    }

    @NonNull
    @Override
    public ListUbicacionesAdapter.RestaurantesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        try {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_ubicaciones, null, false);

            view.setOnClickListener(this);

            return new ListUbicacionesAdapter.RestaurantesViewHolder(view);
        }
        catch (Exception ex){
            System.out.println(ex);
            return  null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ListUbicacionesAdapter.RestaurantesViewHolder holder, int position) {
        EntRestauranteCategoria restaurante = ubicacionesList.get(position);

        // Configurar los datos del restaurante en los elementos de la vista
        holder.viewUbicacion.setText(restaurante.getUbicacion());
        holder.viewContacto.setText("Numero de telefono: " + restaurante.getContacto());
        holder.viewWebSite.setText("Sitio web: "+ restaurante.getSitioWeb());


        holder.imgSitioWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Uri link =  Uri.parse("https://"+restaurante.getSitioWeb());

                    Intent intent = new Intent(Intent.ACTION_VIEW, link);
                    context.startActivity(intent);

                }catch (Exception ex){
                    Toast.makeText(context, "No se encontró un navegador para abrir el sitio", Toast.LENGTH_LONG).show();

                }
            }
        });
        holder.imgLlamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+ restaurante.getContacto()));
                    context.startActivity(intent);
                }catch (Exception ex){
                    Toast.makeText(context, "No se encontró una app para realizar la llamada", Toast.LENGTH_LONG).show();

                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return ubicacionesList.size();
    }

    public class RestaurantesViewHolder extends RecyclerView.ViewHolder {

        TextView viewUbicacion, viewContacto, viewWebSite;
        ImageView imgSitioWeb, imgLlamar;
        public RestaurantesViewHolder(@NonNull View itemView) {
            super(itemView);
            viewUbicacion = itemView.findViewById(R.id.tvUbicacion);
            viewContacto = itemView.findViewById(R.id.tvContacto);
            viewWebSite = itemView.findViewById(R.id.tvSitioWeb);
            imgSitioWeb = itemView.findViewById(R.id.imgWebSite);
            imgLlamar = itemView.findViewById(R.id.imgLlamar);
        }
    }
}
