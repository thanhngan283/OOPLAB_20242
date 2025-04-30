
package hust.soict.hedspi.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }
    public int getLength() {
        return length;
    }

    public Track(String title) {
        this.title = title;
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Track) {
            Track track = (Track) obj;
            return (track.getTitle() == this.getTitle() && track.getLength() == this.getLength());
        } else {return false;}
    }
    @Override
    public void play() {
        // TODO Auto-generated method stub
        System.out.println("Track title: " + this.getTitle());
        System.out.println("Track lenght: " + this.getLength());
    }

    
}
