//Written by Joshua Harris
//Februrary 1,2018
public class BoxOffice {
    Ticket ticket;
    Theatre theatreA;
    Theatre theatreB;
    double justice = 0;
    double geo = 0;
    double DM3 = 0;
    Movie bestMovie = null;

    // initialize theatre capacities
    public BoxOffice(int a, int b){
        theatreA = new Theatre(a);
        theatreB = new Theatre(b);
    }
    //initializes Movie with movie name
    public void openMovie(String a,Theatre k){
        k.moviePlaying= new Movie(a);
        k.seatsSold= 0;
    }

    public void sellTicket(Patron l,String o){
       if (o==theatreA.moviePlaying.title){// if the title of movie matches one in  theatreA...
           if(theatreA.isFull() == false) {// and theatre is not full
               theatreA.seatsSold += 1;
               if (l.age < 12) {
                   theatreA.moviePlaying.earnings += 6.25;
                   movieAccumulated(6.25, theatreA);
               } else if (l.age >= 65) {
                   theatreA.moviePlaying.earnings += 5.75;
                   movieAccumulated(5.75, theatreA);
               } else if(l.age>=12 && l.age<65) {
                   theatreA.moviePlaying.earnings += 12.50;
                   movieAccumulated(12.50, theatreA);
               }
               l.ticket = new Ticket(theatreA);
             }
       }else if(o == theatreB.moviePlaying.title) {// if the title of movie matches one in  theatreB...
           if (theatreB.isFull() == false) {// and is not full
               theatreB.seatsSold += 1;
               if (l.age < 12) {
                   theatreB.moviePlaying.earnings += 6.25;
                   movieAccumulated(6.25, theatreB);
               } else if (l.age >= 65) {
                   theatreB.moviePlaying.earnings += 5.75;
                   movieAccumulated(5.75, theatreB);
               } else if(l.age>=12 && l.age<65) {
                   theatreB.moviePlaying.earnings += 12.50;
                   movieAccumulated(12.50, theatreB);
               }
               l.ticket = new Ticket(theatreB);
           } else if (theatreB.isFull() == true) {// if it is full print....
               System.out.println("Movie is sold out");
           } else if (theatreA.isFull() == true) {//if IT IS full print...
               System.out.println("Movie is sold out");
           }
       }else{// if its not a movie playing
           System.out.println("Movie is not currently playing");
       }

    }

    public void returnTicket(Patron f){
        //if they don't have a movie ticket
        if(f.ticket == null){
            System.out.println("Patron doe not have a ticket");
        }
        //if they bought it from theatre A
        else if(f.ticket.theatre== theatreA) {
            //subtract earnings from movie and var
            if(f.age<12){
                theatreA.moviePlaying.earnings -= 6.25;
                movieAccumulated(-6.25,theatreA);
            }
            else if (f.age>=65){theatreA.moviePlaying.earnings -= 5.75;
                movieAccumulated(-5.75,theatreA);
            }
            else{theatreA.moviePlaying.earnings -= 12.50;
                movieAccumulated(-12.50,theatreA);
            }
            f.ticket = null;
            theatreA.seatsSold -=1;
//return movie ticket if from movie B
        }else if(f.ticket.theatre == theatreB){
            if(f.age<12){theatreB.moviePlaying.earnings -= 6.25;
                movieAccumulated(-6.25,theatreB);
            }
            else if (f.age>=65){theatreB.moviePlaying.earnings -= 5.75;
                movieAccumulated(-5.75,theatreB);
            }
            else{theatreB.moviePlaying.earnings -= 12.50;
                movieAccumulated(-12.50,theatreB);
            }
            f.ticket = null;
            theatreB.seatsSold -=1;
        }
    }

// looks at movie var, and compares to see who has most earnings.
    //creates a new movie based on earnings and makes the title the top selling movie
    public Movie bestMovie(){
        if(justice>geo&&justice>DM3){//if justice hs better earnings then the other 2, it becomes Best movie
            bestMovie= new Movie("Justice League");
            bestMovie.earnings = (float)justice;
        }else if(justice<geo&& geo> DM3){//if geo hs better earnings then the other 2
            bestMovie= new Movie("Geostorm");
            bestMovie.earnings = (float)geo;
        }else if((DM3>justice)&&DM3>geo){// if DM3 has better earnings then others 2
            bestMovie= new Movie("Despicable Me 3");
            bestMovie.earnings = (float)DM3;
        }
        return bestMovie;
    }

// add amount to a movie variable when called
    public void movieAccumulated(double amount,Theatre AorB){
        if(AorB.moviePlaying.title == "Justice League"){
            justice+= amount;
        } else if(AorB.moviePlaying.title == "Geostorm"){
            geo += amount;
        }else if (AorB.moviePlaying.title == "Despicable Me 3"){
            DM3+= amount;
        }
    }



}
