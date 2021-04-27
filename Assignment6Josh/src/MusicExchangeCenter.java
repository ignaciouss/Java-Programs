//Written by Joshus Harris on March 23,2018
import javafx.util.Pair;
import java.util.*;

public class MusicExchangeCenter {
    public ArrayList<User> users;
    public HashMap<String, Float> royalties;
    public ArrayList<Song> downloadedSongs;

    public MusicExchangeCenter() {
        users = new ArrayList<User>();
        royalties = new HashMap<String, Float>();
        downloadedSongs = new ArrayList<Song>();

    }

    public ArrayList<Song> getDownloadedSongs() {
        return downloadedSongs;
    }

    public ArrayList<User> onlineUsers() {
        ArrayList<User> isOnlinetemp = new ArrayList<User>();
        for (User u : this.users) {
            if (u.isOnline()) {
                isOnlinetemp.add(u);
            }
        }
        return isOnlinetemp;
    }

    public ArrayList<Song> allAvailableSongs() {
        ArrayList<Song> allSongs = new ArrayList<Song>();
        for (User u : this.users) {
            if (onlineUsers().contains(u)) {
                for (Song s : u.getSongList()) {
                    allSongs.add(s);
                }
            }
        }
        return allSongs;
    }

    @Override
    public String toString() {
        return "Music Exchange Center (" + onlineUsers().size() + " users on line, " + allAvailableSongs().size() + " songs available)";
    }

    public User userWithName(String s) {
        for (User u : users) {
            if (u.getUserName() == s) {
                return u;
            }
        }
        return null;
    }

    public void registerUser(User x) {
        if (userWithName(x.getUserName()) == null) {
            users.add(x);
        }
    }

    public ArrayList<Song> availableSongsByArtist(String artist) {
        ArrayList<Song> artistSongs = new ArrayList<Song>();
        for (Song s : allAvailableSongs()) {
            if (s.getArtist() == (artist)) {
                artistSongs.add(s);
            }
        }
        return artistSongs;
    }

    //get a song from this user(if online)
    public Song getSong(String title, String ownerName) {
        for (User u : this.onlineUsers()) {
            Song s = u.songWithTitle(title);
            if (!(s == null)) {
                if (s.getOwner().getUserName().equals(ownerName)) {
                    downloadedSongs.add(s);
                    return s;

                }
            }
        }
        return null;
    }

    public void displayRoyalties() {
        HashMap<String, Float> royalties = new HashMap<String, Float >();
        String royalList =(String.format("%-6s %-10s", "Amount", "Artist"));
        for (Song s : downloadedSongs) {
            if (!(royalties.containsKey(s.getArtist()))) {
                royalties.put(s.getArtist(), 0.25f);
            }
            else{
                royalties.put(s.getArtist(), (royalties.get(s.getArtist()) +0.25f));
            }

        }
        System.out.println(royalList);
        System.out.println("---------------");
        for(String f: royalties.keySet()){
            System.out.println(String.format("%-1s%1.2f %-10s","$",royalties.get(f), f));
        }
    }

    public TreeSet<Song> uniqueDownloads(){
        TreeSet<Song> UDownloaded = new TreeSet<Song>(downloadedSongs);
        return UDownloaded;
    }


    public ArrayList<Pair<Integer,Song>> songsByPopularity() {
        ArrayList<Pair<Integer, Song>> popular = new ArrayList<Pair<Integer, Song>>();
        HashSet<Song> USongs = new HashSet<Song>(downloadedSongs);
        for(Song t: uniqueDownloads()) {
            Integer num = Collections.frequency(downloadedSongs, t);
            Pair<Integer,Song> newPop = new Pair<Integer,Song>(num,t);
            popular.add(newPop);
        }
            Collections.sort(popular, new Comparator<Pair<Integer, Song>>() {
                public int compare(Pair<Integer, Song> p1, Pair<Integer, Song> p2) {
                    return (p2.getKey()-p1.getKey());
                }
            });
        return popular;
     }

}
