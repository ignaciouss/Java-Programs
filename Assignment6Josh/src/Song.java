//written by Joshua Harris on March 23
public class Song implements Comparable<Song> {

    private String title;
    private String artist;
    private int duration;
    private User owner;
    public int download;

    public Song() {
        this("", "", 0, 0);
    }
    public Song(String t, String a, int m, int s) {
        owner = null;
        title = t;
        artist = a;
        duration = m * 60 + s;
        download = 0;

    }
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public int getDuration() { return duration; }
    public User getOwner() { return owner;}

    public int getMinutes() {
        return duration / 60;
    }
    public int getSeconds() {
        return duration % 60;
    }
    public void setOwner(User u){owner = u;}

    public String toString() {
        return("\"" + title + "\" by " + artist + " " +
                (duration / 60) + ":" + (duration%60));
    }
    public boolean equals(Object obj){
        if(!(obj instanceof Song)) return false;
        return(duration==(((Song)obj).duration))&&(title.equals(((Song)obj).title))&&(artist.equals(((Song)obj).artist));
    }
    public int compareTo(Song s) {
        return (title.compareTo(s.title));
    }
    public int hashCode(){
        return title.hashCode();
    }
}