package edu.example.pruebadosproyectoandres;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import logica.ficheros.ListaUsuariosClientes;
import logica.ficheros.ListaUsuariosEmpresas;
import logica.usuario.Cliente;
import logica.usuario.Empresa;
import logica.usuario.Bloqueo;
import logica.usuario.Usuario;

public class MainActivity extends AppCompatActivity {

    public void buttonPress(View view){
        Intent newIntent= new Intent(this, InterfazRegistro.class);
        startActivity(newIntent);
    }

    public void btnIniciarSesion(View v){
        //este carga el menú del cliente (buscar productoo)

        EditText currPassword = findViewById(R.id.editTextTextPassword);
        EditText currCorreo = findViewById(R.id.editTextTextEmailAddress);

        String correoString = currCorreo.getText().toString();
        Cliente currCliente = ListaUsuariosClientes.buscarUsuarioClientes(correoString);
        Empresa currEmpresa = ListaUsuariosEmpresas.buscarUsuarioEmpresa(correoString);

        if((currCliente !=null) && (currCliente.getBloqueo()==false)){
            int cont=0;
            if((currCliente != null) && (currCliente.getPassword().equals(currPassword.getText().toString()))){
                Toast.makeText(MainActivity.this, "Inicio de sesión exitoso!", Toast.LENGTH_SHORT).show();
                //start intent actividad jorge
            }
            else if((currCliente != null) && !(currCliente.getPassword().equals(currPassword.getText().toString()))){
                cont++;
                Toast.makeText(MainActivity.this, "Contraseña incorrecta, intentos restantes "+(3-cont), Toast.LENGTH_SHORT).show();
                if(cont==3){
                    Toast.makeText(MainActivity.this, "Usted supero el numero de intentos, intente nuevamente en 24h", Toast.LENGTH_SHORT).show();
                    currCliente.setBloqueo(true);
                    Bloqueo bloqueo= new Bloqueo();
                    currCliente.setBloqueo(bloqueo.Desbloqueo());/* AIUDAAAAAAAAA */
                }
            }
        }
        else if((currCliente !=null) && (currCliente.getBloqueo()==true)){
            Toast.makeText(MainActivity.this, "Usted supero el numero de intentos, intente nuevamente en 24h", Toast.LENGTH_SHORT).show();
        }
        else if((currEmpresa!=null) && (currEmpresa.getBloqueo()==false)){
            int cont=0;
            if(currEmpresa != null && currEmpresa.getPassword().equals(currPassword.getText().toString())){
                Toast.makeText(MainActivity.this, "Inicion de sesion exitoso", Toast.LENGTH_SHORT).show();
                //start intent actividad kat
            }
            else if((currEmpresa!=null) && !(currEmpresa.getPassword().equals(currPassword.getText().toString()))){
                cont++;
                Toast.makeText(MainActivity.this, "Contraseña incorrecta, intentos restantes "+(3-cont), Toast.LENGTH_SHORT).show();
                if(cont==3){
                    Toast.makeText(MainActivity.this, "Usted supero el numero de intentos, intente nuevamente en 24h", Toast.LENGTH_SHORT).show();
                    currEmpresa.setBloqueo(true);
                    Bloqueo bloqueo= new Bloqueo();
                    currEmpresa.setBloqueo(bloqueo.Desbloqueo());/////AIUDAAAAAA
                }
            }
        }
        else if((currCliente !=null) && (currCliente.getBloqueo()==true)){
            Toast.makeText(MainActivity.this, "Usted supero el numero de intentos, intente nuevamente en 24h", Toast.LENGTH_SHORT).show();
        }
        else{
            //logica que deberia ir aqui
            //currPassword.setText("");
            //currCorreo.setText("");
            //Display toast message con un mensaje prompting the user to enter los datos nuevamente
            Intent newIntent = new Intent(this, MainActivityCliente.class);
            getSupportActionBar().setTitle("Busqueda de Productos");
            //o, alternativamente, se carga el menú de la empresa (crear producto)
            //Intent newIntent=new Intent(this,MainActivityEmpresa.class);
            //getSupportActionBar().setTitle("Publicar Producto");
            startActivity(newIntent);
        }/////else si el usuario tiene bloqueo
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListaUsuariosClientes listaC= new ListaUsuariosClientes();
        ListaUsuariosEmpresas listaE= new ListaUsuariosEmpresas();
        ListaUsuariosClientes.llenarListaEstaticaClientes();
        ListaUsuariosEmpresas.llenarListaEstaticaEmpresas();

        getSupportActionBar().hide();

        EditText txtCorreo =findViewById(R.id.editTextTextEmailAddress);
        EditText txtPassword = findViewById(R.id.editTextTextPassword);

        txtPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String correo = txtCorreo.getText().toString();
                if(ListaUsuariosClientes.correoExisteEnClientesJSON(correo)){
                    Toast.makeText(MainActivity.this, "Correo Cliente registrado", Toast.LENGTH_LONG).show();
                    txtPassword.setFocusable(true);
                    txtPassword.setFocusedByDefault(true);
                    txtPassword.setFocusableInTouchMode(true);
                }
                else if(ListaUsuariosEmpresas.correoExisteEnEmpresasJSON(correo)){
                    Toast.makeText(MainActivity.this, "Correo Empresa registrado", Toast.LENGTH_LONG).show();
                    txtPassword.setFocusable(true);
                    txtPassword.setFocusedByDefault(true);
                    txtPassword.setFocusableInTouchMode(true);
                }
                else{
                    txtCorreo.setText("");
                    Toast.makeText(MainActivity.this, "Correo no está registrado", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
