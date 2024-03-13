import random

class Usuario:
    def __init__(self, nombre, edad):
        self.nombre = nombre
        self.id = random.randint(1, 1000)
        self.edad = edad
        self.compradoBook = False

    def get_nombre(self):
        return self.nombre

    def get_edad(self):
        return self.edad

    def get_comprado_book(self):
        return self.compradoBook

    def set_comprado_book(self, comprado):
        self.compradoBook = comprado
