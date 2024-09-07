package geeksforgeeks.week1;

public class SuperCar extends Car {

    public int firstRaceYear;
    public int noOfTrophiesWon;

    public SuperCar(String brand, String color, String name,
                    int firstRaceYear,
                    int noOfTrophiesWon) {
        super ( brand, color, name );
        this.firstRaceYear = firstRaceYear;
        this.noOfTrophiesWon = noOfTrophiesWon;
    }

    @Override
    public String getInfo() {
        return "Inside SuperCar class: " + this.noOfTrophiesWon;
    }

    public String getSuperCarInfo() {
        return "SuperCar";
    }

}
