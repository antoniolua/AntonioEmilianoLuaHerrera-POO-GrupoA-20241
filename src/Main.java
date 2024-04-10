import tienda.Tienda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String password= "";
        int cont = 1;
        boolean banSalir = true;
        System.out.println("Bienvenido al sistema del mi chilchota, por favor ingresa la contraseña para poder acceder al menú, tienes 5 intentos");
        do {
            System.out.println("intento numero: "+cont);
            password= sc.nextLine();
            cont++;
            if (cont == 6) {
                System.out.println("A sobre pasado el  numero de intentos");
                return;
            }
        }while (!Tienda.checkPaswword(password));

        System.out.println("*** BIENVENIDO A MI CHILCHOTA ***");
       do {
           System.out.println("Menu");
           System.out.println("1. ");
           System.out.println("2. ");
           System.out.println("3. ");
           System.out.println("4. ");
           System.out.println("5. Salir");

           System.out.println("Digite una opcion");
           int opc= sc.nextInt();

           switch (opc) {
               case 1:
                   System.out.println("Ha seleccionado la opción 1");
                   break;
               case 2:
                   System.out.println("Ha seleccionado la opción 2");
                   break;
               case 3:
                   System.out.println("Ha seleccionado la opción 3");
                   break;
               case 4:
                   System.out.println("Ha seleccionado la opción 4");
                   break;
               case 5:
                   System.out.println("Saliendo del programa...");
                   banSalir=false;
                   break;
               default:
                   System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
           }

       }while (banSalir == true);
    }
}
