
package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;

import java.util.ArrayList;
import java.util.List;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Inception", 
            "Science Fiction", "Christopher Nolan", 148, 22.50f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Titanic", 
            "Romance", "James Cameron", 195, 18.75f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
            "Animation", 18.99f);
        cart.addMedia(dvd3);

        List<String> authors = new ArrayList<String>();
        authors.add("LTK");
        Book book1 = new Book(1, "Sherlock Holmes", "Thriller", 20.99f, authors);
        cart.addMedia(book1);

        cart.toString();
        cart.printList();
    }
    
}

