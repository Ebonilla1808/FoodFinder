package sv.edu.utec.foodfinder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {

    ImageView btnCafe, btnTipico, btnMarisco, btnRapida, btnBuffets, btnHeladerias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnCafe = findViewById(R.id.image_coffe);
        btnTipico = findViewById(R.id.image_tipico);
        btnMarisco = findViewById(R.id.image_mariscos);
        btnRapida = findViewById(R.id.image_fast);
        btnBuffets = findViewById(R.id.image_buffets);
        btnHeladerias = findViewById(R.id.image_heladerias);

        btnCafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListRestaurantesActivity.class);
                intent.putExtra("idCategoria", 1);
                startActivity(intent);
            }
        });
        btnTipico.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListRestaurantesActivity.class);
                intent.putExtra("idCategoria", 2);
                startActivity(intent);
            }
        });
        btnMarisco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListRestaurantesActivity.class);
                intent.putExtra("idCategoria", 3);
                startActivity(intent);
            }
        });
        btnRapida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListRestaurantesActivity.class);
                intent.putExtra("idCategoria", 4);
                startActivity(intent);
            }
        });
        btnBuffets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListRestaurantesActivity.class);
                intent.putExtra("idCategoria", 5);
                startActivity(intent);
            }
        });
        btnHeladerias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListRestaurantesActivity.class);
                intent.putExtra("idCategoria", 6);
                startActivity(intent);
            }
        });
    }
}