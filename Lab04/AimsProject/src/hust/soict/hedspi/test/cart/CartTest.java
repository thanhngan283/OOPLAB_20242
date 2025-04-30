
package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;

import java.util.ArrayList;
import java.util.List;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);
        cart.addDigitalVideoDisc(dvd3);

        cart.print();

        // Test thự search by ID
        System.out.println("\n********** Testing search by ID **********");
        System.out.println("Test searching for ID 2:");
        cart.searchById(2);

        System.out.println("\nTest searching for ID 5:");
        cart.searchById(5);
        // Test thự search by title
        System.out.println("\n********** Testing search by title **********");
        System.out.println("Searching for 'The Lion King':");
        cart.searchByTitle("The Lion King");

        System.out.println("\nSearching for 'star':");
        cart.searchByTitle("star");

        // Search for non-existent title
        System.out.println("\nSearching for 'Avatar':");
        cart.searchByTitle("Avatar");

    }
}