import java.util.*;
import java.time.LocalDate;
import java.io.*;

public class ExceptionExamples {
    public static void main(String[] args) {
        // ArithmeticException:
        // se lanza cuando se produce un error aritmético, como la división por cero.
        try {
            int result = 10 / 0; // División por cero
        } catch (ArithmeticException error) {
            System.out.println("ArithmeticException: " + error.getMessage());
        }

        // ArrayIndexOutOfBoundsException:
        // se lanza cuando se intenta acceder a un índice fuera del rango del arreglo.
        try {
            int[] arr = {1, 2, 3};
            int value = arr[5]; // Índice fuera de rango
        } catch (ArrayIndexOutOfBoundsException error) {
            System.out.println("ArrayIndexOutOfBoundsException: " + error.getMessage());
        }

        // NullPointerException:
        // se lanza cuando se intenta usar un objeto nulo.
        try {
            String str = null;
            int length = str.length(); // Acceder a un objeto nulo
        } catch (NullPointerException error) {
            System.out.println("NullPointerException: " + error.getMessage());
        }

        // ClassCastException:
        // ocurre cuando se intenta convertir un objeto a un tipo incompatible.
        try {
            Object obj = "cadena";
            Integer num = (Integer) obj; // Conversión incorrecta
        } catch (ClassCastException error) {
            System.out.println("ClassCastException: " + error.getMessage());
        }

        // IllegalArgumentException: se lanza cuando un argumento pasado a un método es inválido.
        try {
            LocalDate fecha = LocalDate.of(2023, 13, 1); // Mes inválido
        } catch (IllegalArgumentException error) {
            System.out.println("IllegalArgumentException: " + error.getMessage());
        }

        // NumberFormatException:
        // ocurre cuando una cadena no se puede convertir a un número.
        try {
            int number = Integer.parseInt("abc"); // No es un número válido
        } catch (NumberFormatException error) {
            System.out.println("NumberFormatException: " + error.getMessage());
        }

        // FileNotFoundException:
        // se lanza cuando no se puede encontrar el archivo especificado.
        try {
            FileReader reader = new FileReader("archivo_que_no_existe.txt"); // Archivo no encontrado
        } catch (FileNotFoundException error) {
            System.out.println("FileNotFoundException: " + error.getMessage());
        }

        // IOException:
        // se produce un error de entrada/salida.
        try {
            FileWriter writer = new FileWriter("archivo.txt");
            writer.write("Hola mundo");
            writer.close(); // Cerrando el recurso para evitar fugas
        } catch (IOException error) {
            System.out.println("IOException: " + error.getMessage());
        }

        // NoSuchElementException:
        // ocurre cuando se intenta acceder a un elemento que no existe, como con un iterador sin elementos.
        try {
            ArrayList<Integer> lista = new ArrayList<>();
            Iterator<Integer> iter = lista.iterator();
            int value = iter.next(); // No hay elementos en la lista
        } catch (NoSuchElementException error) {
            System.out.println("NoSuchElementException: " + error.getMessage());
        }

        // IllegalStateException:
        // se lanza cuando el estado de un objeto no permite la operación solicitada.
        try {
            ArrayList<Integer> lista = new ArrayList<>();
            Iterator<Integer> iter = lista.iterator();
            iter.remove(); // No se puede eliminar sin usar `next` primero
        } catch (IllegalStateException error) {
            System.out.println("IllegalStateException: " + error.getMessage());
        }
    }
}
