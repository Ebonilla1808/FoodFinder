package sv.edu.utec.foodfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import sv.edu.utec.foodfinder.adaptadores.ListRestauranteAdapter;
import sv.edu.utec.foodfinder.adaptadores.ListUbicacionesAdapter;
import sv.edu.utec.foodfinder.datos.Restaurantes;
import sv.edu.utec.foodfinder.entidades.EntRestauranteCategoria;

public class RestauranteMainActivity extends AppCompatActivity {


    TextView txtNombreRes;
    String nombreRestaurante, nombreMunicipio;
    RecyclerView rcwListUbicaciones;

    Restaurantes dbRestaurantes;
    ArrayList<EntRestauranteCategoria> AlistRestaurantes;
    ListUbicacionesAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante_main);
        txtNombreRes = findViewById(R.id.txtNombreRes);
        rcwListUbicaciones = findViewById(R.id.rvwListaUbicaciones);
        rcwListUbicaciones.setLayoutManager(new LinearLayoutManager(this));

        nombreRestaurante = getIntent().getStringExtra("nombreRestaurante");
        nombreMunicipio = getIntent().getStringExtra("nombreMunicipio");
        dbRestaurantes= new Restaurantes(getApplicationContext());
        AlistRestaurantes=new ArrayList<>();
        AlistRestaurantes = dbRestaurantes.obtenerRestauranteNombre(nombreRestaurante, nombreMunicipio);

        adapter =new ListUbicacionesAdapter(AlistRestaurantes);

        txtNombreRes.setText(nombreRestaurante);
        rcwListUbicaciones.setAdapter(adapter);


    }
}