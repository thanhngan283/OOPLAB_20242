package hust.soict.hedspi.test.cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.CompactDisc;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.Media;

public class CartTest {
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);
        cart.print();
        // Test search method
        System.out.println();
        search(19.0f, 20.0f);
        System.out.println();
        search(20.0f);
        System.out.println();
        search("lion");

        // Test polymorphism
        System.out.println("----------------------------------");
        System.out.println("Test polymorphism:");
        Book book = new Book("Atomic Habits", "Self Help", 19.95f);
        book.addAuthor("James Clear");
        CompactDisc cd = new CompactDisc("The Best of Mozart", "Classic", "Mozart", 15.99f);

        List<Media> items = new ArrayList<Media>();
        items.add(dvd3);
        items.add(cd);
        items.add(book);

        for (var item : items) {
            System.out.println(item.toString());
        }
        System.out.println("----------------------------------");

        // Test equals override
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        System.out.println(dvd1.equals(dvd4));

        // Test sort
        System.out.println("----------------------------------");
        System.out.println("Test sort:");
        Collections.sort(items, Media.COMPARE_BY_COST_TITLE);
        for (var item : items) {
            System.out.println(item.toString());
        }
        System.out.println("----------------------------------");

    }

    public static void search(String keyword) {
        System.out.println("Search by keywords results:");
        for (var item : cart.getItemsOrdered()) {
            if (item.isMatch(keyword)) {
                System.out.println(item.toString());
            }
        }
    }

    public static void search(float maxCost) {
        System.out.println("Search by cost results:");
        for (var item : cart.getItemsOrdered()) {
            if (item.isMatch(maxCost)) {
                System.out.println(item.toString());
            }
        }
    }

    public static void search(float minCost, float maxCost) {
        System.out.println("Search by cost range results:");
        for (var item : cart.getItemsOrdered()) {
            if (item.isMatch(minCost, maxCost)) {
                System.out.println(item.toString());
            }
        }
    }

}
