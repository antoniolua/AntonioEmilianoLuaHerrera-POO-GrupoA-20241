import random

class Employee:
    def __init__(self, name, last_name, account_number, account_type):
        if account_type not in ['A', 'B', 'C']:
            print("Tipo de cuenta no permitido")
            return

        self.account = BankAccount(account_number, account_type)
        self.name = name
        self.last_name = last_name
        print("***Usuario registrado con éxito***")

    def get_name(self):
        return self.name

    def set_name(self, name):
        self.name = name

    def get_last_name(self):
        return self.last_name

    def set_last_name(self, last_name):
        self.last_name = last_name

    def get_account(self):
        return self.account


class BankAccount:
    def __init__(self, account_number, account_type):
        self.account_number = account_number
        self.amount = 0.0
        self.account_type = account_type

    def add_money(self, amount):
        if self.account_type == 'A':
            self.add_money_a(amount)
        elif self.account_type == 'B':
            self.add_money_b(amount)
        else:
            self.amount += amount

    def add_money_a(self, amount):
        if self.amount + amount <= 50000:
            self.amount += amount
        else:
            print("No puedes tener más de 50000 en esta cuenta")

    def add_money_b(self, amount):
        if self.amount + amount <= 100000:
            self.amount += amount
        else:
            print("No puedes tener más de 100000 en esta cuenta")

    def withdrawals(self, amount):
        if self.account_type == 'A':
            self.withdrawals_a(amount)
        elif self.account_type == 'B':
            self.withdrawals_b(amount)
        elif self.account_type == 'C':
            self.withdrawals_c(amount)

    def withdrawals_a(self, amount):
        if self.amount - amount >= 1000:
            self.amount -= amount
        else:
            print("Saldo mínimo de 1000")

    def withdrawals_b(self, amount):
        if self.amount - amount >= 5000:
            self.amount -= amount
        else:
            print("Saldo mínimo de 5000")

    def withdrawals_c(self, amount):
        if self.amount - amount >= 10000:
            self.amount -= amount
        else:
            print("Saldo mínimo de 10000")


class Bank:
    list = []

    @classmethod
    def add_employee(cls, employee):
        cls.list.append(employee)

    @classmethod
    def view_person(cls):
        for i, employee in enumerate(cls.list):
            print(f"El numero de cuenta del empleado {employee.get_name()} es {employee.get_account().account_number}, "
                  f"su saldo es {employee.get_account().amount} y la cuenta es de tipo {employee.get_account().account_type}")
            print()

    @classmethod
    def view_one_person(cls, name, last_name):
        for i, employee in enumerate(cls.list):
            if employee.get_name() == name and employee.get_last_name() == last_name:
                print(f"*** Cuenta {i + 1}***")
                print(f"{i + 1}- El numero de cuenta del empleado {employee.get_name()} es {employee.get_account().account_number}, "
                      f"su saldo es {employee.get_account().amount} y la cuenta es de tipo {employee.get_account().account_type}")

    @classmethod
    def search_account(cls, numero):
        print("Change Correct")
        return numero - 1


# Ejemplo de uso
clientes = Bank()
ran = random.Random()
person = None

while True:
    print("\nMENU")
    print("1. Create Account")
    print("2. Add Money")
    print("3. Withdraw Money")
    print("4. Account")
    print("5. Change account")
    print("0. Exit")

    opc = int(input())

    if opc == 0:
        break
    elif opc == 1:
        print("1. Create Account")
        name = input("Name: ")
        last_name = input("Last Name: ")
        account_number = int(ran.uniform(1000000, 10000000))
        print(f"Account: {account_number}")
        account_type = input("Type Account, A, B, or C: ")
        person = Employee(name, last_name, account_number, account_type)
        clientes.add_employee(person)
        clientes.view_person()
    elif opc == 2:
        print("Enter the amount to be entered")
        amount = float(input())
        person.get_account().add_money(amount)
    elif opc == 3:
        print("Amount to withdraw")
        amount_withdraw = float(input())
        person.get_account().withdrawals(amount_withdraw)
    elif opc == 4:
        print("1. View an account")
        print("2. See all account")
        opc = int(input())
        if opc == 1:
            name = input("Tell me your Name: ")
            last_name = input("Tell me your last name: ")
            clientes.view_one_person(name, last_name)
        elif opc == 2:
            print("Cuentas: ")
            clientes.view_person()
        else:
            print("Opcion no valida")
    elif opc == 5:
        name2 = input("Tell me your Name: ")
        last_name2 = input("Tell me your last name: ")
        clientes.view_one_person(name2, last_name2)
        numero = int(input("A que cuenta deseas cambiarte: "))
        in_ = clientes.search_account(numero)
        person = Bank.list[in_]
    else:
        print("Opcion no valida")
