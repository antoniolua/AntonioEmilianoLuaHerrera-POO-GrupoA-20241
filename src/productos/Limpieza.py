from productos.Producto import Producto


class Limpieza(Producto):
    def __init__(self, nombre, precio, fecha_importacion, numero_serie, stock, aroma):
        super().__init__(nombre, precio, fecha_importacion, numero_serie, stock)
        self.__aroma = aroma

    def get_aroma(self):
        return self.__aroma
