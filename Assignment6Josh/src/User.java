//Written by Joshua Harris on March23
import java.util.ArrayList;
public class User {
    private ArrayList<Song> songList;
    private String userName;
    private boolean online;

    public User() { this(""); }

    public User(String u) {
        userName = u;
        online = false;
        songList = new ArrayList<Song>();
    }
    public String getUserName() { return userName; }
    public boolean isOnline() { return online; }
    public String toString() {
        String s = "" + userName +":"+ songList.size()+" songs (";
        if (!online) s += "not ";
        return s + "online)";
    }
    public ArrayList<Song> getSongList(){return songList;}
    //Add to Song list
    public void addSong(Song s){
        Song songz = new Song(s.getTitle(),s.getArtist(),s.getMinutes(),s.getSeconds());
        songz.setOwner(this);
        this.songList.add(songz);
    }
    public int totalSongTime(){
        int totalTime = 0;
        for (Song i: songList){
            totalTime += i.getDuration();
        }
        return totalTime;
    }

    public void register(MusicExchangeCenter m){m.registerUser(this); }

    public void logon(MusicExchangeCenter m) {
        if (!this.isOnline()) {
            if(m.userWithName(this.userName)== null){
                return;
            }
            else{
                this.online = true;
                //System.out.println("User has logged into________"+m);
            }

        }
    }

    public void logoff(MusicExchangeCenter m) {
        if (this.isOnline()) {
            if (m.userWithName(this.userName)== null) {
                return;
            }
            else{
                this.online = false;
               // System.out.println(this.userName +" has logged off from " + m);
            }


        }
    }
    //return song if its in songlist
    public Song songWithTitle(String title){
        for (Song s: this.getSongList()){
            if (s.getTitle().equals(title)){
                return s;
            }
        }
        return null;
    }
    //Display ALL AVAILABLE SONGS
    public ArrayList<String> requestCompleteSonglist(MusicExchangeCenter m){
        ArrayList<String> allSongs = new ArrayList<String>();
        //add top header TITLE ARTISTS....
        String header = String.format("%-3s %-29s %-21s %-10s %-15s"," ","Title", "ARTIST","TIME","OWNER" );
        allSongs.add(header);
        allSongs.add(" ");
        int num = 0;
        for (Song s: m.allAvailableSongs()){
            num++;
            //String song;
            String song = String.format("%2d%-1s %-29s %-20s %2d:%-8s %-15s",num,".",s.getTitle(), s.getArtist(),s.getMinutes(),s.getSeconds(),s.getOwner().getUserName() );
            allSongs.add(song);
        }
        return allSongs;
    }
    //REQUEST SONG BY ARTIST
    public ArrayList<String> requestSonglistByArtist(MusicExchangeCenter m,String artist){
        ArrayList<String> allSongs = new ArrayList<String>();
        //add top header TITLE ARTISTS....
        String header = String.format("%-3s %-29s %-21s %-10s %-15s"," ","Title", "ARTIST","TIME","OWNER" );
        allSongs.add(header);
        allSongs.add(" ");
        int num = 0;
        for (Song s: m.allAvailableSongs()){
            if (s.getArtist() == artist) {
                num++;
                String song;
                song = String.format("%2d%-1s %-29s %-20s %2d:%-8s %-15s", num, ".", s.getTitle(), s.getArtist(), s.getMinutes(), s.getSeconds(), s.getOwner().getUserName());
                allSongs.add(song);
            }
        }
        return allSongs;
    }

    public void downloadSong(MusicExchangeCenter m,String title,String ownerName){
        Song downloaded = new Song();
        downloaded = m.getSong(title,ownerName);
        if(downloaded == null){
            return;
        }else{
            Song freshDownloaded = new Song(downloaded.getTitle(),downloaded.getArtist(),downloaded.getMinutes(),downloaded.getSeconds());
            freshDownloaded.setOwner(this);
            this.songList.add(freshDownloaded);
        }

    }





    // Various Users for test purposes
    public static User DiscoStew() {
        User  discoStew = new User("Disco Stew");
        discoStew.addSong(new Song("Hey Jude", "The Beatles", 4, 35));
        discoStew.addSong(new Song("Barbie Girl", "Aqua", 3, 54));
        discoStew.addSong(new Song("Only You Can Rock Me", "UFO", 4, 59));
        discoStew.addSong(new Song("Paper Soup Cats", "Jaw", 4, 18));
        return discoStew;
    }

    public static User SleepingSam() {
        User sleepingSam = new User("Sleeping Sam");
        sleepingSam.addSong(new Song("Meadows", "Sleepfest", 7, 15));
        sleepingSam.addSong(new Song("Calm is Good", "Waterfall", 6, 22));
        return sleepingSam;
    }

    public static User RonnieRocker() {
        User ronnieRocker = new User("Ronnie Rocker");
        ronnieRocker.addSong(new Song("Rock is Cool", "Yeah", 4, 17));
        ronnieRocker.addSong(new Song("My Girl is Mean to Me", "Can't Stand Up", 3, 29));
        ronnieRocker.addSong(new Song("Only You Can Rock Me", "UFO", 4, 52));
        ronnieRocker.addSong(new Song("We're Not Gonna Take It", "Twisted Sister", 3, 9));
        return ronnieRocker;
    }

    public static User CountryCandy() {
        User countryCandy = new User("Country Candy");
        countryCandy.addSong(new Song("If I Had a Hammer", "Long Road", 4, 15));
        countryCandy.addSong(new Song("My Man is a 4x4 Driver", "Ms. Lonely", 3, 7));
        countryCandy.addSong(new Song("This Song is for Johnny", "Lone Wolf", 4, 22));
        return countryCandy;
    }

    public static User PeterPunk() {
        User peterPunk = new User("Peter Punk");
        peterPunk.addSong(new Song("Bite My Arms Off", "Jaw", 4, 12));
        peterPunk.addSong(new Song("Where's My Sweater", "The Knitters", 3, 41));
        peterPunk.addSong(new Song("Is that My Toenail ?", "Clip", 4, 47));
        peterPunk.addSong(new Song("Anvil Headache", "Clip", 4, 34));
        peterPunk.addSong(new Song("My Hair is on Fire", "Jaw", 3, 55));
        return peterPunk;
    }
}

