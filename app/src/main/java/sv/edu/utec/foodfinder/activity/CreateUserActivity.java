package sv.edu.utec.foodfinder.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import sv.edu.utec.foodfinder.R;
import sv.edu.utec.foodfinder.datos.Usuarios;

public class CreateUserActivity extends AppCompatActivity {

    Button btnRegistro;
    EditText etNombres, etApellidos, etCorreo, etTelefono, etUsuario, etContraseña, etConfirmPass;

    TextView btnVoler;
    Usuarios usuarios;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_user);
        context = getApplicationContext();

        etNombres = findViewById(R.id.edtNombres);
        etApellidos = findViewById(R.id.edtApellidos);
        etCorreo = findViewById(R.id.edtCoreo);
        etTelefono = findViewById(R.id.edtTelefono);
        etUsuario = findViewById(R.id.edtUsuario);
        etContraseña = findViewById(R.id.edtPassword);
        etConfirmPass = findViewById(R.id.edtConfirmPassword);

        btnRegistro = findViewById(R.id.btnRegistrarUsuario);
        btnVoler = findViewById(R.id.tvCancelar);

        btnVoler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
            }
        });
        btnRegistro.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Obtener los valores ingresados por el usuario en los campos de registro
                String nombres = etNombres.getText().toString();
                String apellidos = etApellidos.getText().toString();
                String correo = etCorreo.getText().toString();
                String telefono = etTelefono.getText().toString();
                String usuario = etUsuario.getText().toString();
                String contrasenia = etContraseña.getText().toString();
                String confirmPass = etConfirmPass.getText().toString();
                String tipoUsuario = "Cliente";  // Opcional: Puedes definir el tipo de usuario aquí

                if (confirmPass.equals(contrasenia)) {
                    usuarios = new Usuarios(context);
                    if(nombres.isEmpty() || apellidos.isEmpty() || correo.isEmpty()
                        || telefono.isEmpty() || usuario.isEmpty() || contrasenia.isEmpty() || tipoUsuario.isEmpty()){

                        Toast.makeText(getApplicationContext(), "Complete todos los campos", Toast.LENGTH_LONG).show();
                    }else{
                        // Insertar el nuevo usuario en la base de datos
                        long resultado = usuarios.insertUsuario(nombres, apellidos, correo, telefono, usuario, contrasenia, tipoUsuario);

                        if (resultado != 0) {
                            // Registro exitoso
                            Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        } else {
                            // Error en el registro
                            Toast.makeText(getApplicationContext(), "Error en el registro", Toast.LENGTH_LONG).show();
                        }
                    }
                }else{
                    // Error en el registro
                    Toast.makeText(getApplicationContext(), "Las contraseñas deben ser iguales", Toast.LENGTH_LONG).show();

                }
            }
        });
    }


}
