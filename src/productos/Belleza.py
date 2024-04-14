from productos.Producto import Producto


class Belleza(Producto):
    def __init__(self, nombre, precio, fecha_importacion, numero_serie, stock, tono_piel):
        super().__init__(nombre, precio, fecha_importacion, numero_serie, stock)
        self.__tono_piel = tono_piel

    def get_tono_piel(self):
        return self.__tono_piel
