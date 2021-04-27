import java.util.*;
public class PoliceDatabase {
    Vehicle[] vehicles;
    int numVehicles;
    Driver[] drivers;
    int numDrivers;
    Infraction[] infractions;
    int numInfractions;
        static final int MAX_DRIVERS = 2000;
        static final int MAX_VEHICLES = 1000;
        static final int MAX_INFRACTIONS = 800;
    public PoliceDatabase() {
        drivers = new Driver[MAX_DRIVERS];
        vehicles = new Vehicle[MAX_VEHICLES];
        infractions = new Infraction[MAX_INFRACTIONS];
    }
    {
    }
    public void registerDriver(Driver aDriver) {
        if (numDrivers <= MAX_DRIVERS) {
            drivers[numDrivers] = aDriver;
            numDrivers += 1;
        }
    }
    public void registerVehicle (Vehicle  aVehicle, String license) {
        if (numVehicles <= MAX_VEHICLES) {
            for (int w = 0; w < numDrivers; w++) {
                if (drivers[w].license.equals(license)) {
                    aVehicle.owner = drivers[w];
                    vehicles[numVehicles] = aVehicle;
                    numVehicles += 1;
                }
            }
        }
    }
    public void unregisterVehicle (String plate) {
        for (int w = 0; w < numVehicles; w++) {
            if (vehicles[w].plate.equals(plate)) {
                for (int x = w; x < numVehicles - 1; x++)
                    vehicles[x] = vehicles[x + 1];
            }
        }
        numVehicles -= 1;
    }
    public void reportStolen (String plate) {
        for (int w = 0; w < numVehicles; w++) {
            if (vehicles[w].plate.equals(plate)) {
                vehicles[w].reportedStolen = true;
            }
        }
    }
    public void changeOwner (String plate, String license) {
        for (int w = 0; w < numDrivers; w++) {
            if(drivers[w].license.equals(license)) {
                for (int x = 0; x < numVehicles; x++) {
                    if (vehicles[x].plate.equals(plate)) {
                        vehicles[x].owner = drivers[w];
                    }
                }
            }
        }
    }
    public Infraction issueInfraction (String license, float a, String d, Date i) {
        Infraction n = new Infraction (a, d, i);
            for (int w = 0; w < numDrivers; w++) {
                if (drivers[w].license.equals(license)) {
                    n.driver = drivers[w];
                    infractions[numInfractions] = n;
                    numInfractions += 1;
                }
            }
            return n;
    }
    public boolean hasOutstandingInfractions (Driver d) {
        for (int w = 0; w < numInfractions; w++) {
            if (infractions[w].driver.equals(d)) {
                if (infractions[w].outstanding == true) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean shouldStopVehicle (String plate) {
        for (int w = 0; w < numVehicles; w ++) {
            if (vehicles[w].plate.equals(plate)) {
                if (vehicles[w].reportedStolen || hasOutstandingInfractions(vehicles[w].owner)) {
                    return true;
                }
            }
        }
        return false;
    }
    public void showInfractionsFor (String license) {
        int c = -1;
        for (int w = 0; w < numInfractions; w++) {
            if (infractions[w].driver.license.equals(license)) {
                System.out.println(infractions[w]);
            }else if (infractions[w].outstanding) {
                c += 1;
            }
        }
        System.out.println("Total outstanding infractions = " +c);
    }
    public Driver[] cleanDrivers() {
        int c = 0;
        Driver[] clean = new Driver[c];
        Driver[] clean2 = new Driver[MAX_DRIVERS];
        for (int w = 0; w < numDrivers; w++){
            int c2 = 0;
            for (int x = 0; x < numInfractions; x++) {
                if(drivers[w].license.equals(infractions[x].driver.license)) {
                    c2 += 1;
                }
            }
            if (c2 == 0) {
                clean2[c] = drivers[w];
                c += 1;
            }
            clean = new Driver[c];
            for(int y = 0; y < c; y++) {
                clean[y] = clean2[y];
            }
        }
        return clean;
    }
    public void showInfractionReport () {
        for (int w = 0; w < numDrivers; w++) {
            int c = 0;
            float total = 0;
            for (int x = 0; x < numInfractions; x++) {
                if (drivers[w].equals(infractions[x].driver)) {
                    c += 1;
                    if (!infractions[x].outstanding) {
                        total += infractions[x].amount;
                    }
                }
            }
            if (c <= 0) {
            }else if (c > 0) {
            //if (c >= 0) {
                System.out.println((String.format("%20s", drivers[w].name))+ ": " +c+ " infractions, total paid = $" +total);
            }
        }
    }
    public static PoliceDatabase example() { // Register all drivers and their vehicles
        PoliceDatabase pdb = new PoliceDatabase();

        pdb.registerDriver(new Driver("L1567-34323-84980", "Matt Adore",
                "1323 Kenaston St.", "Gloucester", "ON"));
        pdb.registerDriver(new Driver("L0453-65433-87655", "Bob B. Pins",
                "32 Rideau Rd.", "Greely", "ON"));
        pdb.registerDriver(new Driver("L2333-45645-54354", "Stan Dupp",
                "1355 Louis Lane", "Gloucester", "ON"));
        pdb.registerDriver(new Driver("L1234-35489-99837", "Ben Dover",
                "2348 Walkley Rd.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L8192-87498-27387", "Patty O'Lantern",
                "2338 Carling Ave.", "Nepean", "ON"));
        pdb.registerDriver(new Driver("L2325-45789-35647", "Ilene Dover",
                "287 Bank St.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L1213-92475-03984", "Patty O'Furniture",
                "200 St. Laurant Blvd.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L1948-87265-34782", "Jen Tull",
                "1654 Stonehenge Cres.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L0678-67825-83940", "Jim Class",
                "98 Oak Blvd.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L0122-43643-73286", "Mark Mywords",
                "3 Third St.", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L6987-34532-43334", "Bob Upandown",
                "434 Gatineau Way", "Hull", "QC"));
        pdb.registerDriver(new Driver("L3345-32390-23789", "Carrie Meehome",
                "123 Thurston Drive", "Kanata", "ON"));
        pdb.registerDriver(new Driver("L3545-45396-88983", "Sam Pull",
                "22 Colonel By Drive", "Ottawa", "ON"));
        pdb.registerDriver(new Driver("L1144-26783-58390", "Neil Down",
                "17 Murray St.", "Nepean", "ON"));
        pdb.registerDriver(new Driver("L5487-16576-38426", "Pete Reedish",
                "3445 Bronson Ave.", "Ottawa", "ON"));
        pdb.registerVehicle(new Vehicle("Honda", "Civic", 2015, "yellow", "W3EW4T"),
                "L0453-65433-87655");
        pdb.registerVehicle(new Vehicle("Pontiac","Grand Prix",2007,"dark green","GO SENS"),
                "L0453-65433-87655");
        pdb.registerVehicle(new Vehicle("Mazda", "RX-8", 2004, "white", "OH YEAH"),
                "L2333-45645-54354");
        pdb.registerVehicle(new Vehicle("Nissan","Altima",2017,"bergundy", "Y6P9O7"),
                "L1234-35489-99837");
        pdb.registerVehicle(new Vehicle("Saturn", "Vue", 2002, "white", "9R6P2P"),
                "L2325-45789-35647");
        pdb.registerVehicle(new Vehicle("Honda", "Accord", 2018, "gray", "7U3H5E"),
                "L2325-45789-35647");
        pdb.registerVehicle(new Vehicle("Chrysler", "PT-Cruiser", 2006, "gold", "OLDIE"),
                "L2325-45789-35647");
        pdb.registerVehicle(new Vehicle("Nissan", "Cube", 2010, "white", "5Y6K8V"),
                "L1948-87265-34782");
        pdb.registerVehicle(new Vehicle("Porsche", "959", 1989, "silver", "CATCHME"),
                "L0678-67825-83940");
        pdb.registerVehicle(new Vehicle("Kia", "Soul", 2018, "red", "J8JG2Z"),
                "L0122-43643-73286");
        pdb.registerVehicle(new Vehicle("Porsche", "Cayenne", 2014, "black", "EXPNSV"),
                "L6987-34532-43334");
        pdb.registerVehicle(new Vehicle("Nissan", "Murano", 2010, "silver", "Q2WF6H"),
                "L3345-32390-23789");
        pdb.registerVehicle(new Vehicle("Honda", "Element", 2008, "black", "N7MB5C"),
                "L3545-45396-88983");
        pdb.registerVehicle(new Vehicle("Toyota", "RAV-4", 2010, "green", "R3W5Y7"),
                "L3545-45396-88983");
        pdb.registerVehicle(new Vehicle("Toyota", "Celica", 2006, "red", "FUNFUN"),
                "L5487-16576-38426");
        return pdb;
    }
}