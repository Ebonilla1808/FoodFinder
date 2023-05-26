package sv.edu.utec.foodfinder.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import sv.edu.utec.foodfinder.R;
import sv.edu.utec.foodfinder.entidades.EntRestauranteCategoria;

public class ListUbicacionesAdapter
        extends  RecyclerView.Adapter<ListUbicacionesAdapter.RestaurantesViewHolder>
        implements View.OnClickListener{

    private ArrayList<EntRestauranteCategoria> ubicacionesList;
    private ArrayList<EntRestauranteCategoria> ubicacionesListOriginal;
    private View.OnClickListener listener;

    public ListUbicacionesAdapter(ArrayList<EntRestauranteCategoria> ubicacionesList) {
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

    }

    @Override
    public int getItemCount() {
        return ubicacionesList.size();
    }

    public class RestaurantesViewHolder extends RecyclerView.ViewHolder {

        TextView viewUbicacion, viewContacto, viewWebSite;
        public RestaurantesViewHolder(@NonNull View itemView) {
            super(itemView);
            viewUbicacion = itemView.findViewById(R.id.tvUbicacion);
            viewContacto = itemView.findViewById(R.id.tvContacto);
            viewWebSite = itemView.findViewById(R.id.tvSitioWeb);
        }
    }
}
