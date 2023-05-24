package sv.edu.utec.foodfinder.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import sv.edu.utec.foodfinder.R;
import sv.edu.utec.foodfinder.entidades.EntRestauranteCategoria;

public class ListRestauranteAdapter extends  RecyclerView.Adapter<ListRestauranteAdapter.RestaurantesViewHolder> {
    private ArrayList<EntRestauranteCategoria> restaurantesList;
    private ArrayList<EntRestauranteCategoria> restaurantesListOriginal;

    public ListRestauranteAdapter(ArrayList<EntRestauranteCategoria> restaurantesList) {
        this.restaurantesList = restaurantesList;
        restaurantesListOriginal = new ArrayList<>();
        restaurantesListOriginal.addAll(restaurantesList);
    }

    @NonNull
    @Override
    public RestaurantesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        try {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_restaurante, null, false);
            return new RestaurantesViewHolder(view);
        }
        catch (Exception ex){
            System.out.println(ex);
            return  null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RestaurantesViewHolder holder, int position) {
        EntRestauranteCategoria restaurante = restaurantesList.get(position);

        // Configurar los datos del restaurante en los elementos de la vista
        holder.tvNombre.setText(restaurante.getNombreRestaurante());
        holder.tvHorario.setText("Horario de atención: " + restaurante.getHorario());
        holder.tvEspecialidad.setText("Platillo especial: "+ restaurante.getDescripcionEspecialidad());
        holder.tvMunicipio.setText(restaurante.getNombreMunicipio().toUpperCase());

        // Mostrar el logo "ff_logo_light" en el ImageView
        holder.imgLogo.setImageResource(R.drawable.ff_logo_light);
    }

    public void filtrado(final String txt) {
        int longitud = txt.length();
        if (longitud == 0) {
            restaurantesList.clear();
            restaurantesList.addAll(restaurantesListOriginal);
        } else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                List<EntRestauranteCategoria> collecion = restaurantesList.stream()
                        .filter(i -> (i.getNombreRestaurante().toLowerCase().contains(txt.toLowerCase())
                                        || i.getHorario().toLowerCase().contains(txt.toLowerCase())
                                        || i.getDescripcionEspecialidad().toLowerCase().contains(txt.toLowerCase())
                                        || i.getNombreMunicipio().toLowerCase().contains(txt.toLowerCase())
                                    )
                        )
                        .collect(Collectors.toList());
                restaurantesList.clear();
                restaurantesList.addAll(collecion);
            } else {
                for (EntRestauranteCategoria c : restaurantesListOriginal) {
                    if (c.getNombreRestaurante().toLowerCase().contains(txt.toLowerCase())) {
                        restaurantesList.add(c);
                    }
                    if (c.getHorario().toLowerCase().contains(txt.toLowerCase())) {
                        restaurantesList.add(c);
                    }
                    if (c.getNombreMunicipio().toLowerCase().contains(txt.toLowerCase())) {
                        restaurantesList.add(c);
                    }
                    if (c.getDescripcionEspecialidad().toLowerCase().contains(txt.toLowerCase())) {
                        restaurantesList.add(c);
                    }
                }
            }
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return restaurantesList.size();
    }

    public class RestaurantesViewHolder extends RecyclerView.ViewHolder {
        ImageView imgLogo;
        TextView tvNombre;
        TextView tvHorario;
        TextView tvEspecialidad;
        TextView tvMunicipio;

        public RestaurantesViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(R.id.imgLogoRes);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvHorario = itemView.findViewById(R.id.tvHorario);
            tvEspecialidad = itemView.findViewById(R.id.tvEspecialidad);
            tvMunicipio = itemView.findViewById(R.id.tvMunicipio);
        }
    }
}
