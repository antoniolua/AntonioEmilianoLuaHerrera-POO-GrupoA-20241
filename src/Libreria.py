class Libreria:
    def __init__(self):
        self.lista_usuarios = []
        self.lista_libros = []

    def agregar_usuario(self, usuario):
        self.lista_usuarios.append(usuario)

    def agregar_libro(self, libro):
        self.lista_libros.append(libro)

    def mostrar_usuarios(self):
        print("*** Usuarios ***")
        for usuario in self.lista_usuarios:
            print("Nombre:", usuario.get_nombre(), "- Edad:", usuario.get_edad(), "- ID:", usuario.id)

    def mostrar_libros(self):
        print("*** Libros ***")
        for libro in self.lista_libros:
            print("Nombre:", libro.get_nombre(), "- Autor:", libro.get_autor(), "- ID:", libro.id)

    def rentar_libro(self, nombre, autor):
        for libro in self.lista_libros:
            if libro.get_nombre() == nombre and libro.get_autor() == autor and not libro.get_es_rentado():
                print("El libro", nombre, "de", autor, "ha sido rentado.")
                libro.set_es_rentado(True)
                return
        print("El libro solicitado no está disponible para renta.")

    def comprar_libro(self):
        self.mostrar_usuarios()
        nombre_usuario = input("Ingresa el nombre del usuario: ")
        usuario_encontrado = False
        for usuario in self.libreria.lista_usuarios:
            if usuario.get_nombre() == nombre_usuario:
                usuario_encontrado = True
                break

        if usuario_encontrado:
            self.libreria.mostrar_libros_disponibles()
            try:
                libro_idx = int(input("Ingresa el número de libro a comprar: ")) - 1
                if 0 <= libro_idx < len(self.libreria.lista_libros):
                    libro = self.libreria.lista_libros[libro_idx]
                    if not libro.es_comprado:
                        libro.es_comprado = True
                        print(f"El libro {libro.nombre} ha sido comprado por {nombre_usuario}.")
                    else:
                        print("El libro ya está comprado.")
                else:
                    print("Número de libro inválido.")
            except ValueError:
                print("Ingresa un número válido para el libro.")
        else:
            print("El nombre de usuario ingresado no existe.")
