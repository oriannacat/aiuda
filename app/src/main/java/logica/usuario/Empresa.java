package logica.usuario;

import org.json.JSONException;

import java.util.ArrayList;
import logica.producto.Producto;

public class Empresa extends Usuario{

    private ArrayList<Producto> listaPublicaciones;

    public Empresa (){
    }

    public Empresa(String correo, String password) {
    }

    public Empresa(String password, String email, ArrayList<Producto> listaPublicaciones) {
        super(password, email);
        this.listaPublicaciones = listaPublicaciones;
    }
      public void llenarObjetoEmpresaJson(Empresa empresa) {
        Encrypt encriptar=new Encrypt();
        empresa.setPassword(encriptar.getAES(empresa.getPassword()));
          try {
              getUsuarioJSON().put("contraseña",empresa.getPassword());
              getUsuarioJSON().put("correo",empresa.getEmail());
              } catch (JSONException e) {
              System.out.println("Error al insertar datos en JSON de Empresas");
          }
    }

}
