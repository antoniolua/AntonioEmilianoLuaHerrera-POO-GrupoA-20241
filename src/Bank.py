class Employee:
    def __init__(self, name, lastname, account):
        self.name = name
        self.lastname = lastname
        self.account = account


class Bank:
    list = []

    @classmethod
    def add_employee(cls, employee):
        cls.list.append(employee)

    @classmethod
    def view_person(cls):
        for i, employee in enumerate(cls.list):
            print(f"El numero de cuenta del empleado {employee.name} es {employee.account.account_number}, "
                  f"su saldo es {employee.account.amount} y la cuenta es de tipo {employee.account.account_type}")
            print()

    @classmethod
    def view_one_person(cls, name, lastname):
        for i, employee in enumerate(cls.list):
            if employee.name == name and employee.lastname == lastname:
                print(f"*** Cuenta {i + 1}***")
                print(f"{i + 1}- El numero de cuenta del empleado {employee.name} es {employee.account.account_number}, "
                      f"su saldo es {employee.account.amount} y la cuenta es de tipo {employee.account.account_type}")

    @classmethod
    def search_account(cls, numero):
        print("Change Correct")
        return numero - 1


class Account:
    def __init__(self, account_number, amount, account_type):
        self.account_number = account_number
        self.amount = amount
        self.account_type = account_type


# Ejemplo de uso
account1 = Account(account_number=123, amount=1000, account_type='Ahorro')
employee1 = Employee(name='Juan', lastname='Perez', account=account1)

account2 = Account(account_number=456, amount=2000, account_type='Corriente')
employee2 = Employee(name='Maria', lastname='Gomez', account=account2)

Bank.add_employee(employee1)
Bank.add_employee(employee2)

Bank.view_person()
Bank.view_one_person(name='Juan', lastname='Perez')
Bank.search_account(numero=2)
