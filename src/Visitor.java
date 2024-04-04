public class Visitor {

    private String name;
    private String lastName;
    private String birthDate;
    private String CURP;
    private int visitNumber;
    private String registerDate;


    public Visitor(String name, String lastName, String birthDate, String CURP) {
        this.name = name;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.CURP = CURP;
        this.visitNumber=0;
    }

    public boolean checkAdult(){
        boolean band;
        String[] age= this.birthDate.split("/");
        String year=age[2];
        int IntYear = Integer.parseInt(year);
        int op= 2024-IntYear;
        if (op<18){
            band = false;
        } else {
            band=true;
        }
        return band;
    }

    public void addVisit(){
        this.visitNumber+=1;
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

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public int getVisitNumber() {
        return visitNumber;
    }

    public void setVisitNumber(int visitNumber) {
        this.visitNumber += visitNumber;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }
}