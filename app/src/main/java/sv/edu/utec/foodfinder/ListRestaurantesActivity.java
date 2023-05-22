package sv.edu.utec.foodfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.util.ArrayList;

import sv.edu.utec.foodfinder.ViewModel.RestaurantesViewModel;
import sv.edu.utec.foodfinder.adaptadores.ListRestaurantesAdapter;
import sv.edu.utec.foodfinder.datos.Restaurantes;

public class ListRestaurantesActivity extends AppCompatActivity {
    RecyclerView listRestaurantes;
    ArrayList<RestaurantesViewModel> AlistRestaurantes;
  //  Context context;
     int idCategoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_restaurantes);
        idCategoria = getIntent().getIntExtra("idCategoria", 0);
        listRestaurantes = findViewById(R.id.rvwListaRestaurantes);

        if(idCategoria!=0){
            listRestaurantes.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            Restaurantes dbRestaurantes = new Restaurantes(getApplicationContext());
            AlistRestaurantes=new ArrayList<>();

            ListRestaurantesAdapter adapter=new ListRestaurantesAdapter(dbRestaurantes.obtenerListaRestaurantes(idCategoria));
            listRestaurantes.setAdapter(adapter);
        }
    }
}