package logica.ficheros;

import java.io.*;
import logica.usuario.*;
import org.json.*;

public class GuardarDatos {

    public static void procesoGuardadoClientes() {
        Cliente cliente;
        GuardarDatos guardar= new GuardarDatos();
        for (Cliente usuarioCliente: ListaUsuariosClientes.getListaUsuariosClientes()) {
            if(!ListaUsuariosClientes.correoExisteEnJSON(usuarioCliente.getEmail())) {
                cliente= (Cliente) ListaUsuariosClientes.buscarUsuario(usuarioCliente.getEmail());
                cliente.llenarObjetoClienteJson(cliente);
                ListaUsuariosClientes.agregarUsuarioAListaJSON(cliente.getUsuarioJSON(), ListaUsuariosClientes.getListaUsuariosClientesJSON());}
        }
        guardar.agregarAJson(ListaUsuariosClientes.getListaUsuariosClientesJSON());
    }

    public static void procesoGuardadoEmpresas() {
        Empresa empresa;
        GuardarDatos guardar= new GuardarDatos();
        for (Empresa usuarioEmpresa: ListaUsuariosEmpresas.getListaUsuariosEmpresas()) {
            if(!ListaUsuariosEmpresas.correoExisteEnJSON(usuarioEmpresa.getEmail())) {
                empresa= (Empresa) ListaUsuariosEmpresas.buscarUsuario(usuarioEmpresa.getEmail());
                empresa.llenarObjetoEmpresaJson(empresa);
                ListaUsuariosEmpresas.agregarUsuarioAListaJSON(empresa.getUsuarioJSON(),ListaUsuariosEmpresas.getListaUsuariosEmpresasJSON());}
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
