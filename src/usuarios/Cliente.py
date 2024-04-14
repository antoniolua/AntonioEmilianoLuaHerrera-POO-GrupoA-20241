
class Cliente:
    def __init__(self, name, apellido, edad):
        self.name = name
        self.apellido = apellido
        self.edad = edad
        self.compras = []

    def anadir_producto(self, producto, fecha):
        detalle_compra = f"{producto.get_nombre()}, " \
                         f"Precio: {producto.get_precio()}, " \
                         f"Fecha de Importación: {producto.get_fecha_importacion()}, " \
                         f"Cantidad en stock: {producto.get_stock()}, " \
                         f"Número de serie: {producto.get_numero_serie()}, " \
                         f"Fecha de compra: {fecha}"
        self.compras.append(detalle_compra)

    def mostrar_compras(self):
        for i, detalle_compra in enumerate(self.compras, start=1):
            print(f"{i}- {detalle_compra}")

    def get_name(self):
        return self.name

    def get_apellido(self):
        return self.apellido

    def get_edad(self):
        return self.edad

    def get_compras(self):
        return self.compras
