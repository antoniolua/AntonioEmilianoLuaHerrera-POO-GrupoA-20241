from datetime import datetime


class Tienda:
    __password = "123"
    __electrodomesticos = []
    __limpiezas = []
    __bellezas = []
    __alimentos = []
    __clientes = []
    __productos = []
    __fecha_actual = datetime.now()

    # Electrodomestico
    def add_electrodomestico(self, electrodomestico):
        self.__electrodomesticos.append(electrodomestico)
        self.__productos.append(electrodomestico)
        print("Producto de Electrodomestico añdadido correcatamente")

    def mostrar_electrodomestico(self):
        print("*** Productos de Electrodomestico ***")
        for i, electrodomestico in enumerate(self.__electrodomesticos):
            print(f"[{i}] - Nombre: {electrodomestico.get_nombre()}, "
                  f"Precio: {electrodomestico.get_precio()}, "
                  f"Fecha de importacion: {self.__fecha_actual}, "
                  f"Número de Serie: {electrodomestico.get_numero_serie()}, "
                  f"Stock Disponible: {electrodomestico.get_stock()}, "
                  f"Marca: {electrodomestico.get_marca()}")
            print()

    # Limpieza
    def add_limpieza(self, limpieza):
        self.__limpiezas.append(limpieza)
        self.__productos.append(limpieza)
        print("Producto de Limpieza añdadido correcatamente")

    def mostrar_limpiezas(self):
        print("*** Productos de Limpieza ***")
        for i, limpieza in enumerate(self.__limpiezas):
            print(f"[{i}] - Nombre: {limpieza.get_nombre()}, "
                  f"Precio: {limpieza.get_precio()}, "
                  f"Fecha de importación: {self.__fecha_actual}, "
                  f"Número de Serie: {limpieza.get_numero_serie()}, "
                  f"Stock Disponible: {limpieza.get_stock()}, "
                  f"Aroma: {limpieza.get_aroma()}")
            print()

    # Belleza

    def add_belleza(self, belleza):
        self.__bellezas.append(belleza)
        self.__productos.append(belleza)
        print("Producto de Belleza añdadido correcatamente")

    def mostrar_belleza(self):
        print("*** Productos de Belleza ***")
        for i, belleza in enumerate(self.__bellezas):
            print(f"[{i}] - Nombre: {belleza.get_nombre()}, "
                  f"Precio: {belleza.get_precio()}, "
                  f"Fecha de importación: {self.__fecha_actual}, "
                  f"Número de Serie: {belleza.get_numero_serie()}, "
                  f"Stock Disponible: {belleza.get_stock()}, "
                  f"Tono de Piel: {belleza.get_tono_piel()}")
            print()

    # Alimento
    def add_alimento(self, alimento):
        self.__alimentos.append(alimento)
        self.__productos.append(alimento)
        print("Producto de Alimento añdadido correcatamente")

    def mostrar_alimento(self):
        print("*** Productos de Alimentos ***")
        for i, alimento in enumerate(self.__alimentos):
            print(f"[{i}] - Nombre: {alimento.get_nombre()}, "
                  f"Precio: {alimento.get_precio()}, "
                  f"Fecha de importación: {self.__fecha_actual}, "
                  f"Número de Serie: {alimento.get_numero_serie()}, "
                  f"Stock Disponible: {alimento.get_stock()}, "
                  f"Fecha de Caducidad: {alimento.get_fecha_caducidad()}")
            print()

    def mostrar_todos_los_productos_por_categoria(self):
        self.mostrar_belleza()
        self.mostrar_alimento()
        self.mostrar_electrodomestico()
        self.mostrar_limpiezas()

    def mostrar_todos_los_productos(self):
        for i, producto in enumerate(self.__productos):
            if not producto.get_comprado() or producto.get_stock() > 0:
                print(f"[{i}] {producto.get_nombre()}\n"
                      f"Precio: {producto.get_precio()}, Fecha de Importación: {producto.get_fecha_importacion()}\n"
                      f"Cantidad en stock: {producto.get_stock()}, ¿Está comprado? {producto.is_comprado()}"
                      f", Número de serie: {producto.get_numero_serie()}\n")

    # Remover Producto

    def remover_producto(self, index_remover):
        producto = self.__productos[index_remover]
        if not producto.get_comprado():
            self.__productos.pop(index_remover)
            print("Producto Removido Exitosamente")
            if producto in self.__alimentos:
                self.__alimentos.remove(producto)
            elif producto in self.__bellezas:
                self.__bellezas.remove(producto)
            elif producto in self.__electrodomesticos:
                self.__electrodomesticos.remove(producto)
            elif producto in self.__limpiezas:
                self.__limpiezas.remove(producto)
        elif producto.get_comprado():
            print("No se puede eliminar el producto, el producto esta asociado a compras de los clientes")
        else:
            print("indice invalido")

    # Cliente

    def add_cliente(self, cliente):
        self.__clientes.append(cliente)
        print("Cliente agregado correctamente. ")

    def remove_cliente(self, index_remover):
        cliente = self.__clientes[index_remover]
        if not cliente.get_comprado():
            self.__clientes.pop(index_remover)
            print("Cliente Removido Exitosamente")
        else:
            print("No se puede eliminar el cliente, el cliente tiene compras asociadas")

    def get_cliente(self, index):
        if 0 <= index < len(self.__clientes):
            return self.__clientes[index]
        else:
            return None

    def mostrar_clientes(self):
        print("*** Clientes ***")
        for i, cliente in enumerate(self.__clientes):
            print(f"[{i}] - {cliente.get_name()} {cliente.get_apellido()}")

    def numero_clientes(self):
        print("El numero de clientes es: ", len(self.__clientes))

    def numero_productos(self):
        print("El numero de productos es: ", len(self.__productos))

    def check_paswword(self, password):
        if password == self.__password:
            return True
        else:
            return False

    # comprar productos
    def comprar_productos(self, index_cliente, index_producto):
        producto = self.__productos[index_producto]
        if producto.get_comprado() and producto.get_stock() < 1:
            print("Producto no disponible")
        elif producto.get_stock() > 0:
            producto.set_stock()
            producto.remover_stock(self, 1)
            cliente = self.__clientes[index_cliente]
            cliente.add_producto(producto, self.__fecha_actual)
            print("!Producto comprado¡")
        else:
            print("No hay stock disponible")

    def productos_comprados(self):
        for cliente in self.__clientes:
            print("Compras realizadas por:", cliente.get_name(), cliente.get_apellido())
            cliente.mostrar_compras()
            print()
