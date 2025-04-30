package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia (Media media) {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(media);
        }
    }

    public void removeMedia (Media media) {
        itemsOrdered.remove(media);
    }

    public Media search (String tittle) {
        for (Media item: itemsOrdered) {
            if (item.getTitle().equals(tittle)) {
                return item;
            }
        }
        return null;
    }

    public Media search (int id) {
        for (Media item: itemsOrdered) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    public float totalCost () {
        float sum = 0;
        for (Media item: itemsOrdered) {
            sum += item.getCost();
        }
        return sum;
    }

    public void sortByTitle() {
        itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
    }
    public void sortByPrice() {
        itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
    }
    public void empty () {
        itemsOrdered = new ArrayList<>();
    }

    }