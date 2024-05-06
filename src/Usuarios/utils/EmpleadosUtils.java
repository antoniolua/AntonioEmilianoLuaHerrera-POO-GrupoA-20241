package Usuarios.utils;
import utils.UsuarioEnSesion;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;

public interface EmpleadosUtils {
        // Define un formato para la fecha y hora
        static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss, dd-MM-yyyy");

        static void Entrada() {
            LocalDateTime horaEntrada = LocalDateTime.now(); // Hora actual
            String horaFormateada = horaEntrada.format(formatter); // Formatea la hora

            System.out.println("Empleado "
                    + UsuarioEnSesion.getInstancia().getUsuarioActual().getNombre()
                    + " checó entrada a las "
                    + horaFormateada); // Imprime la hora formateada
        }

        static void Salida() {
            LocalDateTime horaSalida = LocalDateTime.now(); // Hora actual
            String horaFormateada = horaSalida.format(formatter); // Formatea la hora

            System.out.println("Empleado "
                    + UsuarioEnSesion.getInstancia().getUsuarioActual().getNombre()
                    + " checó salida a las "
                    + horaFormateada); // Imprime la hora formateada}
    }
}
