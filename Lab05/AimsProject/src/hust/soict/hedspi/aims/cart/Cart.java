package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    public static final int MAX_NUMBERS_ORDER = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media media) {
        if (itemsOrdered.size() <= MAX_NUMBERS_ORDER) {
            itemsOrdered.add(media);
            int newID = itemsOrdered.indexOf(media) + 1;
            for (var item : itemsOrdered) {
                if (item.getID() == newID) {
                    newID++;
                }
            }
            media.setID(newID);
        } else {
            System.out.println("The cart is almost full");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
        } else {
            System.out.println("The item is not in the cart");
        }
    }

    public float totalCost() {
        float total = 0;
        for (var item : itemsOrdered) {
            total += item.getCost();
        }
        return total;
    }

    public void print() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (var item : itemsOrdered) {
            System.out.println(item.getID() + ": " + item.toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("**************************************************");
    }

    public void filterByTitle(String title) {
        System.out.println("Filter by title " + '"' + title + '"' + ": ");
        for (var item : itemsOrdered) {
            if (item.isMatchByTitle(title)) {
                System.out.println(item.toString());
            }
        }
    }

    public void filterByID(int matchID) {
        System.out.println("Filter by ID " + '"' + matchID + '"' + ": ");
        for (var item : itemsOrdered) {
            if (item.getID() == matchID) {
                System.out.println(item.toString());
            }
        }
    }
}
