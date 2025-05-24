package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public void addMedia(Media media) {
        itemsInStore.add(media);
    }

    public void removeMedia(Media media) {
        itemsInStore.remove(media);
    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public void viewStore() {
        System.out.println("Items in store:");
        System.out.println("------------------------------------------------------------------");
        for (var item : itemsInStore) {
            System.out.println(item.toString());
        }
        System.out.println("------------------------------------------------------------------");
    }

}
