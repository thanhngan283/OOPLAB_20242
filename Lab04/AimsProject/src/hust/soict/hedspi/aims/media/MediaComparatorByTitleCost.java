
package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

    @Override
    public int compare(Media o1, Media o2) {
        // TODO Auto-generated method stub
        if (o1.getTitle() == o2.getTitle()) {
            return Float.compare(o1.getCost(), o2.getCost());
        } else {
            return o1.getTitle().compareTo(o2.getTitle());
        }
    }
    
}
