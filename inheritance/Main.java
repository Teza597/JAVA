import java.time.Year;

class Vehicle {
    String brand, model;
    int year;
    double basePrice;

    Vehicle(String brand, String model, int year, double basePrice) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.basePrice = basePrice;
    }

    void displayBasicInfo() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Base Price: Rs" + basePrice);
    }

    double calculateResaleValue() {
        int age = Year.now().getValue() - year;
        double value = basePrice;
        for (int i = 0; i < age; i++) {
            value *= 0.85;
        }
        return value;
    }
}

class Car extends Vehicle {
    int numberOfDoors;

    Car(String brand, String model, int year, double basePrice, int numberOfDoors) {
        super(brand, model, year, basePrice);
        this.numberOfDoors = numberOfDoors;
    }

    double calculateInsurance() {
        return 5000 + 1000 * numberOfDoors;
    }

    double calculateMaintenanceCost() {
        return 3000 + 500 * numberOfDoors;
    }

    void displayInfo() {
        System.out.println("----- Car Information -----");
        displayBasicInfo();
        System.out.println("Number of Doors: " + numberOfDoors);
        System.out.println("Insurance: Rs" + calculateInsurance());
        System.out.println("Maintenance: Rs" + calculateMaintenanceCost());
        System.out.println("Resale Value: Rs" + calculateResaleValue());
        System.out.println();
    }
}

class Motorcycle extends Vehicle {
    boolean hasSidecar;

    Motorcycle(String brand, String model, int year, double basePrice, boolean hasSidecar) {
        super(brand, model, year, basePrice);
        this.hasSidecar = hasSidecar;
    }

    double calculateInsurance() {
        return hasSidecar ? 4000 : 2500;
    }

    double calculateMaintenanceCost() {
        return hasSidecar ? 3000 : 2000;
    }

    void displayInfo() {
        System.out.println("----- Motorcycle Information -----");
        displayBasicInfo();
        System.out.println("Has Sidecar: " + (hasSidecar ? "Yes" : "No"));
        System.out.println("Insurance: Rs" + calculateInsurance());
        System.out.println("Maintenance: Rs" + calculateMaintenanceCost());
        System.out.println("Resale Value: Rs" + calculateResaleValue());
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car("Porsche", "911 GT3 RS", 2021, 25000000, 2);
        myCar.displayInfo();

        Motorcycle myBike = new Motorcycle("Harley-Davidson", "Street 750", 2022, 600000, true);
        myBike.displayInfo();
    }
}
