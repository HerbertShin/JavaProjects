public class Car implements Comparable<Car> {
    String make;
    String model;
    String color;
    String year;
    String VIN;
    int noOfDoors;
    int noOfSeats;
    int noOfSuitcases;
    int noOfBags;
    Boolean rented = false;

    //Constructor assigns attributes to the car object
    public Car(String make, String model, String color, String year) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
    }

    //Setter methods to set the attributes to each car object
    public void setVIN(String vin) {
        VIN = vin;
    }

    public void setSize(int door, int seat) {
        noOfSeats = seat;
        noOfDoors = door;
    }

    public void setLuggage(int suitcase, int bag) {
        noOfSuitcases = suitcase;
        noOfBags = bag;
    }

    public void setRented(Boolean status) {
        rented = status;
    }

    //Gets the basic information about the car
    public String getCarInfo() {
        return make + ", " + model + " " + year + "-" + color;
    }

    //Override of the toString method to properly format the display of information for each car
    public String toString() {
        String fs = String.format(
                "%-" + 20 + "s%-" + 15 + "s%-" + 20 + "s%-" + 20 + "s",
                make + ", " + model, year + "-" + color, VIN, getCategory());

        return fs;
    }

    //Compares the VIN of the cars
    @Override
    public Boolean isSameCar(Car car) {
        if (car.VIN == VIN) {
            return true;
        } else {
            return false;
        }
    }

    //Assigns each car object to a category based on number of suitcases and bags primarily
    @Override
    public String getCategory() {
        String Category;
        if (noOfDoors == 4 && noOfSeats == 5 && noOfSuitcases == 1 && noOfBags == 1) {
            Category = "Economy";
        } else if (noOfSuitcases == 1 && noOfBags == 2) {
            Category = "Compact";
        } else if (noOfSuitcases == 2 && noOfBags == 1) {
            Category = "Mid-size(Standard)";
        } else if (noOfSuitcases == 2 && noOfBags == 2) {
            Category = "Full-size(Premium)";
        } else {
            Category = "Convertible";
        }

        return Category;
    }

    //Checks if the car is rented or not
    @Override
    public Boolean isRented() {
        return rented;
    }
}
