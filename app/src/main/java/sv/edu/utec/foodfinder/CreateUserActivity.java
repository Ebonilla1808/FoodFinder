package sv.edu.utec.foodfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import sv.edu.utec.foodfinder.datos.Usuarios;

public class CreateUserActivity extends AppCompatActivity {

    Button btnRegistro;
    EditText etNombres, etApellidos, etCorreo, etTelefono, etUsuario, etContraseña, etConfirmPass;

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
                    // Insertar el nuevo usuario en la base de datos
                    long resultado = usuarios.insertUsuario(nombres, apellidos, correo, telefono, usuario, contrasenia, tipoUsuario);

                    if (resultado != 0) {
                        // Registro exitoso
                        Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_LONG).show();

                        // Aquí puedes realizar cualquier acción adicional después del registro exitoso, como redirigir a otra pantalla, mostrar un diálogo, etc.
                    } else {
                        // Error en el registro
                        Toast.makeText(getApplicationContext(), "Error en el registro", Toast.LENGTH_LONG).show();
                    }
                }else{
                    // Error en el registro
                    Toast.makeText(getApplicationContext(), "Las contraseñas deben ser iguales", Toast.LENGTH_LONG).show();

                }
            }
        });
    }


}
