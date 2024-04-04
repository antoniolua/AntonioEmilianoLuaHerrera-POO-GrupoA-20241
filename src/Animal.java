public class Animal {
    private static int count = 0;
    private long id;
    private String typeAnimal;
    private String birthdate;
    private String arrivalDate;
    private double weight;
    private String[] diseases ;
    private String feedingFrequency;
    private String feedingType;
    private boolean vaccines;

    public Animal(String typeAnimal, String birthdate, String arrivalDate, Double weight, String[] diseases, String feedingFrequency, String feedingType, Boolean vaccines) {
        this.typeAnimal = typeAnimal;
        this.birthdate = birthdate;
        this.arrivalDate = arrivalDate;
        this.weight = weight;
        this.diseases = diseases;
        this.feedingFrequency = feedingFrequency;
        this.feedingType = feedingType;
        this.vaccines = vaccines;
        this.id = count;
        count ++;
    }

    public Animal() {

    }

    public String getTypeAnimal() {
        return typeAnimal;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String[] getDiseases() {
        return diseases;
    }

    public String getFeedingFrequency() {
        return feedingFrequency;
    }

    public String getFeedingType() {
        return feedingType;
    }

    public boolean isVaccines() {
        return vaccines;
    }

    public long getId(){
        return this.id;
    }
}