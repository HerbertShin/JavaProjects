import java.util.ArrayList;

public class CarRentalAgent {
    private String companyName;
    private String address;
    ArrayList<Car> CarInventory = new ArrayList<Car>();

    //Constructor to set attributes to car rental agent
    public CarRentalAgent(String name, String address) {
        companyName = name;
        this.address = address;
    }

    //Adds the car object to the arraylist if it has not been added yet
    public Boolean addInventory(Car car) {
        if (car.isSameCar(car) == false) {
            return false;
        } else {
            CarInventory.add(car);
            return true;
        }
    }

    //Prints the arraylist/car inventory and the headings to the inventory listing
    //String formatting is used to add padding between the prints
    public void printInventory() {
        System.out.println("Agent Name: " + companyName);
        System.out.println("Agent Address: " + address);
        System.out.println();
        System.out.print(String.format(
                "%-" + 20 + "s%-" + 15 + "s%-" + 20 + "s%-" + 20 + "s\n",  // format
                "Make and Model", "Year-Color", "VIN", "Category"));
        System.out.print(String.format(
                "%-" + 20 + "s%-" + 15 + "s%-" + 20 + "s%-" + 20 + "s\n",  // format
                "------------------", "-----------", "----------------- ", "------------------"));


        for (int i = 0; i < CarInventory.size(); i++) {
            System.out.println(CarInventory.get(i).toString());
        }
    }

    //Checks if car is rented or not and if it is not then it will proceed to rent it
    public Boolean rentCar(Car car) {
        if (car.rented == null || car.rented == false) {
            car.setRented(true);
            return true;
        } else {
            return false;
        }
    }

    //Checks if car is rented and if so then it will proceed to return the car
    public Boolean returnCar(Car car) {
        if (car.rented == true) {
            car.setRented(false);
            return true;
        } else {
            return false;
        }
    }
}