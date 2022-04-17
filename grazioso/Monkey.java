public class Monkey extends RescueAnimal {

    // Instance variable
    private String species;
    private String tailLength;
    private String height;
    private String bodyLength;

    // Constructor
    public Monkey(String name, String species, String gender, String age,
                  String weight, String acquisitionDate, String acquisitionCountry,
                  String trainingStatus, boolean reserved, String inServiceCountry,
                  String tailLength, String bodyLength, String height) {
        setName(name);
        setSpecies(species);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);
        setTailLength(tailLength);
        setBodyLength(bodyLength);
        setHeight(height);
    }
    // Default constructor
    public Monkey() {
    }
    // Accessor and Mutator Methods
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String monkeySpecies) {
        species = monkeySpecies;
    }
    public String getTailLength() {
        return tailLength;
    }
    public void setTailLength(String tailLength) {
        this.tailLength = tailLength;
    }
    public String getHeight() {
        return height;
    }
    public void setHeight(String height) {
        this.height = height;
    }
    public String getBodyLength() {
        return bodyLength;
    }
    public void setBodyLength(String bodyLength) {
        this.bodyLength = bodyLength;
    }
    // toString Method
    public String toString() {
        return "Name: " + this.getName() +
                ", Breed: " + this.getSpecies() +
                ", Gender: " + this.getGender() +
                ", Age: " + this.getAge() +
                ", Weight: " + this.getWeight() +
                ", Date Acquired: " + this.getAcquisitionDate() +
                ", Country Origin: " + this.getAcquisitionLocation() +
                ", Training Status: " + this.getTrainingStatus() +
                ", Reserved: " + this.getReserved() +
                ", Service Location: " + this.getInServiceLocation() +
                ", Tail Length: " + this.getTailLength() +
                ", Body Length: " + this.getBodyLength() +
                ", Height: " + this.getHeight() + ".";
    }
}
