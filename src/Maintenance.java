public class Maintenance {
    private Employee employee;
    private Animal animal;
    private String procedure;
    private String procedureDate;
    private String observations;

    public Maintenance(Employee employee, Animal animal, String procedure, String procedureDate) {
        this.employee = employee;
        this.animal = animal;
        this.procedure = procedure;
        this.procedureDate = procedureDate;
    }

    public Maintenance(Employee employee, Animal animal, String procedure, String procedureDate, String observations) {
        this.employee = employee;
        this.animal = animal;
        this.procedure = procedure;
        this.procedureDate = procedureDate;
        this.observations = observations;
    }
    public String consult(){
        if(observations == null){
            return "Employee: "+employee.getName()+"\nAnimal ID: "+animal.getId()+"\nProcedure: "+procedure+"\nDate: "+procedureDate;
        }else{
            return "Employee: "+employee.getName()+"\nAnimal ID: "+animal.getId()+"\nProcedure: "+procedure+"\nDate: "+procedureDate+"\nObservations: "+observations;
        }

    }
    public Employee getEmployee(){
        return employee;
    }

    public Animal getAnimal(){
        return animal;
    }

    public String getProcedure() {
        return procedure;
    }

    public String getProcedureDate() {
        return procedureDate;
    }

    public String getObservations() {
        return observations;
    }
}