from Zoo import Zoo


class Visitor:
    __name = ""
    __last_name = ""
    __birth_date = ""
    __curp = ""
    __visit_number = 0
    __register_date = ""

    def __init__(self, name, last_name, birth_date, curp, register_date):
        self.__name = name
        self.__last_name = last_name
        self.__birth_date = birth_date
        self.__curp = curp
        self.__visit_number = 0
        self.__register_date = register_date
        self.zoo = Zoo()
        self.zoo.add_visitor(self)

    def check_adult(self):
        band = False
        age = self.__birth_date.split("/")
        year = int(age[2])
        calculus = 2024 - year
        if calculus >= 18:
            band = True
        return band

    def add_visit(self):
        self.__visit_number += 1

    def get_name(self):
        return self.__name

    def set_name(self, name):
        self.__name = name

    def get_last_name(self):
        return self.__last_name

    def set_last_name(self, last_name):
        self.__last_name = last_name

    def get_birth_date(self):
        return self.__birth_date

    def set_birth_date(self, birth_date):
        self.__birth_date = birth_date

    def get_curp(self):
        return self.__curp

    def set_curp(self, curp):
        self.__curp = curp

    def get_visit_number(self):
        return self.__visit_number

    def set_visit_number(self, visit_number):
        self.__visit_number = visit_number

    def get_register_date(self):
        return self.__register_date

    def set_register_date(self, register_date):
        self.__register_date = register_date
