package logica.ficheros;

import java.io.*;
import logica.usuario.*;
import org.json.*;

public class GuardarDatos {

    public static void procesoGuardadoClientes() {
        Usuario user;
        GuardarDatos guardar= new GuardarDatos();
        for (Usuario usuario: ListaUsuariosClientes.getListaUsuariosClientes()) {
            if(!ListaUsuariosClientes.correoExisteEnJSON(usuario.getEmail())) {
                user=ListaUsuariosClientes.buscarUsuario(usuario.getEmail());
                user.llenarObjetoJson(user);
                ListaUsuariosClientes.agregarUsuarioAListaJSON(user.getUsuarioJSON(), ListaUsuariosClientes.getListaUsuariosClientesJSON());}
        }
        guardar.agregarAJson(ListaUsuariosClientes.getListaUsuariosClientesJSON());
    }

    public static void procesoGuardadoEmpresas() {
        Usuario user;
        GuardarDatos guardar= new GuardarDatos();
        for (Usuario usuario: ListaUsuariosEmpresas.getListaUsuariosEmpresas()) {
            if(!ListaUsuariosEmpresas.correoExisteEnJSON(usuario.getEmail())) {
                user=ListaUsuariosEmpresas.buscarUsuario(usuario.getEmail());
                user.llenarObjetoJson(user);
                ListaUsuariosEmpresas.agregarUsuarioAListaJSON(user.getUsuarioJSON(),ListaUsuariosEmpresas.getListaUsuariosEmpresasJSON());}
        }
        guardar.agregarAJson(ListaUsuariosEmpresas.getListaUsuariosEmpresasJSON());
    }

    public void agregarAJson(JSONArray ListaJson) {
        try(FileWriter archivo= new FileWriter ("files/usuarios.json")){
            BufferedWriter buffer= new BufferedWriter (archivo);
            buffer.write(ListaJson.toString());
            buffer.close();
        }
        catch (IOException e){
            System.out.println("Problemas al ingresar un dato al archivo");
        }
    }

}
