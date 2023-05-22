package sv.edu.utec.foodfinder.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import sv.edu.utec.foodfinder.R;
import sv.edu.utec.foodfinder.ViewModel.RestaurantesViewModel;

public class ListRestaurantesAdapter extends RecyclerView.Adapter<ListRestaurantesAdapter.RestaurantesViewHolder> {



    ArrayList<RestaurantesViewModel> listaRestaurantes;
    public ListRestaurantesAdapter(ArrayList<RestaurantesViewModel> listaRestaurantes) {
        this.listaRestaurantes = listaRestaurantes;
    }

    @NonNull
    @Override
    public ListRestaurantesAdapter.RestaurantesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista,null,false);
        return new RestaurantesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantesViewHolder holder, int position) {
        holder.viewNombre.setText(listaRestaurantes.get(position).getNombreRestaurante());
        holder.viewHorario.setText(listaRestaurantes.get(position).getHorario());
        holder.viewEspecialidad.setText(listaRestaurantes.get(position).getDescripcionEspecialidad());
        holder.viewMunicipio.setText(listaRestaurantes.get(position).getNombreMunicipio());
    }


    @Override
    public int getItemCount() {
        return listaRestaurantes.size();
    }

    public class RestaurantesViewHolder extends RecyclerView.ViewHolder {
        TextView viewNombre,viewHorario,viewEspecialidad, viewMunicipio;
        public RestaurantesViewHolder(@NonNull View itemView) {
            super(itemView);
            viewNombre=itemView.findViewById(R.id.tvNombre);
            viewHorario=itemView.findViewById(R.id.tvHorario);
            viewEspecialidad=itemView.findViewById(R.id.tvEspecialidad);
            viewMunicipio=itemView.findViewById(R.id.tvMunicipio);
        }
    }
}
