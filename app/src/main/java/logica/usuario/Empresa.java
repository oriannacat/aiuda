package logica.usuario;

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

   /* public void llenarObjetoEmpresaJson(Empresa empresa) {
        Encrypt encriptar=new Encrypt();
        for (MonedasUsuario cripto: listaMonedas) {
            listaMonedasJSON.add(cripto.getMonedaJSON());
        }
        //usuarioJSON.put("listaMonedas", listaMonedasJSON);
        usuario.setPassword(encriptar.getAES(usuario.getPassword()));
        usuarioJSON.put("contraseña",usuario.getPassword());
        usuarioJSON.put("correo",usuario.getEmail());
        if (usuario.obtenerDireccionIP()!=null) {
            usuarioJSON.put("direccionIP",usuario.obtenerDireccionIP());
        }
    }*/

}
