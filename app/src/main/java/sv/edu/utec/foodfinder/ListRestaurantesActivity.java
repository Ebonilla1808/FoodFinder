package sv.edu.utec.foodfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ListRestaurantesActivity extends AppCompatActivity {

     int idCategoria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_restaurantes);
        idCategoria = getIntent().getIntExtra("idCategoria", 0);

        if(idCategoria!=0){

        }
    }
}