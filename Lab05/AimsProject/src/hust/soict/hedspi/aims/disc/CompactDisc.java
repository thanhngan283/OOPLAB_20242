package hust.soict.hedspi.aims.disc;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public CompactDisc(String title, String category, String artist, float cost) {
        super(title, category, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, String director, String artist, float cost) {
        super(title, category, director, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, String director, String artist, int length, float cost) {
        super(title, category, director, length, cost);
        this.artist = artist;
    }

    public void addTrack(Track track) {
        for (var item : tracks) {
            if (item.equals(track)) {
                System.out.println("Track is already in the list");
                return;
            }
        }
        tracks.add(track);
        System.out.println("Track added");
    }

    public void removeTrack(Track track) {
        for (var item : tracks) {
            if (item.equals(track)) {
                tracks.remove(item);
                System.out.println("Track removed");
                return;
            }
        }
        System.out.println("Track not found");
    }

    public int getLength() {
        int length = 0;
        for (Track track : tracks) {
            length += track.getLength();
        }
        return length;
    }

    public void play() {
        System.out.println("*******************" + getTitle() + "**********************");
        System.out.println("Playing CD - " + getTitle() + " by " + artist);
        for (Track track : tracks) {
            track.play();
            System.out.println("..................................................");
        }
        System.out.println("Total length: " + getLength() + " min");
        System.out.println("**************************************************");
    }

    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("CD - ")
                .append(getTitle())
                .append(" - ")
                .append(getCategory())
                .append(" - ")
                .append(getDirector() != null ? getDirector() : "Unknown")
                .append(" - ")
                .append(getLength() != 0 ? getLength() + " min" : "Unknown")
                .append(artist != null ? " - " + artist : "")
                .append(" : ")
                .append(getCost())
                .append("$");
        return str.toString();
    }
}
