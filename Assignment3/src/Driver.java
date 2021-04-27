public class Driver {
    String license;
    String name;
    String street;
    String city;
    String province;
    public Driver() {
        this("", "", "", "", "");
    }
    public Driver (String l, String n, String s, String c, String p) {
        license = l;
        name = n;
        street = s;
        city = c;
        province = p;
    }
    public String toString() {return "#" +license+ " " +name+ " living at " +street+ " ., " +city+ " , " +province;}
}