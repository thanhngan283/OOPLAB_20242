package hust.soict.hedspi.aims.disc;

import java.util.ArrayList;

public class Track implements Playable {
    private String title;
    private int length;
    private String artist;
    private ArrayList<String> tracks = new ArrayList<String>();

    public Track(String title, String artist, int length) {
        this.title = title;
        this.length = length;
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public void addTrack(String track) {
        if (tracks.contains(track)) {
            System.out.println("Track is already in the list");
        } else {
            tracks.add(track);
            System.out.println("Track added");
        }
    }

    public void removeTrack(String track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed");
        } else {
            System.out.println("Track is not in the list");
        }
    }

    public void play() {
        System.out.println("Playing track: " + getTitle());
        System.out.println("Track length: " + getLength());
        System.out.println("Track artist: " + artist);
    }

    public boolean equals(Object obj) {
        Track track = (Track) obj;
        return title == track.getTitle() && length == track.getLength();
    }

    public String toString() {
        return "Track - " + title + "- " + artist + " - " + length + " min";
    }
}
