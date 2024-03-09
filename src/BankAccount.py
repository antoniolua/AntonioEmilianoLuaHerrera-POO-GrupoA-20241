class BankAccount:
    def __init__(self, account_number, account_type):
        self.account_number = account_number
        self.amount = 0.0
        self.account_type = account_type
        self.employee = None

    def set_account_type(self, account_type):
        self.account_type = account_type

    def get_account_type(self):
        return self.account_type

    def get_account_number(self):
        return self.account_number

    def get_amount(self):
        return self.amount

    def set_amount(self, amount):
        self.amount = amount

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

# Ejemplo de uso
account = BankAccount(account_number=123456, account_type='A')
print(f"Initial amount: {account.get_amount()}")
account.add_money(20000)
print(f"Amount after deposit: {account.get_amount()}")
account.withdrawals(5000)
print(f"Amount after withdrawal: {account.get_amount()}")
