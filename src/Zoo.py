class Zoo:
    __employees = []
    __visitors = []
    __password = "cuchurrumin1235"
    __animals = []
    __maintenances = []
    __visits = []

    # ANIMAl
    def add_animal(self, animal):
        self.__animals.append(animal)
        print("Animal added successfully")
        print()

    def show_animals(self):
        print("** Animals **")
        for i, animal in enumerate(self.__animals):
            print("[{}] index".format(i))
            print("-Type: {}".format(animal.get_type_animal()))
            print("-Birthday: {}".format(animal.get_birthdate()))
            print("-Arrival date at the zoo: {}".format(animal.get_arrival_date()))
            print("-Weight: {}".format(animal.get_weight()))
            print("-Feeding frequency: {}".format(animal.get_feeding_frequency()))
            print("-Feeding type: {}".format(animal.get_feeding_type()))
            print("-Has vaccines: {}".format(animal.get_vaccines()))
            print("Diseases:")
            for j, disease in enumerate(animal.get_diseases()):
                print("    {}. {}".format(j + 1, disease))
            print()

    def remove_animal(self, index):
        self.__animals.pop(index)
        print("The animal has been successfully removed")
        print()

    def modify_weight(self, index, weight):
        animal = self.__animals[index]
        animal.set_weight(weight)
        print("Weight has been changed correctly")
        print()

    # EMPLOYEES
    def add_employee(self, employee):
        self.__employees.append(employee)

    def show_all_employees(self):
        for employee in self.__employees:
            print(f"Name: {employee.get_name()} Last name: {employee.get_last_name()} \n"
                  f"Birth date: {employee.get_birth_date()} Start date: {employee.get_start_date()} \n"
                  f"RFC: {employee.get_rfc()} CURP: {employee.get_curp()} Salary: {employee.get_rol()} \n"
                  f"Schedule: {employee.get_schedule()}")

    def show_a_employee(self, index):
        employee = self.__employees.__getitem__(index)
        print(f"Name: {employee.get_name()} Last name: {employee.get_last_name()} \n"
              f"Birth date: {employee.get_birth_date()} Start date: {employee.get_start_date()} \n"
              f"RFC: {employee.get_rfc()} CURP: {employee.get_curp()} Salary: {employee.get_rol()} \n"
              f"Schedule: {employee.get_schedule()}")

    def remove_employee(self, index):
        self.__employees.pop(index)

    def change_employee_salary(self, index, salary):
        employee = self.__employees.__getitem__(index)
        employee.set_salary(salary)

    # VISITORS
    def add_visitor(self, visitor):
        self.__visitors.append(visitor)

    def show_visitors(self):
        for visitor in self.__visitors:
            print(f"Name: {visitor.get_name()} Last name: {visitor.get_last_name()}\n"
                  f"Birth date: {visitor.get_birth_date()} CURP: {visitor.get_curp()}\n"
                  f"Visit number: {visitor.get_visit_number()} Register date: {visitor.get_register_date()}")

    def show_a_visitor(self, index):
        visitor = self.__visitors.__getitem__(index)
        print(f"Name: {visitor.get_name()} Last name: {visitor.get_last_name()}\n"
              f"Birth date: {visitor.get_birth_date()} CURP: {visitor.get_curp()}\n"
              f"Visit number: {visitor.get_visit_number()} Register date: {visitor.get_register_date()}")

    def change_visitor_age(self, index, date):
        visitor = self.__visitors.__getitem__(index)
        visitor.set_birth_date(date)

    # GENERAL

    def get_animals(self):
        return self.__animals

    def get_visits(self):
        return self.__visits

    def get_employees(self):
        return self.__employees

    def get_visitors(self):
        return self.__visitors

    def get_maintenances(self):
        return self.__maintenances

    # PASSWORD
    def check_password(self, word):
        if word == self.__password:
            return True
        else:
            return False

    # VISITS

    def add_visit(self, visit):
        self.__visits.append(visit)

    def show_visits(self):
        for visit in self.__visits:
            print(f"Guide: {visit.get_guide().get_name()} {visit.get_guide().get_last_name()} "
                  f"\nTotal price: ${visit.calculate_total_price()}, "
                  f"formed by {visit.get_number_adults()} adults and {visit.get_number_children()} children.")

    # MAINTENANCES
    def add_maintenance(self, maintenance):
        self.__maintenances.append(maintenance)

    def show_maintenances(self):
        for maintenance in self.__maintenances:
            if maintenance.get_observations() == "":
                print(f"Maintenance made by {maintenance.get_employee().get_name()} "
                      f"{maintenance.get_employee().get_last_name()}, on {maintenance.get_procedure_date()}, "
                      f"in which procedure was: {maintenance.get_procedure()}. ")
            else:
                print(f"Maintenance made by {maintenance.get_employee().get_name()} "
                      f"{maintenance.get_employee().get_last_name()}, on {maintenance.get_procedure_date()}, "
                      f"in which procedure was: {maintenance.get_procedure()}. "
                      f"Observations: {maintenance.get_observations()}")
