package hust.soict.hedspi.aims;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AimsProject {
    static Scanner sc = new Scanner(System.in);
    static Store store = new Store();
    static Cart cart = new Cart();

    public static void main(String[] args) {
        loadExample();
        showMenu();
    }

    public static void loadExample() {
        // DVD examples
        DigitalVideoDisc dvd1 = new DigitalVideoDisc()"The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Aladdin", "Animation", "Ron Clements", 90, 24.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Spirited Away", "Animation", "Hayao Miyazaki", 125, 22.50f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("The Matrix", "Sci-Fi", "Lana Wachowski", 136, 21.00f);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);
        store.addMedia(dvd5);

        // CD examples
        CompactDisc cd1 = new CompactDisc("Abbey Road", "Music", 47.2f);
        CompactDisc cd2 = new CompactDisc("Back in Black", "Music", 42.1f);
        CompactDisc cd3 = new CompactDisc("Rumours", "Music", 39.3f);
        CompactDisc cd4 = new CompactDisc("21", "Music", 48.0f);
        CompactDisc cd5 = new CompactDisc("Random Access Memories", "Music", 74.0f);

        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
        store.addMedia(cd4);
        store.addMedia(cd5);

        // Book examples
        Book book1 = new Book("A Game of Thrones", "Fantasy", 50.0f, new ArrayList<>(List.of("George R.R. Martin")));
        Book book2 = new Book("The Name of the Wind", "Fantasy", 30.0f, new ArrayList<>(List.of("Patrick Rothfuss")));
        Book book3 = new Book("Mistborn", "Fantasy", 40.0f, new ArrayList<>(List.of("Brandon Sanderson")));
        Book book4 = new Book("The Way of Kings", "Fantasy", 45.0f, new ArrayList<>(List.of("Brandon Sanderson")));
        Book book5 = new Book("Eragon", "Fantasy", 55.0f, new ArrayList<>(List.of("Christopher Paolini")));
        Book book6 = new Book("The Blade Itself", "Fantasy", 35.0f, new ArrayList<>(List.of("Joe Abercrombie")));

        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
        store.addMedia(book4);
        store.addMedia(book5);
        store.addMedia(book6);
    }

    public static void showMenu() {
        while (true) {
            System.out.println("AIMS: ");
            System.out.println("--------------------------------");
            System.out.println("1. View store");
            System.out.println("2. Update store");
            System.out.println("3. See current cart");
            System.out.println("0. Exit");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3");
            switch (sc.nextInt()) {
                case 0:
                    return;
                case 1:
                    storeMenu();
                    break;
                case 2:
                    updateStoreMenu();
                    break;
                case 3:
                    cartMenu();
                    break;
            }
        }
    }

    public static void storeMenu() {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
            switch (sc.nextInt()) {
                case 0:
                    return;
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    cartMenu();
                    break;
            }
        }
    }

    public static void seeMediaDetails() {
        System.out.println("Enter the title: ");
        Media media = store.getMedia(sc.next());
        if (media != null) {
            System.out.println(media);
        } else {
            System.out.println("No such media !!!");
        }
    }

    public static void addMediaToCart() {
        System.out.println("Enter the title: ");
        Media media = store.getMedia(sc.next());
        if (media != null) {
            cart.addMedia(media);
            System.out.println("The media added to the cart");
        } else {
            System.out.println("No such media !!!");
        }
    }



    public static void playMedia() {
        System.out.println("Enter the title: ");
        Media media = store.getMedia(sc.next());
        if (media != null) {
            if (media instanceof CompactDisc CD) {
                CD.play();
            } else if (media instanceof DigitalVideoDisc DVD) {
                DVD.play();
            } else {
                System.out.println("The media is not playable !!!");
            }
        } else {
            System.out.println("No such media !!!");
        }
    }

    public static void updateStoreMenu() {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add media to store");
            System.out.println("2. Remove media");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            switch (sc.nextInt()) {
                case 0:
                    return;
                case 1:
                    addMediaToStore();
                    break;
                case 2:
                    removeMediaFromStore();
                    break;
            }
        }
    }

    public static void cartMenu() {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter media in cart");
            System.out.println("2. Sort media in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4-5");
            switch (sc.nextInt()) {
                case 0:
                    return;
                case 1:
                    filterMedia();
                    break;
                case 2:
                    sortMedia();
                    break;
                case 3:
                    removeMedia();
                    break;
                case 4:
                    playMedia();
                    break;
                case 5:
                    System.out.println("Order have been created!");
                    cart.empty();
                    break;
            }
        }
    }

    public static void filterMedia() {
        System.out.println("Pick Filter Options: ");
        System.out.println("**************************");
        System.out.println("1 - Filter by ID");
        System.out.println("2 - Filter by Title");
        System.out.println("0 - Back");
        System.out.println("**************************");
        System.out.println("Choose a number: 0-1-2");
        switch (sc.nextInt()) {
            case 0:
                return;
            case 1:
                filterByID();
                break;
            case 2:
                filterByTitle();
                break;
        }
    }

    public static void filterByID() {
        System.out.println("Enter Media ID: ");
        System.out.println(cart.search(sc.nextInt()));
    }

    public static void filterByTitle() {
        System.out.println("Enter Media title: ");
        System.out.println(cart.search(sc.next()));
    }

    public static void sortMedia() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by Title");
        System.out.println("2. Sort by Price");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        switch (sc.nextInt()) {
            case 0:
                break;
            case 1:
                sortMediaByTitle();
                break;
            case 2:
                sortMediaByPrice();
                break;
        }
    }

    public static void sortMediaByTitle() {
        cart.sortByTitle();
        System.out.println("Media successfully sorted by title");
    }

    public static void sortMediaByPrice() {
        cart.sortByPrice();
        System.out.println("Media successfully sorted by price");
    }

    public static void removeMedia() {
        System.out.println("Enter the Title: ");
        Media media = cart.search(sc.next());
        if (media != null) {
            cart.removeMedia(media);
            System.out.println("Media successfully removed from the cart");
        } else {
            System.out.println("Media doesnt exist");
        }
    }


    public static void addMediaToStore() {
        System.out.println("Enter type of media (1: DVD, 2: CD, 3: Book): ");
        int type = sc.nextInt();

        System.out.println("Enter the title: ");
        String title = sc.next();
        System.out.println("Enter the category: ");
        String category = sc.next();
        System.out.println("Enter the cost: ");
        float cost = sc.nextFloat();

        Media media;
        switch (type) {
            case 1:
                System.out.println("Enter the director: ");
                String director = sc.next();
                System.out.println("Enter the length: ");
                int length = sc.nextInt();
                media = new DigitalVideoDisc(title, category, director, length, cost);
                break;

            case 2:
                CompactDisc cd = new CompactDisc(title, category, cost);
                System.out.println("Enter the number of track");
                int numTrack = sc.nextInt();
                for (int i=0; i<numTrack; i++) {
                    System.out.println("Enter the track title:");
                    String trackTitle = sc.next();
                    System.out.println("Enter the track length:");
                    int trackLength = sc.nextInt();
                    cd.addTrack(new Track(trackTitle, trackLength));
                }
                media = cd;
                break;

            case 3:
                ArrayList<String> authors = new ArrayList<>();
                System.out.println("Enter the number of author");
                int numAuthor = sc.nextInt();
                for (int i=0; i<numAuthor; i++) {
                    System.out.println("Enter the author: ");
                    authors.add(sc.next());
                }
                media = new Book(title, category, cost, authors);
                break;
            default:
                System.out.println("Invalid media type!");
                return;
        }
        store.addMedia(media);
        System.out.println("Media added to store successfully!");
    }

    public static void removeMediaFromStore() {
        System.out.println("Enter the title of the media to remove: ");
        String title = sc.next();
        Media media = store.getMedia(title);
        if (media != null) {
            store.removeMedia(title);
            System.out.println("Media removed from store successfully!");
        } else {
            System.out.println("No such media in store!");
        }
    }
}


