import java.util.ArrayList;

public class Visit {

    private ArrayList<Visitor> visitors;
    private double totalCost;
    private String dateVisit;
    private Employee guide;
    private int numberChildren=0;
    private int numberAdults=0;

    public Visit(Employee employee, Visitor visitor, String dateVisit) {
        this.guide = employee;
        this.visitors = new ArrayList<>(); // Inicializamos el ArrayList
        this.visitors.add(visitor);
        visitor.addVisit();
        this.dateVisit = dateVisit;
        this.totalCost=0;

    }

    public int getNumberPeople(){
        return visitors.size();
    }

    public void addVisitor(Visitor visitor){
        boolean band=false;
        for (Visitor visitor1: visitors){
            if (visitor1==visitor){
                System.out.println("VISITOR ALREADY EXISTS IN THE VISIT.");
                band=true;
                break;
            }
        }
        if (!band){
            this.visitors.add(visitor);
            visitor.setVisitNumber(1);
        }

    }

    public double calculateTotalPrice(){
        for (Visitor visitor: visitors){
            int total=visitor.getVisitNumber();
            if (total==5){
                if (visitor.checkAdult()){
                    totalCost+= (float) (100.0*0.8);
                } else{
                    totalCost+= (float) (50.0*0.8);
                }
                visitor.setVisitNumber(0);
            } else{
                if (visitor.checkAdult()){
                    totalCost+= 100.0;
                } else{
                    totalCost+= 50.0;
                }
            }
        }
        return totalCost;
    }

    public String getDateVisit() {
        return dateVisit;
    }

    public void setDateVisit(String dateVisit) {
        this.dateVisit = dateVisit;
    }

    public Employee getGuide() {
        return guide;
    }

    public void setGuide(Employee guide) {
        this.guide = guide;
    }

    public int getNumberChildren() {
        for (Visitor visitor: visitors){
            boolean band=false;
            band = visitor.checkAdult();
            if (!band){
                this.numberChildren+=1;
            }
        }
        return numberChildren;
    }

    public void setNumberChildren(int numberChildren) {
        this.numberChildren = numberChildren;
    }

    public int getNumberAdults() {
        for (Visitor visitor: visitors){
            boolean band=false;
            band = visitor.checkAdult();
            if (band){
                this.numberAdults+=1;
            }
        }
        return numberAdults;
    }

    public void setNumberAdults(int numberAdults) {
        this.numberAdults = numberAdults;
    }
    public ArrayList<Visitor> getVisitors(){
        return visitors;
    }
}
