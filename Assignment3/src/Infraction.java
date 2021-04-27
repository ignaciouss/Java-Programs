import java.util.*;
public class Infraction {
    float amount;
    String description;
    Date dateIssued;
    boolean outstanding = true;
    Driver driver;
    public Infraction() {
        this(1.2f, "", new Date());
        //outstanding = false;
    }
    public Infraction(float a, String d, Date i) {
        amount = a;
        description = d;
        dateIssued = i;
    }
    public String toString() {
        if (outstanding) {
            return ("$" +(String.format("%10.2f", amount))+ " Infraction on " +(String.format("%tc", dateIssued))+ " [OUTSTANDING]");
        }
        return ("$" +(String.format("%10.2f", amount))+ " Infraction on " +(String.format("%tc", dateIssued))+ " [PAID IN FULL]");
    }
    public void pay() {
        outstanding = false;
    }
}