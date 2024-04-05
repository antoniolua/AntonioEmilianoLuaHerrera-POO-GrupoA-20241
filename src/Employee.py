from Zoo import Zoo


class Employee:
    __name = ""
    __last_name = ""
    __birth_date = ""
    __start_date = ""
    __rfc = ""
    __curp: object = ""
    __salary = 0
    __rol = ""
    __schedule = ""

    def __init__(self, name, last_name, birth_date, start_date, rfc, curp, salary, rol, schedule):
        self.__name = name
        self.__last_name = last_name
        self.__birth_date = birth_date
        self.__start_date = start_date
        self.__rfc = rfc
        self.__curp = curp
        self.__salary = salary
        self.__rol = rol
        self.__schedule = schedule
        self.zoo = Zoo()
        self.zoo.add_employee(self)

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

    def get_start_date(self):
        return self.__start_date

    def set_start_date(self, start_date):
        self.__start_date = start_date

    def get_rfc(self):
        return self.__rfc

    def set_rfc(self, rfc):
        self.__rfc = rfc

    def get_curp(self):
        return self.__curp

    def set_curp(self, curp):
        self.__curp = curp

    def get_salary(self):
        return self.__salary

    def set_salary(self, salary):
        self.__salary = salary

    def get_rol(self):
        return self.__rol

    def set_rol(self, rol):
        self.__rol = rol

    def get_schedule(self):
        return self.__schedule

    def set_schedule(self, schedule):
        self.__schedule = schedule
