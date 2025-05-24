package hust.soict.hedspi.aims.disc;

import hust.soict.hedspi.aims.exceptions.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(title, category, director, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
    }

    public String toString() {
        StringBuffer str = new StringBuffer();
        str.append("DVD - ")
                .append(getTitle())
                .append(" - ")
                .append(getCategory())
                .append(" - ")
                .append(getDirector() != null ? getDirector() : "Unknown")
                .append(" - ")
                .append(getLength() != 0 ? getLength() + " min" : "Unknown")
                .append(" : ")
                .append(getCost())
                .append("$");
        return str.toString();
    }

    public void play() throws PlayerException {
        if (getLength() == 0) {
            throw new PlayerException("ERROR: DVD length is non-positive");
        }
        System.out.println("Playing DVD: " + getTitle());
        System.out.println("DVD length: " + getLength());
    }
}
