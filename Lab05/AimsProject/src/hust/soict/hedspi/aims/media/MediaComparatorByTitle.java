package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitle implements Comparator<Media> {
    public int compare(Media m1, Media m2) {
        if (m1.getTitle() == m2.getTitle()) {
            return m1.getCost() < m2.getCost() ? -1 : 1;
        }
        return m1.getTitle().compareTo(m2.getTitle());
    }
}
