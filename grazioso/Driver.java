import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    // arraylists
    private static final ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static final ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();


    // Instance variables (if needed)
    public static void main(String[] args) {
        boolean run = true;
        Scanner scnr = new Scanner(System.in);
        String userInput;
        initializeDogList();
        initializeMonkeyList();

        //while run loop for menu
        while (run) {
            displayMenu();
            userInput = scnr.nextLine();
            if (userInput.equalsIgnoreCase("q")) {
                run = false;
            }
            else if (userInput.equals("1")) {
                intakeNewDog(scnr);
            }
            else if (userInput.equals("2")) {
                intakeNewMonkey(scnr);
            }
            else if (userInput.equals("3")) {
                reserveAnimal(scnr);
            }
            else if (userInput.equals("4")) {
                printAnimals(scnr);
            }
            else {
                System.out.println("Invalid Input. Please refer to list provided.");
            }
        }
    }
    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] List of animals");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }

    // Add dogs to a list for testing
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6",
                "05-12-2019", "United States", "intake", false,
                "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2",
                "02-03-2020", "United States", "Phase I", false,
                "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6",
                "12-12-2019", "Canada", "in service", true,
                "Canada");

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);

    }
    // Add monkeys to a list for testing
    public static void initializeMonkeyList() {
        Monkey monkey1 = new Monkey("George", "Capuchin", "male", "1", "25.6",
                "06-12-2019", "United States", "intake", false,
                "United States", "15.5", "20", "15");
        Monkey monkey2 = new Monkey("Larry", "Guenon", "male", "3", "35.2",
                "03-03-2020", "United States", "Phase I", true,
                "Canada", "25", "19", "14");
        Monkey monkey3 = new Monkey("Cliff", "Macaque", "female", "4", "25.6",
                "12-1-2019", "Canada", "in service", true,
                "Canada", "8", "18", "14.5");

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);
    }

    // intake dog
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if (dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }
        Dog dog4 = new Dog();
        dog4.setName(name);
        // breed
        System.out.println("What breed is the dog?");
        System.out.println("Acceptable dog breeds are:\nGerman Shepard, Great Dane, or Chihuahua");
        String breed = scanner.nextLine();
        while (true) {
            if (breed.equalsIgnoreCase("german shepard")
                    || breed.equalsIgnoreCase("great dane")
                    || breed.equalsIgnoreCase("chihuahua")) {
                break;
            } else {
                System.out.println("""
                        Invalid Breed!
                        Accepted dog breeds are:\s
                        German Shepard, Great Dane, or Chihuahua""");
                breed = scanner.nextLine();
            }
        }
        dog4.setBreed(breed);
        // gender
        System.out.println("What gender is the dog?");
        String gender = scanner.nextLine();
        while (true) {
            if (gender.equalsIgnoreCase("male")
                    || gender.equalsIgnoreCase("female")) {
                break;
            } else {
                System.out.println("Invalid gender! Accepted genders" +
                        " are: Male or Female");
                gender = scanner.nextLine();
            }
        }
        dog4.setGender(gender);
        // age
        int age = 0;
        do {
            System.out.println("What is the age of the dog?");
            String input = scanner.nextLine();
            try {
                age = Integer.parseInt(input);
                if (age < 1) {
                    System.out.printf("\"%s\" is not a valid input. Dog is " +
                            "too young!%n", input);
                } else if (age > 12) {
                    System.out.printf("\"%s\" is not a valid input. Dog is " +
                            "too old!%n", input);
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid Input.\nPlease enter a number: ");
            }
        } while (true);
        String age2 = String.valueOf(age);
        dog4.setAge(age2);
        // weight
        String input;
        double weight = 0;
        do {
            System.out.println("What is the dogs weight in pounds? (lbs)");
            input = scanner.nextLine();
            try {
                weight = Double.parseDouble(input);
                if (weight < 10) {
                    System.out.printf("\"%s\" is not a valid input. Dog is " +
                            "too small to train!%n", input);
                } else if (weight > 200) {
                    System.out.printf("\"%s\" is not a valid input. Dog is " +
                            "too large to train!%n", input);
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid Input.\nPlease enter a number: ");
            }
        } while (true);
        String weight2 = String.valueOf(weight);
        dog4.setWeight(weight2);
        // date acquired
        int month = 0;
        int day = 0;
        int year = 0;
        System.out.println("Please enter the year of acquisition: ");
        while (year > 2022 || year < (2022 - age)) {
            input= scanner.nextLine();
            try {
                year = Integer.parseInt(input);
                if (year > 2022 || year < (2022 - age)) {
                    System.out.println("""
                            That year is not possible.
                            Potential problems are:
                            Year has not happened yet or the age of dog is to low to have that acquired year.\s""");
                }
                else {
                    break;
                }
            }
            catch (Exception e) {
                System.out.println("Invalid Input.\nPlease enter a number: ");
            }
        }
        System.out.println("Please enter the month of acquisition: ");
        while (true) {
            input = scanner.nextLine();
            try {
                month = Integer.parseInt(input);
                if (month < 1 || month > 12) {
                    System.out.println("Months are between 1-12");
                }
                else {
                    break;
                }
            }
            catch (Exception e) {
                System.out.println("Invalid Input.\nPlease enter a number: ");
            }
        }
        System.out.println("Please enter the day of acquisition: ");
        while (day < 1 || day > 31) {
            input = scanner.nextLine();
            try {
                day = Integer.parseInt(input);
                if (day < 1 || day > 31) {
                    System.out.println("Days are between 1-31.");
                } else if (month == 2 && day < 29) {
                    break;
                } else if (month == 4 && day <= 30) {
                    break;
                } else if (month == 6 && day <= 30) {
                    break;
                } else if (month == 9 && day <= 30) {
                    break;
                } else if (month == 11 && day <= 30) {
                    break;
                } else if (month == 2) {
                    while (true) {
                        if ((year % 4 == 0) && (day == 29)) {
                            break;
                        } else {
                            day = 0;
                            System.out.println("Invalid Date!\n" +
                                    "Please enter a valid day!");
                            day = scanner.nextInt();

                        }
                    }
                }
            }
            catch (Exception e) {
                System.out.println("Invalid Input.\nPlease enter a number: ");
            }
        }
        String year2 = String.valueOf(year);
        String month2 = String.valueOf(month);
        String day2 = String.valueOf(day);
        String date = String.join("-", month2, day2, year2);
        dog4.setAcquisitionDate(date);
        System.out.println("Accepted Date: " + date);
        // origin country
        System.out.println("Country of origin?");
        String country = scanner.nextLine();
        while (true) {
            if (country.equalsIgnoreCase("united states")
                    || country.equalsIgnoreCase("canada")) {
                break;
            }
            else {
                System.out.println("""
                        Invalid Country!
                        Accepted origins are:
                        United States and Canada""");
                country = scanner.nextLine();
            }
        }
        dog4.setAcquisitionLocation(country);
        // training status
        System.out.println("Training Status?");
        String train = scanner.nextLine();
        while (true) {
            if (train.equalsIgnoreCase("in service")
                    || train.equalsIgnoreCase("phase i")
                    || train.equalsIgnoreCase("phase ii")
                    || train.equalsIgnoreCase("phase iii")
                    || train.equalsIgnoreCase("phase iv")
                    || train.equalsIgnoreCase("phase v")
                    || train.equalsIgnoreCase("intake")
                    || train.equalsIgnoreCase("farm")) {
                break;
            }
            else {
                System.out.println("Invalid Status! Please enter: \n" +
                        "Intake, Phase I to Phase V, In Service, or Farm");
                train = scanner.nextLine();
            }
        }
        dog4.setTrainingStatus(train);
        // reserved status
        boolean reserved;
        System.out.println("Is the dog reserved? true or false");
        input = scanner.nextLine();
        while (true) {
            if (input.equalsIgnoreCase("true")
                    || input.equalsIgnoreCase("false")) {
                break;
            }
            else {
                System.out.println("Invalid Input.\nPlease enter true or false: ");
                input = scanner.nextLine();
            }
        }
        reserved = Boolean.parseBoolean(input);
        dog4.setReserved(reserved);
        // service location
        System.out.println("What is the service location? (country only)");
        String service = scanner.nextLine();
        while (true) {
            if (service.equalsIgnoreCase("united states")
                    || service.equalsIgnoreCase("canada")) {
                break;
            }
            else {
                System.out.println("Invalid Country! Available countries" +
                        " to service are: \nUnited States and Canada");
                service = scanner.nextLine();
            }
        }
        dog4.setInServiceCountry(service);
        System.out.println("Dog has been accepted! Thank you!");

        dogList.add(dog4);
    }

    // intake monkey
    public static void intakeNewMonkey(Scanner scanner) {
        // name
        System.out.println("What is the monkey's name?");
        String name = scanner.nextLine();
        for (Monkey monkey : monkeyList) {
            if (monkey.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis monkey is already in our system\n\n");
                return; //returns to menu
            }
        }
        Monkey monkey4 = new Monkey();
        monkey4.setName(name);
        // species
        System.out.println("What species is the monkey?");
        System.out.println("Accepted monkey species are:\nCapuchin, Marmoset, " +
                "Guenon, Macaque, Squirrel monkey, Tamarin");
        String species = scanner.nextLine();
        while (true) {
            if (species.equalsIgnoreCase("capuchin")
                    || species.equalsIgnoreCase("marmoset")
                    || species.equalsIgnoreCase("guenon")
                    || species.equalsIgnoreCase("macaque")
                    || species.equalsIgnoreCase("squirrel monkey")
                    || species.equalsIgnoreCase("tamarin")) {
                break;
            } else {
                System.out.println("""
                        Invalid Species!
                        Accepted monkey species are:\s
                        Capuchin, Marmoset, Guenon, Macaque, Squirrel monkey, Tamarin""");
                species = scanner.nextLine();
            }
        }
        monkey4.setSpecies(species);
        // gender
        System.out.println("What gender is the monkey?");
        String gender = scanner.nextLine();
        while (true) {
            if (gender.equalsIgnoreCase("male")
                    || gender.equalsIgnoreCase("female")) {
                break;
            } else {
                System.out.println("Invalid gender! Accepted genders" +
                        " are: Male or Female");
                gender = scanner.nextLine();
            }
        }
        monkey4.setGender(gender);
        // age
        int age = 0;
        do {
            System.out.println("What is the age of the monkey?");
            String input = scanner.nextLine();
            try {
                age = Integer.parseInt(input);
                if (age < 1) {
                    System.out.printf("\"%s\" is not a valid input. Monkey is " +
                            "too young!%n", input);
                } else if (age > 20) {
                    System.out.printf("\"%s\" is not a valid input. Monkey is " +
                            "too old!%n", input);
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid Input.\nPlease enter a number: ");
            }
        } while (true);
        String age2 = String.valueOf(age);
        monkey4.setAge(age2);
        // weight
        double weight = 0;
        do {
            System.out.println("What is the monkeys weight in pounds? (lbs)");
            String input = scanner.nextLine();
            try {
                weight = Double.parseDouble(input);
                if (weight < 5) {
                    System.out.printf("\"%s\" is not a valid input. Monkey is " +
                            "too small to train!%n", input);
                } else if (weight > 72) {
                    System.out.printf("\"%s\" is not a valid input. Monkey is " +
                            "too large to train!%n", input);
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid Input.\nPlease enter a number: ");
            }
        } while (true);
        String weight2 = String.valueOf(weight);
        monkey4.setWeight(weight2);
        // date acquired
        int month = 0;
        int day = 0;
        int year = 0;
        System.out.println("Please enter the year of acquisition: ");
        String input;
        while (year > 2022 || year < (2022 - age)) {
            input= scanner.nextLine();
            try {
                year = Integer.parseInt(input);
                if (year > 2022 || year < (2022 - age)) {
                    System.out.println("""
                            That year is not possible.
                            Potential problems are:
                            Year has not happened yet or the age of dog is to low to have that acquired year.\s""");
                }
                else {
                    break;
                }
            }
            catch (Exception e) {
                System.out.println("Invalid Input.\nPlease enter a number: ");
            }
        }
        System.out.println("Please enter the month of acquisition: ");
        while (true) {
            input = scanner.nextLine();
            try {
                month = Integer.parseInt(input);
                if (month < 1 || month > 12) {
                    System.out.println("Months are between 1-12");
                }
                else {
                    break;
                }
            }
            catch (Exception e) {
                System.out.println("Invalid Input.\nPlease enter a number: ");
            }
        }
        System.out.println("Please enter the day of acquisition: ");
        while (day < 1 || day > 31) {
            input = scanner.nextLine();
            try {
                day = Integer.parseInt(input);
                if (day < 1 || day > 31) {
                    System.out.println("Days are between 1-31.");
                } else if (month == 2 && day < 29) {
                    break;
                } else if (month == 4 && day <= 30) {
                    break;
                } else if (month == 6 && day <= 30) {
                    break;
                } else if (month == 9 && day <= 30) {
                    break;
                } else if (month == 11 && day <= 30) {
                    break;
                } else if (month == 2) {
                    while (true) {
                        if ((year % 4 == 0) && (day == 29)) {
                            break;
                        } else {
                            day = 0;
                            System.out.println("Invalid Date!\n" +
                                    "Please enter a valid day!");
                            day = scanner.nextInt();

                        }
                    }
                }
            }
            catch (Exception e) {
                System.out.println("Invalid Input.\nPlease enter a number: ");
            }
        }
        String year2 = String.valueOf(year);
        String month2 = String.valueOf(month);
        String day2 = String.valueOf(day);
        String date = String.join("-", month2, day2, year2);
        monkey4.setAcquisitionDate(date);
        System.out.println("Accepted Date: " + date);
        // origin country
        System.out.println("Country of origin?");
        String country = scanner.nextLine();
        while (true) {
            if (country.equalsIgnoreCase("united states")
                    || country.equalsIgnoreCase("canada")) {
                break;
            }
            else {
                System.out.println("""
                        Invalid Country!
                        Accepted origins are:
                        United States and Canada""");
                country = scanner.nextLine();
            }
        }
        monkey4.setAcquisitionLocation(country);
        // training status
        System.out.println("Training Status?");
        String train = scanner.nextLine();
        while (true) {
            if (train.equalsIgnoreCase("in service")
                    || train.equalsIgnoreCase("phase i")
                    || train.equalsIgnoreCase("phase ii")
                    || train.equalsIgnoreCase("phase iii")
                    || train.equalsIgnoreCase("phase iv")
                    || train.equalsIgnoreCase("phase v")
                    || train.equalsIgnoreCase("intake")
                    || train.equalsIgnoreCase("farm")) {
                break;
            }
            else {
                System.out.println("Invalid Status! Please enter: \n" +
                        "Intake, Phase I to Phase V, In Service, or Farm");
                train = scanner.nextLine();
            }
        }
        monkey4.setTrainingStatus(train);
        // reserved status
        boolean reserved;
        System.out.println("Is the monkey reserved? true or false");
        input = scanner.nextLine();
        while (true) {
            if (input.equalsIgnoreCase("true")
                    || input.equalsIgnoreCase("false")) {
                break;
            }
            else {
                System.out.println("Invalid Input.\nPlease enter true or false: ");
                input = scanner.nextLine();
            }
        }
        reserved = Boolean.parseBoolean(input);
        monkey4.setReserved(reserved);
        // service location
        System.out.println("What is the service location? (country only)");
        String service = scanner.nextLine();
        while (true) {
            if (service.equalsIgnoreCase("united states")
                    || service.equalsIgnoreCase("canada")) {
                break;
            }
            else {
                System.out.println("Invalid Country! Available countries" +
                        " to service are: \nUnited States and Canada");
                service = scanner.nextLine();
            }
        }
        monkey4.setInServiceCountry(service);
        // tail length
        double tail = 0;
        do {
            System.out.println("What is the tail length in inches?");
            String input4 = scanner.next();
            try {
                tail = Double.parseDouble(input4);
                if (tail < 1) {
                    System.out.printf("\"%s\" is not a valid input. That " +
                            "monkey tail is too small!%n", input4);
                } else if (tail > 35) {
                    System.out.printf("\"%s\" is not a valid input. That " +
                            "monkey tail is too large!%n", input4);
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid Input.\nPlease enter a number: ");
            }
        } while (true);
        String tail2 = String.valueOf(tail);
        monkey4.setTailLength(tail2);
        scanner.nextLine();
        // monkey body length
        double bodyLength = 0;
        do {
            System.out.println("What is the monkeys body length in inches?");
            String input3 = scanner.nextLine();
            try {
                bodyLength = Double.parseDouble(input3);
                if (bodyLength < 5) {
                    System.out.printf("\"%s\" is not a valid input. That " +
                            "monkey is too small!%n", input3);
                } else if (bodyLength > 50) {
                    System.out.printf("\"%s\" is not a valid input. That " +
                            "monkey is too large!%n", input3);
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid Input.\nPlease enter a number: ");
            }
        } while (true);
        String bodyLength2 = String.valueOf(bodyLength);
        monkey4.setBodyLength(bodyLength2);
        // monkey height
        double mHeight = 0;
        do {
            System.out.println("What is the monkeys overall height in inches?");
            String input2 = scanner.next();
            try {
                mHeight = Double.parseDouble(input2);
                if (mHeight < 8) {
                    System.out.printf("\"%s\" is not a valid input. That " +
                            "monkey is too small!%n", input2);
                } else if (mHeight > 55) {
                    System.out.printf("\"%s\" is not a valid input. That " +
                            "monkey is too large!%n", input2);
                } else if (mHeight < (bodyLength + 3)) {
                    System.out.printf("\"%s\" is not a valid input. The " +
                            "monkey would be missing its head if it had that " +
                            "height!%n", input2);
                    System.out.println("The monkeys body length is: " + bodyLength +
                            " inches.\nPlease give at least 3 inches for a head to " +
                            "exist on the monkey.");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Invalid Input.\nPlease enter a number: ");
            }
        } while (true);
        String mHeight2 = String.valueOf(mHeight);
        monkey4.setHeight(mHeight2);
        scanner.nextLine();
        System.out.println("Monkey has been accepted! Thank you!");

        monkeyList.add(monkey4);
    }
        //reserve animals
        public static void reserveAnimal(Scanner scanner) {
            System.out.println("What animal would you like to reserve? dog or monkey");
            String animal = scanner.nextLine();
            System.out.println("What country should the animal be in service?");
            String inService = scanner.nextLine();
            if (animal.equalsIgnoreCase("dog")) {
                for (Dog dog : dogList) {
                    if (!dog.getReserved()) {
                        if (dog.getInServiceLocation().equalsIgnoreCase(inService)) {
                            dog.setReserved(true);
                            System.out.println("We found a dog fitting your requirements " +
                                    "and reserved it! " +
                                    "Thank you for your business!");
                        }
                        else {
                            System.out.println("Sorry we do not have your specified animal available.");
                        }
                        return;
                    }
                }
            }
            else if (animal.equalsIgnoreCase("monkey")) {
                for (Monkey monkey : monkeyList) {
                    if (!monkey.getReserved()) {
                        if (monkey.getInServiceLocation().equalsIgnoreCase(inService)) {
                            monkey.setReserved(true);
                            System.out.println("We found a monkey fitting your requirements " +
                                    "and reserved it! " +
                                    "Thank you for your business!");
                        }
                        else {
                            System.out.println("Sorry we do not have your specified animal available.");
                        }
                        return;
                    }
                }
            }
        }

        //print animal lists
        public static void printAnimals(Scanner scanner) {
            System.out.println("This printAnimal method is not complete.");
            System.out.println("What list would you like?");
            System.out.println("Available lists are: monkey, dog, or in service.");
            String list = scanner.nextLine();
            if (list.equalsIgnoreCase("monkey")) {
                System.out.println("Monkey List: ");
                for (Monkey monkey : monkeyList) {
                    System.out.println(monkey.toString());
                }
            }
            else if (list.equalsIgnoreCase("dog")) {
                System.out.println("Dog List: ");
                for (Dog dog : dogList) {
                    System.out.println(dog.toString());
                }
            }
            else if (list.equalsIgnoreCase("in service")) {
                System.out.println("List of in service Monkeys: ");
                for (Monkey monkey : monkeyList) {
                    if (monkey.getTrainingStatus().equals("in service")) {
                        System.out.println(monkey);
                    }
                }
                System.out.println("List of in service Dogs: ");
                for (Dog dog : dogList) {
                    if (dog.getTrainingStatus().equals("in service")) {
                        System.out.println(dog);
                    }
                }
            }
            else {
                System.out.println("Invalid input.\nAvailable lists are: " +
                        "monkey, dog, or in service.");
            }
        }
}

