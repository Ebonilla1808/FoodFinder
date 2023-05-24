package sv.edu.utec.foodfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import sv.edu.utec.foodfinder.adaptadores.ListRestauranteAdapter;
import sv.edu.utec.foodfinder.datos.Restaurantes;
import sv.edu.utec.foodfinder.entidades.EntRestauranteCategoria;

public class ListRestaurantesActivity extends AppCompatActivity {
    RecyclerView rwlistRestaurantes;
    ArrayList<EntRestauranteCategoria> AlistRestaurantes;
    //  Context context;
    int idCategoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_restaurantes);

        //Definimos el Recicleiew
        rwlistRestaurantes = findViewById(R.id.rvwListaRestaurantes);

        rwlistRestaurantes.setLayoutManager(new LinearLayoutManager(this));

        //Para recibir la categoria del otro activity
        idCategoria = getIntent().getIntExtra("idCategoria", 0);



        if(idCategoria!=0){
            Restaurantes dbRestaurantes = new Restaurantes(getApplicationContext());
            //Obtenemos la consulta
            AlistRestaurantes=new ArrayList<>();

            AlistRestaurantes = dbRestaurantes.obtenerListaRestaurantes(idCategoria);

            ListRestauranteAdapter adapter=new ListRestauranteAdapter(AlistRestaurantes);


            rwlistRestaurantes.setAdapter(adapter);
        }
    }
}