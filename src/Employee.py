class Employee:
    def __init__(self, name, last_name, account_number, account_type):
        if account_type not in ['A', 'B', 'C']:
            print("Tipo de cuenta no permitido")
            return

        self.account = BankAccount(account_number, account_type)
        self.bank = None
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

    def get_bank(self):
        return self.bank


class BankAccount:
    def __init__(self, account_number, account_type):
        self.account_number = account_number
        self.amount = 0.0
        self.account_type = account_type

    # Resto del código de BankAccount (lo proporcionado anteriormente)

# Ejemplo de uso
employee = Employee(name='John', last_name='Doe', account_number=123456, account_type='A')
print(f"Nombre del empleado: {employee.get_name()}")
print(f"Apellido del empleado: {employee.get_last_name()}")
print(f"Tipo de cuenta del empleado: {employee.get_account().get_account_type()}")
