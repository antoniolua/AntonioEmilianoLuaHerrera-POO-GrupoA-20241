import random

class Libro:
    def __init__(self, nombre, autor):
        self.nombre = nombre
        self.id = random.randint(1, 1000)
        self.autor = autor
        self.es_rentado = False
        self.es_comprado = False

    def get_nombre(self):
        return self.nombre

    def get_autor(self):
        return self.autor

    def get_es_rentado(self):
        return self.es_rentado

    def set_es_rentado(self, rentado):
        self.es_rentado = rentado

    def get_es_comprado(self):
        return self.es_comprado

    def set_es_comprado(self, comprado):
        self.es_comprado = comprado
