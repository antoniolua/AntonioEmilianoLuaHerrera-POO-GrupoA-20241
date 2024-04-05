from Employee import Employee


class Visit:
    __total_cost = 0
    __date_visit = ""
    __guide = Employee
    __number_children = 0
    __number_adults = 0

    def __init__(self, employee, visitor, date_visit):
        self.__guide = employee
        self.__visitors = []
        self.__visitors.append(visitor)
        self.__date_visit = date_visit
        self.__total_cost = 0

    def get_number_people(self):
        return len(self.__visitors)

    def add_visitor(self, visitorsel):
        band = False
        for visitor in self.__visitors:
            if visitor == visitorsel:
                print("Visitor already exists in the visit. ")
                band = True
                break
        if not band:
            self.__visitors.append(visitorsel)
            visitorsel.set_visit_number(1)

    def calculate_total_price(self):
        for visitor in self.__visitors:
            total = visitor.get_visit_number()
            if total == 5:
                if visitor.check_adult():
                    self.__total_cost += 100.0 * 0.8
                else:
                    self.__total_cost += 50.0 * 0.8
                visitor.set_visit_number(0)
            else:
                if visitor.check_adult():
                    self.__total_cost += 100.0
                else:
                    self.__total_cost += 50.0
        return self.__total_cost

    def get_date_visit(self):
        return self.__date_visit

    def get_guide(self):
        return self.__guide

    def set_guide(self, guide):
        self.__guide = guide

    def get_number_children(self):
        for visitor in self.__visitors:
            band = visitor.check_adult()
            if not band:
                self.__number_children += 1

        return self.__number_children

    def set_number_children(self, number_children):
        self.__number_children = number_children

    def get_number_adults(self):
        for visitor in self.__visitors:
            band = visitor.check_adult()
            if band:
                self.__number_adults += 1

        return self.__number_adults

    def set_number_adults(self, number_adults):
        self.__number_adults = number_adults

    def get_visitors(self):
        return self.__visitors
