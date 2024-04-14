from productos.Producto import Producto


class Alimento(Producto):
    def __init__(self, nombre, precio, fecha_importacion, numero_serie, stock, fecha_caducidad):
        super().__init__(nombre, precio, fecha_importacion, numero_serie, stock)
        self.__fecha_caducidad = fecha_caducidad

    def get_fecha_caducidad(self):
        return self.__fecha_caducidad
