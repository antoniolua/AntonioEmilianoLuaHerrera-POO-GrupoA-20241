import java.util.ArrayList;

public class Zoo {
    private static final String password ="cuchurrumin1235";

    private static ArrayList<Employee> employees = new ArrayList<>();
    private static ArrayList<Visitor> visitors = new ArrayList<>();

    private static ArrayList<Animal> AnimalArrayList=new ArrayList<>();
    private static ArrayList<Visit> visits=new ArrayList<>();
    private static ArrayList<Maintenance> maintenances = new ArrayList<>();

    //ANIMALS
    Animal animal=new Animal();
    String[] diseases= animal.getDiseases();
    public static void addAnimal(Animal animal){
        AnimalArrayList.add(animal);
        System.out.println("Animal added successfully");
        System.out.println();
    }
    public static void showAnimals(){
        for (int i = 0; i <AnimalArrayList.size(); i++) {
            System.out.print("["+(i)+"]"+".\n-Type: "+AnimalArrayList.get(i).getTypeAnimal()+"\n-Birthday: "+AnimalArrayList.get(i).getBirthdate()+"\n-Arrival date at the zoo: "+AnimalArrayList.get(i).getArrivalDate()+"\n-Weight: "+ AnimalArrayList.get(i).getWeight()+"\n-Feeding frequency: "+AnimalArrayList.get(i).getFeedingFrequency()+"\n-Feeding type: "+AnimalArrayList.get(i).getFeedingType()+"\n-Has vaccines: "+AnimalArrayList.get(i).isVaccines());
            String[] diseases = AnimalArrayList.get(i).getDiseases(); // Obtener las enfermedades del animal
            System.out.println();
            System.out.println("Diseases");
            for (int j = 0; j < diseases.length; j++) {
                System.out.println((j + 1) + "-" + diseases[j]);
            }
        }
    }
    public static void removeAnimal(int index){
        AnimalArrayList.remove(index);
    }

    public static void modifyWeight(int index,double weight){
        Animal animal= AnimalArrayList.get(index);
        animal.setWeight(weight);
    }

    //VISITS
    public static void addVisit(Visit visit){
        visits.add(visit);
        System.out.println("Visit added successfully");
    }

    public static void showVisits(){
        for (Visit visit: visits){
            System.out.printf("Visit guided by %s %s, made in %s. \n" +
                            "Total price of the visit: %f, formed by %d children and %d adults.",visit.getGuide().getName(),visit.getGuide().getLastName(),visit.getDateVisit(),
                    visit.calculateTotalPrice(),visit.getNumberChildren(),visit.getNumberAdults());
        }
    }


    //EMPLOYEES
    public static void addEmployee(Employee employee){
        employees.add(employee);
    }

    public static void showAllEmployees(){
        for (Employee employee: employees){
            System.out.printf("Employee %s %s, born %s, started working in %s. \n" +
                            "RFC: %s. CURP: %s. \n" +
                            "Salary: %f. Rol: %s. Schedule: %s. \n", employee.getName(),employee.getLastName(), employee.getBirthDate(),employee.getStartDate(),employee.getRFC()
                    ,employee.getCURP(),employee.getSalary(),employee.getRol(),employee.getSchedule());
        }
    }

    public static void showAEmployee(int index){
        Employee employee=employees.get(index);
        System.out.printf("Employee %s %s, born %s, started working in %s. \n" +
                        "RFC: %s. CURP: %s. \n" +
                        "Salary: %f. Rol: %s. Schedule: %s. \n", employee.getName(),employee.getLastName(), employee.getBirthDate(),employee.getStartDate(),employee.getRFC()
                ,employee.getCURP(),employee.getSalary(),employee.getRol(),employee.getSchedule());
    }


    public static void removeEmploye(int index){
        employees.remove(index);
    }

    public static void changeEmployeeSalary(int index,double salary){
        Employee employee= employees.get(index);
        employee.setSalary(salary);
    }

    public static void changeEmployeeSchedule(int index,String schedule){
        Employee employee= employees.get(index);
        employee.setSchedule(schedule);
    }


    //VISITORS
    public static void addVisitor(Visitor visitor){
        visitors.add(visitor);
    }

    public static void showAllVisitors(){
        for (Visitor visitor: visitors){
            System.out.printf("Visitor %s %s, born %s. \n" +
                            "CURP: %s.\n",
                    visitor.getName(), visitor.getLastName(), visitor.getBirthDate(), visitor.getCURP());
        }
    }

    public static void showAVisitor(int index){
        Visitor visitor= visitors.get(index);
        System.out.printf("Visitor %s %s, born %s.\n" +
                        "CURP: %s.\n",
                visitor.getName(), visitor.getLastName(), visitor.getBirthDate(), visitor.getCURP());

    }

    public static void changeVisitorAge(int index, String age){
        Visitor visitor= visitors.get(index);
        visitor.setBirthDate(age);
    }

    public static ArrayList<Maintenance> getMaintenances() {
        return maintenances;
    }

    public static ArrayList<Employee> getEmployees() {
        return employees;
    }

    public static ArrayList<Visitor> getVisitors() {
        return visitors;
    }

    public static ArrayList<Animal> getAnimals() {
        return AnimalArrayList;
    }

    public static ArrayList<Visit> getVisits(){
        return visits;
    }
    public static void addMaintenance(Maintenance maintenance){
        maintenances.add(maintenance);
    }

    public static boolean checkPassword(String word){
        if (word.equals(password)){
            return true;

        }else{
            return false;
        }
    }

    public static void showMaintenance(){
        for (Maintenance maintenance: maintenances){
            System.out.printf("\n Maintenance made by %s %s, on %s, in which the procedure was: %s. (Optional) Observations: %s",maintenance.getEmployee().getName(),maintenance.getEmployee().getLastName()
                    ,maintenance.getProcedureDate(),maintenance.getProcedure(),maintenance.getObservations());
        }
    }


}