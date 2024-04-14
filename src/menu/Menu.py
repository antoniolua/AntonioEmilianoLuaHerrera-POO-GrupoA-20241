from productos.Alimento import Alimento
from productos.Belleza import Belleza
from productos.Electrodomestico import Electrodomestico
from productos.Limpieza import Limpieza
from tienda.Tienda import Tienda
from usuarios.Cliente import Cliente

tienda = Tienda()


class Menu:

    @staticmethod
    def iniciar_sesion():
        cont = 1
        print("Bienvenido al sistema del mi chilchota,"
              " por favor ingresa la contraseña para poder acceder al menú, "
              "tienes 5 intentos")
        while cont <= 5:
            print("Intento número:", cont)
            password = input()
            cont += 1
            if cont == 6:
                print("Has superado el número de intentos.")
                return
            if tienda.check_paswword(password):
                Menu.menu_principal()
                return
        return

    @staticmethod
    def menu_principal():
        print("*** BIENVENIDO A MI CHILCHOTA ***")
        ban_salir = True
        while ban_salir:
            print("\nSELECCIONA UNA OPCION: ")
            print("1. Registrar un producto nuevo.")
            print("2. Registrar a un cliente nuevo.")
            print("3. Comprar un producto.")
            print("4. Ver todos los productos comprados.")
            print("5. Ver todas las compras de un cliente en específico.")
            print("6. Eliminar un producto.")
            print("7. Eliminar a un cliente.")
            print("8. Ver el número de clientes.")
            print("9. Ver el número de productos.")
            print("10. Mostrar todos los productos.")
            print("11. SALIR")

            opcion = int(input())

            if opcion == 1:
                Menu.registrar_producto()
            elif opcion == 2:
                Menu.registrar_cliente()
            elif opcion == 3:
                Menu.comprar_producto()
            elif opcion == 4:
                tienda.productos_comprados()
            elif opcion == 5:
                Menu.compras_usuario_especifico()
            elif opcion == 6:
                Menu.eliminar_producto()
            elif opcion == 7:
                Menu.eliminar_cliente()
            elif opcion == 8:
                tienda.numero_clientes()
            elif opcion == 9:
                tienda.numero_productos()
            elif opcion == 10:
                tienda.mostrar_todos_los_productos_por_categoria()
            elif opcion == 11:
                print("Saliendo del sistema.")
                ban_salir = False
            else:
                print("OPCIÓN INVÁLIDA")

    @staticmethod
    def registrar_producto():
        opc = 0
        while opc < 1 or opc > 4:
            print("Selecciona el tipo de producto a registrar: ")
            print("1. Electrodomesticos")
            print("2. Limpieza")
            print("3. Belleza")
            print("4. Alimentos")
            opc = int(input())

        nombre = input("Ingresa el nombre del producto: ")
        precio = float(input("Ingresa el precio del producto: "))
        fecha_import = input("Ingresa la fecha de importación XX/XX/XXXX: ")
        num_serie = int(input("Ingresa el número de serie: "))
        stock = int(input("Ingresa el stock deseado del producto: "))

        if opc == 1:
            print("Ingresa la marca del electrodomestico: ")
            marca = input()
            tienda.add_electrodomestico(Electrodomestico(nombre, precio, fecha_import, num_serie, stock, marca))

        elif opc == 2:
            print("Ingresa el aroma del producto: ")
            aroma = input()
            tienda.add_limpieza(Limpieza(nombre, precio, fecha_import, num_serie, stock, aroma))

        elif opc == 3:
            print("Ingresa el tono de piel: ")
            tono_piel = input()
            tienda.add_belleza(Belleza(nombre, precio, fecha_import, num_serie, stock, tono_piel))

        elif opc == 4:
            print("Ingresa la fecha de caducidad: ")
            fecha_caducidad = input()
            tienda.add_alimento(Alimento(nombre, precio, fecha_import, num_serie, stock, fecha_caducidad))

    @staticmethod
    def registrar_cliente():
        nombre = input("Ingrese el nombre del cliente: ")
        apellido = input("Ingresa el apellido del cliente:")
        edad = input("Ingresa el edad del cliente")
        tienda.add_cliente(Cliente(nombre, apellido, edad))

    @staticmethod
    def comprar_producto():
        tienda.mostrar_clientes()
        index_cliente = input("elecciona el cliente con el que deseas comprar un producto: ")
        print("*** Productos Disponibles ***")
        tienda.mostrar_todos_los_productos()
        index_producto = input("Ingresa el indice del producto que deseas comprar:")
        tienda.comprar_productos(index_cliente, index_producto)

    @staticmethod
    def compras_usuario_especifico():
        tienda.mostrar_clientes()
        index_cliente = input("Digite el indice del Cliente: ")
        cliente = tienda.get_cliente(index_cliente)
        print("Compras de ", cliente.get_name())
        cliente.mostrar_compras()

    @staticmethod
    def eliminar_producto():
        tienda.mostrar_todos_los_productos()
        index_remover = input("Digite el indice del producto a remover")
        tienda.remover_producto(index_remover)

    @staticmethod
    def eliminar_cliente():
        tienda.mostrar_clientes()
        index_remover = input("Digite el indice del cliente a remover")
        tienda.remove_cliente(index_remover)
