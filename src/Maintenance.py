from Animal import Animal
from Employee import Employee


class Maintenance:
    __employee = Employee
    __animal = Animal
    __procedure = ""
    __procedure_date = ""
    __observations = ""

    def __init__(self, employee, animal, procedure, procedure_date, observations=None):
        self.__employee = employee
        self.__animal = animal
        self.__procedure = procedure
        self.__procedure_date = procedure_date
        self.__observations = observations

    def consult(self):
        if self.__observations == "":
            return (f"Employee: {self.__employee.getName()} \nAnimal ID: {self.__animal.getId()} \nProcedure: "
                    f"{self.__procedure} \nDate: {self.__procedure_date}")
        else:
            return (f"Employee: {self.__employee.getName()} \nAnimal ID: {self.__animal.getId()} \nProcedure: "
                    f"{self.__procedure} \nDate: {self.__procedure_date} \nObservations: {self.__observations}")

    def get_employee(self):
        return self.__employee

    def get_animal(self):
        return self.__animal

    def get_procedure(self):
        return self.__procedure

    def get_procedure_date(self):
        return self.__procedure_date

    def get_observations(self):
        return self.__observations