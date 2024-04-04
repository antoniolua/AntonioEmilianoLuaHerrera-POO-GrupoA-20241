public class Employee {

    private String name;
    private String lastName;
    private String birthDate;
    private String startDate;
    private String RFC;
    private String CURP;
    private double salary;
    private String rol;
    private String schedule;


    public Employee(String name, String lastName, String birthDate, String startDate, String RFC, String CURP, double salary, String rol, String schedule) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.startDate = startDate;
        this.RFC = RFC;
        this.CURP = CURP;
        this.salary = salary;
        this.rol = rol;
        this.schedule = schedule;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}