class Producto:
    cantidad_producto = 1

    def __init__(self, nombre, precio, fecha_importacion, numero_serie, stock):
        self.__id = Producto.cantidad_producto
        Producto.cantidad_producto += 1
        self.__nombre = nombre
        self.__precio = precio
        self.__fecha_importacion = fecha_importacion
        self.__numero_serie = numero_serie
        self.__stock = stock
        self.__comprado = False

    # Métodos para acceder a los atributos privados (opcional)
    @staticmethod
    def get_cantidad_producto():
        return Producto.cantidad_producto

    def get_id(self):
        return self.__id

    def get_nombre(self):
        return self.__nombre

    def get_precio(self):
        return self.__precio

    def get_fecha_importacion(self):
        return self.__fecha_importacion

    def get_numero_serie(self):
        return self.__numero_serie

    def get_stock(self):
        return self.__stock

    def get_comprado(self):
        return self.__comprado

    def set_comprado(self):
        self.__comprado = True

    def remover_stock(self, num):
        self.__stock -= num

    def anadir_stock(self, num):
        self.__stock += num
