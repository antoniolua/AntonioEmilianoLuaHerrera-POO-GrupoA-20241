import sys
from Libreria import Libreria
from Usuario import Usuario
from Libro import Libro

class Main:
    def __init__(self):
        self.libreria = Libreria()

    def menu_principal(self):
        while True:
            print("\nBIENVENIDO A LA LIBRERIA\n")
            print("Elige una opción para continuar")
            print("1. Añadir usuario")
            print("2. Añadir libro")
            print("3. Mostrar Usuarios")
            print("4. Mostrar Libros")
            print("5. Rentar Libro O Comprar")
            print("6. Mostrar Libros Rentados O Comprados")
            print("7. Usuarios con libros comprados")
            print("8. Salir")

            opcion = input("Opción: ")
            if opcion == '1':
                self.agregar_usuario()
            elif opcion == '2':
                self.agregar_libro()
            elif opcion == '3':
                self.mostrar_usuarios()
            elif opcion == '4':
                self.mostrar_libros()
            elif opcion == '5':
                self.rentar_o_comprar_libro()
            elif opcion == '6':
                self.mostrar_libros_rentados_o_comprados()
            elif opcion == '7':
                self.usuarios_con_libros_comprados()
            elif opcion == '8':
                print("Gracias por utilizar la librería. ¡Hasta luego!")
                sys.exit()
            else:
                print("Opción inválida. Por favor, elige una opción del 1 al 8.")

    def agregar_usuario(self):
        nombre = input("Ingresa el nombre del usuario: ")
        edad = int(input("Ingresa la edad del usuario: "))
        usuario = Usuario(nombre, edad)
        self.libreria.agregar_usuario(usuario)
        print("El usuario", nombre, "ha sido registrado correctamente.")

    def agregar_libro(self):
        nombre = input("Ingresa el nombre del libro: ")
        autor = input("Ingresa el autor del libro: ")
        libro = Libro(nombre, autor)
        self.libreria.agregar_libro(libro)
        print("El libro", nombre, "de", autor, "ha sido registrado correctamente.")

    def mostrar_usuarios(self):
        self.libreria.mostrar_usuarios()

    def mostrar_libros(self):
        self.libreria.mostrar_libros()

    def rentar_o_comprar_libro(self):
        print("\n1. Renta de libros")
        print("2. Compra de libros")
        opcion = input("Opción: ")
        if opcion == '1':
            self.rentar_libro()
        elif opcion == '2':
            self.comprar_libro()
        else:
            print("Opción inválida.")

    def rentar_libro(self):
        self.libreria.rentar_libro()

    def comprar_libro(self):
        self.libreria.comprar_libro()

    def mostrar_libros_rentados_o_comprados(self):
        self.libreria.mostrar_libros_rentados()
        self.libreria.mostrar_libros_comprados()

    def usuarios_con_libros_comprados(self):
        self.libreria.mostrar_usuarios_con_libros_comprados()


if __name__ == "__main__":
    Main().menu_principal()
