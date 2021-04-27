//Written by Joshua Harris
//Feb 2,2018
public class Theatre {
    //public static final int capacity = 100;
    int capacity;
    int seatsSold;
    Movie moviePlaying;




    public Theatre(int c){
        capacity = c;
        moviePlaying = new Movie();
        seatsSold = 0;
    }
    public Theatre(){
        capacity = 0;
        moviePlaying = new Movie();
        seatsSold = 0;
    }
    public boolean isFull(){
        return(capacity ==seatsSold);
    }

}
