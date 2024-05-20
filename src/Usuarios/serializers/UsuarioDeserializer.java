package Usuarios.serializers;

import Biblioteca.Biblioteca;
import Usuarios.Gerente;
import Usuarios.Usuario;
import Usuarios.models.UsuarioModel;
import Usuarios.utils.Rol;
import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class UsuarioDeserializer {

    /**
     * Deserialización de datos
     *
     * Se encarga de deserializar los datos de un JSON y convertirlos a un objecto en JAVA
     *
     * @throws FileNotFoundException Si el archivo no se encuentra en la ruta
     * @throws IOException Alguna excpeción de lectura
     * @throws JsonSyntaxException Si no es un archivo JSON válido
     * @throws JsonParseException GSON puede arrojarla si hay un problema al parsear el JSON
     * @throws Exception Otras excepciones
     */
    public static void deserialize() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("usuarios.json"));
            Gson gson = new Gson();
            UsuarioModel usuariosModel = gson.fromJson(reader, UsuarioModel.class);

            // Convertimos los trabajadores a una lista de usuarios para poder insertarlos en el HashMap
            ArrayList<Usuario> usuariosTrabajadores = new ArrayList<>(usuariosModel.getTrabajadors());

            // Convertimos los gerentes a una lista de usuarios para poder insertarlos en el HashMap
            ArrayList<Usuario> usuariosGerentes = new ArrayList<>(usuariosModel.getGerentes());


            // Convertimos los clientes a una lista de usuarios para poder insertarlos en el HashMap
            ArrayList<Usuario> usuariosClientes = new ArrayList<>(usuariosModel.getClientes());

            Biblioteca.usuarios.put(Rol.ClIENTE,usuariosClientes);
            Biblioteca.usuarios.put(Rol.TRABAJADOR,usuariosTrabajadores);
            Biblioteca.usuarios.put(Rol.GERENTE,usuariosGerentes);

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (JsonSyntaxException e) {
            System.out.println(e);
        } catch (JsonParseException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
