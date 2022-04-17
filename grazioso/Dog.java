public class Dog extends RescueAnimal {

    // Instance variable
    private String breed;

    // Constructor
    public Dog(String name, String breed, String gender, String age,
               String weight, String acquisitionDate, String acquisitionCountry,
               String trainingStatus, boolean reserved, String inServiceCountry) {
        setName(name);
        setBreed(breed);
        setGender(gender);
        setAge(age);
        setWeight(weight);
        setAcquisitionDate(acquisitionDate);
        setAcquisitionLocation(acquisitionCountry);
        setTrainingStatus(trainingStatus);
        setReserved(reserved);
        setInServiceCountry(inServiceCountry);

    }
    // Default constructor
    public Dog() {
    }
    // Accessor and Mutator Method
    public String getBreed() {
        return breed;
    }
    public void setBreed(String dogBreed) {
        breed = dogBreed;
    }
    // toString Method
    public String toString() {
        return "Name: " + this.getName() +
                ", Breed: " + this.getBreed() +
                ", Gender: " + this.getGender() +
                ", Age: " + this.getAge() +
                ", Weight: " + this.getWeight() +
                ", Date Acquired: " + this.getAcquisitionDate() +
                ", Country Origin: " + this.getAcquisitionLocation() +
                ", Training Status: " + this.getTrainingStatus() +
                ", Reserved: " + this.getReserved() +
                ", Service Location: " + this.getInServiceLocation() + ".";
    }
}
