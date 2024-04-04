import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int e = 0;
        int a = 0;
        String rol = "";
        int option;
        ArrayList<Integer> nab = new ArrayList<>();
        boolean band = true;
        String curp = "", name = "", last_name = "", birth_date = "";
        int cont=0;
        String password = "";


        System.out.println("Welcome to the zoo system, please enter the password in order to access to the menu, you have 5 tries.");
        do {
            System.out.println("Try number: "+cont);
            password = read.nextLine();
            cont++;
            if (cont==5){
                System.out.println("YOU ARE NOT THE ADMINISTRATOR, YOU ARE BEING EXPELLED.");
                System.exit(69);
            }
        } while(!Zoo.checkPassword(password));

        System.out.println("WELCOME TO THE SYSTEM, ADMINISTRATOR.");
        do {
            System.out.println();
            System.out.println("Select an option:");
            System.out.println("1. Add employe");
            System.out.println("2. Add Animal");
            System.out.println("3. Add visitor.");
            System.out.println("4. Add visit.");
            System.out.println("5. Add maintenance");
            System.out.println("6. Add visitor to a visit.");
            System.out.println("7. Employee option. ");
            System.out.println("8. Visitors option. ");
            System.out.println("9. Animals option. ");
            System.out.println("10. Show all current visits. ");
            System.out.println("11. Show all current maintenance. ");
            System.out.println("12. Exit");

            String opc = read.nextLine();

            switch (opc) {
                case "1":
                    System.out.println("You have selected the option to register an employee, please type in his/her name:  ");
                    name = read.nextLine();
                    System.out.println("Now type in the employee's last name: ");
                    last_name = read.nextLine();
                    System.out.println("Now type in the employee's birth date in the next format: XX/XX/XXXX");
                    birth_date = read.nextLine();
                    System.out.println("Please now type the employee´s start working date in the same format: XX/XX/XXXX");
                    String start_date = read.nextLine();
                    System.out.println("Please, type in the employee´s RFC: ");
                    String rfc = read.nextLine();
                    System.out.println("Please, type in the employee´s CURP: ");
                    curp = read.nextLine();
                    System.out.println("Now, type in the employee's desired salary: ");
                    double salary = read.nextDouble();
                    do {
                        System.out.println("Now, please select a rol for the new employee, chose an option between the next list: \n" +
                                "[1]= Veterinary \n" +
                                "[2]= Guide \n" +
                                "[3]= Administrative staff \n" +
                                "[4]= Maintenance staff \n");
                        option = read.nextInt();
                        if (option == 1) {
                            rol = "Veterinary.";
                        } else if (option == 2) {
                            rol = "Guide.";
                        } else if (option == 3) {
                            rol = "Administrative staff.";
                        } else if (option == 4) {
                            rol = "Maintenance staff.";
                        } else {
                            System.out.println("False statement.");
                        }
                    } while (option != 1 && option != 2 && option != 3 && option != 4);
                    read.nextLine();
                    System.out.println("Finally, type in the employee´s schedule in the next format: XX:XX A.M - XX:XX P.M ");
                    String schedule = read.nextLine();
                    Zoo.addEmployee(new Employee(name, last_name, birth_date, start_date, rfc, curp, salary, rol, schedule));
                    System.out.println("Employee succesfully added.");
                    break;
                case "2":
                    System.out.println("You selected 'Add Animal'");
                    //ADD Animal
                    System.out.println("Add animal");
                    System.out.print("Type: ");
                    String type = read.nextLine();
                    System.out.print("Birthday: ");
                    String birthday = read.nextLine();
                    System.out.print("Arrival date at the zoo using the next format XX/XX/XXXX: ");
                    String arrivalDate = read.nextLine();
                    System.out.print("Weight in kg (please enter the number only): ");
                    double weight = read.nextDouble();
                    System.out.print("Diseases: ");
                    System.out.println("Number of diseases");
                    int number = read.nextInt();
                    String[] diseases = new String[number];
                    read.nextLine();
                    for (int i = 0; i < diseases.length; i++) {
                        System.out.println("Disease " + (i + 1));
                        diseases[i] = read.nextLine();
                    }
                    System.out.println("Feeding frequency: (only the number)");
                    String feedingFrequency = read.nextLine();
                    System.out.println("Feeding type: (enter the type of food)");
                    String feedingType = read.nextLine();
                    System.out.println("Has vaccines (yes/no)");
                    String vaccines = read.nextLine();
                    boolean aux;
                    if (vaccines.equalsIgnoreCase("yes")) {
                        aux = true;
                    } else {
                        aux = false;
                    }
                    Zoo.addAnimal(new Animal(type, birthday, arrivalDate, weight, diseases, feedingFrequency, feedingType, aux));
                    System.out.println("Animal succesfully added. ");


                    break;
                case "3":
                    System.out.println("You have selected the register a visitor option. ");
                    System.out.println("Please, type in the visitor´s name: ");
                    name = read.nextLine();
                    System.out.println("Now, please type in the visitor's last name: ");
                    last_name = read.nextLine();
                    System.out.println("Now type in the visitor's birth date in the next format: XX/XX/XXXX");
                    birth_date = read.nextLine();
                    System.out.println("Please, type in the visitor´s CURP: ");
                    curp = read.nextLine();
                    Zoo.addVisitor(new Visitor(name, last_name, birth_date, curp));
                    System.out.println("Visitor added succesfully!");

                    break;
                case "4":
                    e = 0;
                    a = 0;
                    System.out.println("You selected add visit");
                    System.out.println("Select the Guide.");
                    do {
                        for (int i = 0; i < Zoo.getEmployees().size(); i++) {
                            if (Zoo.getEmployees().get(i).getRol().equals("Guide.")) {
                                System.out.printf("[%d] %s %s\n", i, Zoo.getEmployees().get(i).getName(), Zoo.getEmployees().get(i).getLastName());
                            } else {
                                nab.add(i);
                            }
                        }
                        System.out.print("Enter your option: ");
                        e = read.nextInt();
                        if (e >= Zoo.getEmployees().size() || e < 0 || nab.contains(e)) {
                            System.out.println("Non valid option.");
                        } else {
                            break;
                        }
                    } while (true);
                    nab.clear();

                    do {
                        System.out.println("Select the main visitor.");
                        for (int i = 0; i < Zoo.getVisitors().size(); i++) {
                            System.out.printf("[%d] %s %s\n", i, Zoo.getVisitors().get(i).getName(), Zoo.getVisitors().get(i).getLastName());
                        }
                        System.out.print("Enter your option: ");
                        a = read.nextInt();
                        if (a >= Zoo.getVisitors().size() || a < 0) {
                            System.out.println("Non valid option.");
                        } else {
                            nab.add(a);
                            break;
                        }
                    } while (true);

                    System.out.println("Enter date with format XX/XX/XXXX");
                    String visitDate = read.next();
                    Zoo.addVisit(new Visit(Zoo.getEmployees().get(e), Zoo.getVisitors().get(a), visitDate));
                    System.out.println("Add visitors: ");
                    do {
                        System.out.println(Zoo.getVisitors().size() + " To exit.");
                        for (int i = 0; i < Zoo.getVisitors().size(); i++) {
                            if (!nab.contains(i)) {
                                System.out.printf("[%d] %s %s\n", i, Zoo.getVisitors().get(i).getName(), Zoo.getVisitors().get(i).getLastName());
                            }
                        }
                        System.out.print("Enter your option: ");
                        e = read.nextInt();
                        if (e > Zoo.getVisitors().size() || e < 0 || nab.contains(e)) {
                            System.out.println("Non valid option.");
                        } else if (e == Zoo.getVisitors().size()) {
                            break;
                        } else {
                            Zoo.getVisits().getLast().addVisitor(Zoo.getVisitors().get(e));
                        }
                    } while (true);
                    nab.clear();
                    read.nextLine();

                    break;

                case "5":
                    e = 0;
                    a = 0;
                    System.out.println("Select the maintenance staff.");
                    do {
                        for (int i = 0; i < Zoo.getEmployees().size(); i++) {
                            if (Zoo.getEmployees().get(i).getRol().equals("Maintenance staff.")) {
                                System.out.printf("[%d] %s %s\n", i, Zoo.getEmployees().get(i).getName(), Zoo.getEmployees().get(i).getLastName());
                            } else {
                                nab.add(i);
                            }
                        }
                        System.out.print("Enter your option: ");
                        e = read.nextInt();
                        if (e >= Zoo.getEmployees().size() || e < 0 || nab.contains(e)) {
                            System.out.println("Non valid option.");
                        } else {
                            break;
                        }
                    } while (true);
                    nab.clear();

                    do {
                        System.out.println("Select the animal");
                        for (int i = 0; i < Zoo.getAnimals().size(); i++) {
                            System.out.printf("[%d] ID: %d Type: %s\n", i, Zoo.getAnimals().get(i).getId(), Zoo.getAnimals().get(i).getTypeAnimal());
                        }
                        System.out.print("Enter your option: ");
                        a = read.nextInt();
                        if (a >= Zoo.getAnimals().size() || a < 0) {
                            System.out.println("Non valid option.");
                        } else {
                            break;
                        }
                    } while (true);
                    read.nextLine();

                    System.out.println("Enter the procedure: ");
                    String procedure = read.nextLine();
                    System.out.println("Enter date with format XX/XX/XXXX: ");
                    String procedureDate = read.nextLine();
                    System.out.println("Is there observations [Y]Yes [N]No: ");
                    char o = read.next().charAt(0);
                    if (o == 'Y') {
                        System.out.println("What is the observation: ");
                        read.nextLine();
                        String observations = read.nextLine();
                        Zoo.addMaintenance(new Maintenance(Zoo.getEmployees().get(e), Zoo.getAnimals().get(a), procedure, procedureDate, observations));
                        System.out.println("Maintenance added. ");
                    } else {
                        Zoo.addMaintenance(new Maintenance(Zoo.getEmployees().get(e), Zoo.getAnimals().get(a), procedure, procedureDate));
                        System.out.println("Maintenance added. ");
                    }
                    read.nextLine();
                    break;
                case "6":
                    System.out.println("You have selected the add visitor to a visit option. ");
                    System.out.println("Please, select the visit to which you want to add a visitor. ");
                    do {
                        System.out.println("Select the visit.");
                        for (int i = 0; i < Zoo.getVisits().size(); i++) {
                            System.out.printf("[%d] Visit guided by: %s %s Made in: %s with a number of: %d\n", i, Zoo.getVisits().get(i).getGuide().getName(),Zoo.getVisits().get(i).getGuide().getLastName(), Zoo.getVisits().get(i).getDateVisit(), Zoo.getVisits().get(i).getNumberPeople());
                        }
                        System.out.print("Enter your option: ");
                        a = read.nextInt();
                        if (a >= Zoo.getVisitors().size() || a < 0) {
                            System.out.println("Non valid option.");
                        } else {
                            break;
                        }
                    } while (true);
                    Visit visit = Zoo.getVisits().get(a);
                    for (int i = 0; i < Zoo.getVisitors().size(); i++) {
                        if (Zoo.getVisits().get(a).getVisitors().contains(Zoo.getVisitors().get(i))){
                            nab.add(i);
                        }
                    }
                    System.out.println("Please, select the visitor you want to add. ");
                    do {
                        System.out.println(Zoo.getVisitors().size() + " To exit.");
                        for (int i = 0; i < Zoo.getVisitors().size(); i++) {
                            if (!nab.contains(i)) {
                                System.out.printf("[%d] %s %s\n", i, Zoo.getVisitors().get(i).getName(), Zoo.getVisitors().get(i).getLastName());
                            }
                        }
                        System.out.print("Enter your option: ");
                        e = read.nextInt();
                        if (e > Zoo.getVisitors().size() || e < 0 || nab.contains(e)) {
                            System.out.println("Non valid option.");
                        } else if (e == Zoo.getVisitors().size()) {
                            break;
                        } else {
                            Zoo.getVisits().get(a).addVisitor(Zoo.getVisitors().get(e));
                        }
                    } while (true);
                    nab.clear();
                    read.nextLine();
                    System.out.println("Visitor succesfully added. ");

                    break;
                case "7":
                    System.out.println("You have selected the employee option, now please choose what you want to do: ");
                    boolean bandi = true;
                    do {
                        System.out.println("[A] Show all employees. ");
                        System.out.println("[B] Remove a employee. ");
                        System.out.println("[C] Change a employee´s salary.");
                        System.out.println("[D]. Exit from employee´s menu.");
                        char c = read.next().charAt(0);

                        switch (c) {
                            case 'A':
                                Zoo.showAllEmployees();
                                break;
                            case 'B':
                                boolean bandf = false;
                                do {
                                    for (int i = 0; i < Zoo.getEmployees().size(); i++) {
                                        System.out.printf("[%d] %s %s\n", i, Zoo.getEmployees().get(i).getName(), Zoo.getEmployees().get(i).getLastName());
                                    }
                                    System.out.print("Enter your option: ");
                                    e = read.nextInt();
                                    if (e >= Zoo.getEmployees().size() || e < 0) {
                                        System.out.println("Non valid option.");
                                    } else {

                                        for (int i = 0; i < Zoo.getVisits().size(); i++) {
                                            if (Zoo.getMaintenances().get(i).getEmployee() == Zoo.getEmployees().get(e) || Zoo.getVisits().get(i).getGuide() == Zoo.getEmployees().get(e)) {
                                                System.out.println("Can't remove employee.");
                                                bandf = true;
                                            }
                                        }
                                        break;
                                    }
                                } while (true);
                                if (!bandf){
                                    Zoo.removeEmploye(e);
                                }
                                System.out.println("Employee succesfully removed. ");
                                break;
                            case 'C':
                                do {
                                    for (int i = 0; i < Zoo.getEmployees().size(); i++) {
                                        System.out.printf("[%d] %s %s\n", i, Zoo.getEmployees().get(i).getName(), Zoo.getEmployees().get(i).getLastName());
                                    }
                                    System.out.print("Enter your option: ");
                                    e = read.nextInt();
                                    if (e >= Zoo.getEmployees().size() || e < 0) {
                                        System.out.println("Non valid option.");
                                    } else {
                                        break;
                                    }
                                } while (true);
                                Zoo.showAEmployee(e);
                                System.out.println("What is the new salary you want to give to this employee? ");
                                double salary_ = read.nextDouble();
                                Zoo.changeEmployeeSalary(e, salary_);
                                System.out.println("Salary succesfully changed. ");
                                break;
                            case 'D':
                                bandi = false;
                                break;
                        }


                    } while (bandi);
                    break;

                case "8":
                    System.out.println("You have selected the Visitor option, now please choose what you want to do: ");
                    boolean bands = true;
                    do {
                        System.out.println("[A] Show all visitors. ");
                        System.out.println("[B] Remove a visitor. ");
                        System.out.println("[C]. Exit from visitor´s menu.");
                        char g = read.next().charAt(0);

                        switch (g) {
                            case 'A':
                                Zoo.showAllVisitors();
                                break;
                            case 'B':
                                do {
                                    for (int i = 0; i < Zoo.getVisitors().size(); i++) {
                                        System.out.printf("[%d] %s %s\n", i, Zoo.getVisitors().get(i).getName(), Zoo.getVisitors().get(i).getLastName());
                                    }
                                    e = read.nextInt();
                                    if (e >= Zoo.getVisitors().size() || e < 0) {
                                        System.out.println("Non valid option.");
                                    } else {
                                        boolean bandf = false;
                                        for (int i = 0; i < Zoo.getVisits().size(); i++) {
                                            if (Zoo.getVisits().get(i).getVisitors().contains(Zoo.getVisitors().get(e))) {
                                                System.out.println("Can't remove visitor because is in a visit.");
                                                bandf = true;
                                                break;
                                            }
                                        }
                                        if (!bandf) {
                                            Zoo.getVisitors().remove(e);
                                        }
                                        break;
                                    }
                                } while (true);
                                break;
                            case 'C':
                                break;
                        }

                    } while (bands);
                    break;

                case "9":
                    boolean bandw = true;
                    do {
                        System.out.println("*** Animal Options ***");
                        System.out.println("1. Modify Animal weight");
                        System.out.println("2. Delete Animal ");
                        System.out.println("3. Show Animal");
                        System.out.println("4. Exit");
                        System.out.println("¿Which option do you want to use?");
                        int op = read.nextInt();


                        switch (op) {
                            case 1:
                                System.out.println("\nYou have selected the option to modify Animal weight");
                                Zoo.showAnimals();
                                System.out.println("Enter the index of the animal to Modify weight");
                                int index1 = read.nextInt();
                                System.out.println("Enter the new weight");
                                double weight1 = read.nextDouble();
                                Zoo.modifyWeight(index1,weight1);

                                break;
                            case 2:
                                System.out.println("\nYou have selected the option to delete Animal");
                                System.out.println("\n** Animals **");
                                Zoo.showAnimals();
                                System.out.println("Enter the index of the animal to remove");
                                int index = read.nextInt();
                                boolean bandz = false;
                                for (int i = 0; i < Zoo.getAnimals().size(); i++) {
                                    if (Zoo.getMaintenances().get(i).getAnimal() == Zoo.getAnimals().get(i)) {
                                        System.out.println("Can't remove animal.");
                                        bandz = true;
                                    }
                                }
                                if(!bandz){
                                    Zoo.removeAnimal(index);
                                }
                                break;
                            case 3:
                                System.out.println("You have selected the option to show Animal");
                                Zoo.showAnimals();
                                break;
                            case 4 :
                                System.out.println("You have selected the option to Exit");
                                bandw = false;
                                break;
                        }

                    } while (bandw);
                    break;
                case "10":
                    Zoo.showVisits();
                    break;
                case "11":
                    Zoo.showMaintenance();
                    break;

                case "12":
                    System.out.println("Leaving the program...");
                    band = false;
                    break;
                default:
                    System.out.println("Invalid option");
            }

        } while (band);
    }
}
