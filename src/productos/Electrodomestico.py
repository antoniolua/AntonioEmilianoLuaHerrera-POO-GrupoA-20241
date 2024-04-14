from productos.Producto import Producto


class Electrodomestico(Producto):
    def __init__(self, nombre, precio, fecha_importacion, numero_serie, stock, marca):
        super().__init__(nombre, precio, fecha_importacion, numero_serie, stock)
        self.__marca = marca

    def get_marca(self):
        return self.__marca
