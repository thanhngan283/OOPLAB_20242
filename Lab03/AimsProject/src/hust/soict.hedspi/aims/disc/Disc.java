
package hust.soict.hedspi.aims.disc;

import hust.soict.hedspi.aims.media.Media;

public class Disc extends Media {
    private int length;
    private String director;
    
    public int getLength() {
        return length;
    }
    public String getDirector() {
        return director;
    }
    
    public Disc(int id, String title, String category, float cost, int length, String director) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.length = length;
        this.director = director;
    }
    public Disc() {
    }
    public Disc(String title) {
        this.title = title;
    }
    public Disc(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    public Disc(String title, String category, String director, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.director = director;
    }
    public Disc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.director = director;
        this.length = length;
    }

    
}
