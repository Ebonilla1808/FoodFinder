package sv.edu.utec.foodfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.SearchView;

import java.util.ArrayList;

import sv.edu.utec.foodfinder.adaptadores.ListRestauranteAdapter;
import sv.edu.utec.foodfinder.datos.Restaurantes;
import sv.edu.utec.foodfinder.entidades.EntRestauranteCategoria;

public class ListRestaurantesActivity extends AppCompatActivity implements  SearchView.OnQueryTextListener{
    RecyclerView rwlistRestaurantes;
    ArrayList<EntRestauranteCategoria> AlistRestaurantes;
    ListRestauranteAdapter adapter;
    SearchView txtBuscar;
    //  Context context;
    int idCategoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_restaurantes);
        txtBuscar = findViewById(R.id.txtBusqueda);

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

            adapter =new ListRestauranteAdapter(AlistRestaurantes);


            rwlistRestaurantes.setAdapter(adapter);
        }

        txtBuscar.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String txt) {
        adapter.filtrado(txt);
        return false;
    }
}