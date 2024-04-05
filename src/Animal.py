class Animal:
    __count = 1
    __id = 0
    __type_animal = ""
    __birthdate = ""
    __arrival_date = ""
    __weight = 0
    __diseases = []
    __feeding_frequency = ""
    __feeding_type = ""
    __vaccines = True

    def __init__(self, type_animal, birthdate, arrival_date, weight, diseases, feeding_frequency, feeding_type,
                 vaccines):
        self.__type_animal = type_animal
        self.__birthdate = birthdate
        self.__arrival_date = arrival_date
        self.__weight = weight
        self.__diseases = diseases
        self.__feeding_frequency = feeding_frequency
        self.__feeding_type = feeding_type
        self.__vaccines = vaccines
        self.__id = Animal.__count
        Animal.__count += 1

    def get_type_animal(self):
        return self.__type_animal

    def get_birthdate(self):
        return self.__birthdate

    def get_arrival_date(self):
        return self.__arrival_date

    def get_weight(self):
        return self.__weight

    def set_weight(self, weight):
        self.__weight = weight

    def get_diseases(self):
        return self.__diseases

    def get_feeding_frequency(self):
        return self.__feeding_frequency

    def get_feeding_type(self):
        return self.__feeding_type

    def get_vaccines(self):
        return self.__vaccines

    def get_id(self):
        return self.__id
