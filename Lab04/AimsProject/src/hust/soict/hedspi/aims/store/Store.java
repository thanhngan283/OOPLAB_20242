
package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;
public class Store {
    public static final int MAX_STORE_ITEMS = 100;
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        if (itemsInStore.size() >= MAX_STORE_ITEMS || getMedia(media.getTitle()) != null) {
            return;
        }
        itemsInStore.add(media);
    }

    public void removeMedia(String title) {
        itemsInStore.remove(getMedia(title));
    }
    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public Media getMedia(String titleMedia) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equals(titleMedia)) {
                return media;
            }
        }
        return null;
    }
    }
    
    