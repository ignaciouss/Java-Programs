//Written by Joshua Harris
//Feb 2,2018
public class Patron {
     int age;
     Ticket ticket;
//Patron Consructors
    public Patron(){
        age = 0;
        ticket = null;
    }
    public Patron(int i){
        age = i;
        ticket = null;
    }
    public Patron(Ticket p){
        age =0;
        ticket = p;
    }
}
