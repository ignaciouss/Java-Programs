public class Vehicle {
    String make;
    String model;
    int year;
    String color;
    String plate;
    Driver owner;
    boolean reportedStolen;
    public Vehicle() {
        this("" ,"" ,0 ,"" ,"");
    }
    public Vehicle(String a, String o, int y, String c, String p) {
        make = a;
        model = o;
        year = y;
        color = c;
        plate = p;
    }
    public String toString() {return "A " +color+ " " +year+ " " +make+ " " +model+ " with plate " +plate;}
}