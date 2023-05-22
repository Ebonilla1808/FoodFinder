package sv.edu.utec.foodfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import sv.edu.utec.foodfinder.datos.Usuarios;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    TextView btnCrear;
    EditText edtUser, edtPass;
    Usuarios usuarios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = findViewById(R.id.btnLogin);
        btnCrear = findViewById(R.id.tvRegistrer);
        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPss);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usuario = edtUser.getText().toString();
                String password = edtPass.getText().toString();
                usuarios = new Usuarios(getApplicationContext());
                if (usuarios.iniciarSesion(usuario, password)){
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    Toast.makeText(getApplicationContext(), "Bienvenido", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Usuario y/o contraseña incorrectos", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CreateUserActivity.class));
            }
        });
    }
}