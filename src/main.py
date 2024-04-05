from Animal import Animal
from Maintenance import Maintenance
from Visit import Visit
from Visitor import Visitor
from Employee import Employee
from Zoo import Zoo

if __name__ == "__main__":
    option = 0
    zoo = Zoo()

    print("Welcome to the zoo system, please enter the password in order to access to the menu, you have 5 tries.")
    cont = 1
    while True:
        print("Try number:", cont)
        password = input()
        cont += 1
        if cont == 6:
            print("YOU ARE NOT THE ADMINISTRATOR, YOU ARE BEING EXPELLED.")
            exit(69)
        if zoo.check_password(password):
            break

    print("WELCOME TO THE SYSTEM, ADMINISTRATOR.")
    while option != "12":
        print("Select an option:")
        print("1. Add employee")
        print("2. Add Animal")
        print("3. Add visitor")
        print("4. Add visit")
        print("5. Add maintenance")
        print("6. Add visitor to a visit")
        print("7. Employee option")
        print("8. Visitors option")
        print("9. Animals option")
        print("10. Show all current visits")
        print("11. Show all current maintenance")
        print("12. Exit")

        option = input()

        if option == "1":
            print("You have selected the option to register an employee, please type in his/her name: ")
            name = input()

            print("Now type in the employee's last name: ")
            last_name = input()

            print("Now type in the employee's birth date in the next format: XX/XX/XXXX")
            birth_date = input()

            print("Please now type the employee´s start working date in the same format: XX/XX/XXXX")
            start_date = input()

            print("Please, type in the employee´s RFC: ")
            rfc = input()

            print("Please, type in the employee´s CURP: ")
            curp = input()

            print("Now, type in the employee's desired salary: ")
            salary = float(input())

            option = 0
            rol = ""
            while option not in [1, 2, 3, 4]:
                print("Now, please select a role for the new employee, choose an option between the next list: \n" +
                      "[1]= Veterinary \n" +
                      "[2]= Guide \n" +
                      "[3]= Administrative staff \n" +
                      "[4]= Maintenance staff \n")
                option = int(input())
                if option == 1:
                    rol = "Veterinary."
                elif option == 2:
                    rol = "Guide."
                elif option == 3:
                    rol = "Administrative staff."
                elif option == 4:
                    rol = "Maintenance staff."
                else:
                    print("False statement.")

            print("Finally, type in the employee´s schedule in the next format: XX:XX A.M - XX:XX P.M ")
            schedule = input()
            Employee(name, last_name, birth_date, start_date, rfc, curp, salary, rol, schedule)
            print("Employee successfully added. ")

        elif option == "2":
            print("You have selected the option to register Animal ")
            print("Type: ")
            type_animal = input()
            print("Birthday: ")
            birthday = input()
            print("Arrival date at the zoo: ")
            arrival_date = input()
            print("Weight: ")
            weight = float(input())
            print("Diseases")
            print("Number of diseases: ")
            number = int(input())
            diseases = []
            for i in range(number):
                disease = input("Disease {}:".format(i + 1))
                diseases.append(disease)

            feeding_frequency = input("Feeding frequency: ")
            feeding_type = input("Feeding type: ")
            vaccines = input("Has vaccines: ")
            aux = True
            if vaccines.lower() == "yes":
                aux = True
            else:
                aux = False
            zoo.add_animal(
                Animal(type_animal, birthday, arrival_date, weight, diseases, feeding_frequency, feeding_type,
                       vaccines))

        elif option == "3":
            print("You have selected the register a visitor option.")
            print("Please, type in the visitor's name:")
            name = input()
            print("Now, please type in the visitor's last name:")
            last_name = input()
            print("Now type in the visitor's birth date in the next format: XX/XX/XXXX")
            birth_date = input()
            print("Please, type in the visitor's CURP:")
            curp = input()
            print("Finally, type in today's date: XX/XX/XXXX")
            register_date = input()
            Visitor(name, last_name, birth_date, curp, register_date)
            print("Visitor succesfully registered! ")

        elif option == "4":
            e = 0
            a = 0
            nab = []
            print("You selected add visit")
            print("Select the Guide.")
            while True:
                i = 0
                for employee in zoo.get_employees():
                    if employee.get_rol() == "Guide.":
                        print(f"[{i}] {employee.get_name()} {employee.get_last_name()}")
                    else:
                        nab.append(i)
                    i += 1

                e = int(input("Enter your option: "))
                if e >= len(zoo.get_employees()) or e < 0 or e in nab:
                    print("Invalid option.")
                else:
                    break
            nab.clear()

            print("Select the main visitor.")
            while True:
                i = 0
                for visitor in zoo.get_visitors():
                    print(f"[{i}] {visitor.get_name()} {visitor.get_last_name()}")
                    i += 1

                a = int(input("Enter your option: "))
                if a >= len(zoo.get_visitors()) or a < 0:
                    print("Invalid option.")
                else:
                    nab.append(a)
                    break

            visit_date = input("Enter date with format XX/XX/XXXX: ")
            zoo.add_visit(Visit(zoo.get_employees()[e], zoo.get_visitors()[a], visit_date))

            while True:
                print(f"Add visitors to visit {len(zoo.get_visitors())}, to exit: ")
                i = 0
                for visitor in zoo.get_visitors():
                    if i not in nab:
                        print(f"[{i}] {visitor.get_name()} {visitor.get_last_name()}")
                    i += 1

                e = int(input("Enter your option: "))
                if e > len(zoo.get_visitors()) or e < 0 or e in nab:
                    print("Non valid option.")
                elif e == len(zoo.get_visitors()):
                    break
                else:
                    zoo.get_visits()[len(zoo.get_visits()) - 1].add_visitor(zoo.get_visitors()[e])
                    nab.append(e)

            nab.clear()

        elif option == "5":
            e = 0
            a = 0
            nab = []
            print("Select the maintenance staff.")
            while True:
                i = 0
                for employee in zoo.get_employees():
                    if employee.get_rol() == "Maintenance staff.":
                        print(f"[{i}] {employee.get_name()} {employee.get_last_name()}")
                    else:
                        nab.append(i)
                    i += 1

                e = int(input("Enter your option: "))
                if e >= len(zoo.get_employees()) or e < 0 or e in nab:
                    print("Invalid option.")
                else:
                    break
            nab.clear()

            while True:
                i = 0
                for animal in zoo.get_animals():
                    print(f"[{i}] ID: {animal.get_id()} Type: {animal.get_type_animal()}")
                    i += 1

                a = int(input("Enter your option: "))
                if a >= len(zoo.get_animals()) or a < 0:
                    print("Invalid option.")
                else:
                    break

            procedure = input("Enter the procedure: ")
            procedure_date = input("Enter date with format XX/XX/XXXX: ")
            o = input("Is there observations [Y]Yes [N]No: ")
            if o == "Y":
                observation = input("What is the observation: ")
                zoo.add_maintenance(Maintenance(zoo.get_employees()[e], zoo.get_animals()[a], procedure,
                                                procedure_date, observation))
            else:
                zoo.add_maintenance(
                    Maintenance(zoo.get_employees()[e], zoo.get_animals()[a], procedure, procedure_date))

        elif option == "6":
            nab = []
            print("You have selected the add visitor to a visit option. ")
            print("Please, select the visit to which you want to add a visitor. ")
            while True:
                print("Select the visit: ")
                for i, visit in enumerate(zoo.get_visits()):
                    print(f"[{i}] Guided by: {visit.get_guide().get_name()} In: {visit.get_date_visit()}")
                a = int(input("Enter your option: "))
                if a < 0 or a >= len(zoo.get_visits()):
                    print("NON VALID OPTION.")
                else:
                    break
            for i, visitor in enumerate(zoo.get_visitors()):
                if zoo.get_visitors()[i] in zoo.get_visits()[a].get_visitors():
                    nab.append(i)

            print("Please, select the visitor you want to add. ")
            while True:
                print(f"{len(zoo.get_visitors())} To exit.")
                for i, visitor in enumerate(zoo.get_visitors()):
                    if i not in nab:
                        print(f"[{i}] {zoo.get_visitors()[i].get_name()} {zoo.get_visitors()[i].get_last_name()}")
                e = int(input("Enter your option: "))
                if e > len(zoo.get_visitors()) or e < 0 or e in nab:
                    print("NON VALID OPTION. ")
                elif e == len(zoo.get_visitors()):
                    break
                else:
                    zoo.get_visits()[a].add_visitor(zoo.get_visitors()[e])
                    nab.append(e)
            nab.clear()

            print("Visitor successfully added. ")

        elif option == "7":
            print("You have selected the employee option, now please choose what you want to do: ")
            bandi = True
            while bandi:
                print("[A] Show all employees.")
                print("[B] Remove an employee.")
                print("[C] Change an employee's salary.")
                print("[D] Exit from the employee's menu.")
                c = input("Enter your choice: ")[0].upper()

                if c == 'A':
                    zoo.show_all_employees()
                elif c == 'B':
                    bandf = False
                    while True:
                        for i, employee in enumerate(zoo.get_employees()):
                            print(f"[{i}] Name: {employee.get_name()} Last Name: {employee.get_last_name()}")
                        opt = int(input("Select your option. "))
                        if opt >= len(zoo.get_employees()) or opt < 0:
                            print("NON VALID OPTION. ")
                        else:
                            for i, employee in enumerate(zoo.get_visits()):
                                if (zoo.get_maintenances().__getitem__(i).get_employee() == zoo.get_employees().__getitem__(opt) or
                                        zoo.get_visits().__getitem__(i).get_guide() == zoo.get_employees().__getitem__(opt)):
                                    print("Can´t remove employee. ")
                                    bandf = True
                            break
                    if not bandf:
                        zoo.remove_employee(opt)
                    print("Employee succesfully removed. ")
                    break
                elif c == 'C':
                    while True:
                        for i, employee in enumerate(zoo.get_employees()):
                            print(f"[{i}] Name: {employee.get_name()} Last Name: {employee.get_last_name()}")
                        opt = int(input("Select your option. "))
                        if opt >= len(zoo.get_employees()()) or opt < 0:
                            print("NON VALID OPTION. ")
                        else:
                            break
                    zoo.show_a_employee(opt)
                    new_salary = float(input("What is the new salary for the selected employee. "))
                    zoo.change_employee_salary(opt, new_salary)
                    print("Salary succesfully changed. ")
                elif c == 'D':
                    break
                else:
                    print("Invalid choice. Please enter A, B, C, or D.")

        elif option == "8":
            print("You have selected the employee option, now please choose what you want to do: ")
            bands = True
            while True:
                print("[A] Show all visitors. ")
                print("[B] Remove a visitor. ")
                print("[C]. Exit from visitor´s menu.")
                g = input()
                if g == "A":
                    zoo.show_visitors()

                elif g == "B":
                    while True:
                        i = 0
                        for visitor in zoo.get_visitors():
                            print(f"[{i}] {zoo.get_visitors()[i].get_name()} {zoo.get_visitors()[i].get_last_name()}")
                            i += 1
                        e = int(input("Enter your option: "))
                        if e >= len(zoo.get_visitors()) or e < 0:
                            print("Non valid option.")
                        else:
                            bandf = False
                            for i, visits in enumerate(zoo.get_visits()):
                                if zoo.get_visitors()[e] in zoo.get_visits()[i].get_visitors():
                                    print("Can't remove visitor because is in a visit.")
                                    bandf = True
                                    break

                            if not bandf:
                                zoo.get_visitors().pop(e)
                                break

                elif g == "C":
                    break

        elif option == "9":
            while True:
                print("*** Animal Options ***")
                print("1. Modify Animal")
                print("2. Delete Animal ")
                print("3. Show Animal")
                print("4. EXIT")

                print("¿Which option do you want to use?")
                option_use = int(input())
                print()

                if option_use == 1:
                    print(f"You have selected the option to modify Animal ")
                    zoo.show_animals()
                    print("Enter the index of the animal to Modify weight")
                    index1 = int(input())
                    print("Enter the new weight")
                    weight_modify = float(input())
                    zoo.modify_weight(index1, weight_modify)
                elif option_use == 2:
                    print("You have selected the option to delete Animal")
                    zoo.show_animals()
                    print("Enter the index of the animal to eliminate")
                    index_remove = int(input())
                    band_z = False
                    for maintenance in zoo.get_maintenances():
                        if maintenance.get_animal() == zoo.get_animals()[index_remove]:
                            print("Can't remove animal because it is associated with maintenance.")
                            band_z = True
                            break
                    if not band_z:
                        zoo.remove_animal(index_remove)
                elif option_use == 3:
                    print("You have selected the option to show Animal")
                    zoo.show_animals()
                elif option_use == 4:
                    print("You have selected the option to Exit")
                    break
                else:
                    print("Invalid option. Please choose a valid option.")

        elif option == "10":
            zoo.show_visits()

        elif option == "11":
            zoo.show_maintenances()

        elif option == "12":
            print("Leaving the program...")