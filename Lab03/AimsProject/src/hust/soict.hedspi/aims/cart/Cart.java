
package hust.soict.hedspi.aims.cart;
import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private List<Media> itemsOrdered = new ArrayList<>();

    public List<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public List<Media> addMedia(Media media) {
        itemsOrdered.add(media);
        return itemsOrdered;
    }

    public List<Media> removeMedia(Media media) {
        itemsOrdered.remove(media);
        return itemsOrdered;
    }

    public float totalCost() {
        float cost = 0; 
        for (Media media: itemsOrdered) {
            cost += media.getCost();
        }
        return cost;
    }

    public void printList() {
        System.out.println("***********************CART***********************");
        System.out.println("Items ordered: ");
        for (Media dvd: itemsOrdered) {
                System.out.println(dvd.toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("***************************************************");
    }

    public void searchById(int idToMatch) {
        boolean dvdFound = false;
        for (Media dvd: itemsOrdered) {
            if (dvd.getId() == idToMatch) {
                dvd.toString();
                dvdFound = true;
            }
        }
        if (dvdFound == false) {
            System.out.println("Item not found.");
        } 
    }

    public void searchByTitle(String titleToMatch) {
        boolean dvdFound = false;
        for (Media dvd:itemsOrdered) {
            if (((DigitalVideoDisc) dvd).isMatch(titleToMatch)) {
                dvd.toString();
                dvdFound = true;
            }
        }
        if (dvdFound == false) {
            System.out.println("Item not found.");
        }
    }
    
}