package geeksforgeeks.week1;

public class Car {

    public String brand;
    public String color;
    public String name;

    public Car(String brand, String color) {
        this.brand = brand;
        this.color = color;
    }

    public Car(String brand, String color, String name) {
        this.brand = brand;
        this.color = color;
        this.name = name;
    }

    public String getInfo() {
        return "The car is " + this.brand + "'s " + this.name;
    }
}
