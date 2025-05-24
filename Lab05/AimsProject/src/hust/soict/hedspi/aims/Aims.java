package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.CompactDisc;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.disc.Playable;
import hust.soict.hedspi.aims.disc.Track;
import hust.soict.hedspi.aims.exceptions.PlayerException;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
    private static Scanner scanner = new Scanner(System.in);
    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) throws Exception {
        // Initialize store and some media
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Annabelle", "Horror", "Unknown", 108, 29.95f);
        Book book1 = new Book("Atomic Habits", "Self Help", 19.95f);
        book1.addAuthor("James Clear");
        CompactDisc cd1 = new CompactDisc("The Best of Mozart", "Classic", "Mozart", 15.99f);
        Track track1 = new Track("Chung ta cua tuong lai", "Son Tung MTP", 1);
        Track track2 = new Track("Bad Guy", "Billie Eilish", 2);
        cd1.addTrack(track1);
        cd1.addTrack(track2);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(cd1);
        store.addMedia(book1);

        cart.addMedia(cd1);
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);

        // Application loop
        mainMenu: while (true) {
            showMenu();
            int choiceMain = scanner.nextInt();
            switch (choiceMain) {
                case 1:
                    store.viewStore();
                    storeMenu: while (true) {
                        storeMenu();
                        int choiceViewStore = scanner.nextInt();
                        switch (choiceViewStore) {
                            case 1:
                                ViewStore.seeMediaDetails();
                                break;
                            case 2:
                                ViewStore.addMediaToStore();
                                break;
                            case 3:
                                ViewStore.playAMedia();
                                break;
                            case 4:
                                cart.print();
                                break;
                            case 0:
                                break storeMenu;
                            default:
                                break;
                        }
                    }
                    break;
                case 2:
                    updateMenu: while (true) {
                        updateStoreMenu();
                        int choiceUpdateStore = scanner.nextInt();
                        switch (choiceUpdateStore) {
                            case 1:
                                UpdateStore.addMediaToStore();
                                break;
                            case 2:
                                UpdateStore.removeMediaFromStore();
                                break;
                            case 0:
                                break updateMenu;
                            default:
                                break;
                        }
                    }
                    break;
                case 3:
                    cartMenu: while (true) {
                        cart.print();
                        cartMenu();
                        int choiceCart = scanner.nextInt();
                        switch (choiceCart) {
                            case 1:
                                System.out.println("1. Title          2. Id");
                                System.out.print("Enter type of filter: ");
                                int choiceFitlerType = scanner.nextInt();
                                if (choiceFitlerType == 1) {
                                    System.out.print("Enter keyword: ");
                                    scanner.nextLine();
                                    String keyword = scanner.nextLine();
                                    cart.filterByTitle(keyword);
                                } else if (choiceFitlerType == 2) {
                                    System.out.print("Enter ID: ");
                                    int mediaID = scanner.nextInt();
                                    cart.filterByID(mediaID);
                                } else {
                                    System.out.println("Invalid choice");
                                }
                                break;
                            case 2:
                                System.out.println("1. Cost_Title         2. Title_Cost");
                                System.out.print("Sort by: ");
                                int sortChoice = scanner.nextInt();
                                if (sortChoice == 1) {
                                    Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
                                } else if (sortChoice == 2) {
                                    Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
                                } else {
                                    System.out.println("Invalid choice");
                                }
                                break;
                            case 3:
                                System.out.print("Enter the id of media: ");
                                int removeMediaID = scanner.nextInt();
                                for (var item : cart.getItemsOrdered()) {
                                    if (item.getID() == removeMediaID) {
                                        cart.removeMedia(item);
                                    }
                                }
                                break;
                            case 4:
                                System.out.print("Enter the id of media: ");
                                int mediaID = scanner.nextInt();
                                for (var item : cart.getItemsOrdered()) {
                                    if (item.getID() == mediaID) {
                                        if (item instanceof Playable) {
                                            ((Playable) item).play();
                                        } else {
                                            System.out.println("This media is not playable!");
                                        }
                                    }
                                }
                                break;
                            case 5:
                                for (var item : cart.getItemsOrdered()) {
                                    store.removeMedia(item);
                                }
                                System.out.println("Order placed");
                                break;
                            case 0:
                                break cartMenu;
                            default:
                                break;
                        }
                    }
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    scanner.close();
                    break mainMenu;
                default:
                    System.out.println("Please choose a valid option!");
                    break;
            }
        }
    }

    private class UpdateStore {
        public static void addMediaToStore() {
            scanner.nextLine();
            System.out.print("1. Book\t2. DVD\t3.CD\n");
            System.out.print("Enter the type of media: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter the title of book: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter the category of book: ");
                    String category = scanner.nextLine();

                    System.out.print("Enter the cost of book: ");
                    float cost = scanner.nextFloat();
                    scanner.nextLine();

                    System.out.print("Enter author(s) of book - separate by comma: ");
                    String line = scanner.nextLine();

                    ArrayList<String> authors = new ArrayList<>(List.of(line.split(",")));

                    Book book = new Book(title, category, cost, authors);
                    store.addMedia(book);
                    break;
                case 2:
                    System.out.print("Enter the title of DVD: ");
                    title = scanner.nextLine();

                    System.out.print("Enter the category of DVD: ");
                    category = scanner.nextLine();

                    System.out.print("Enter the director of DVD: ");
                    String director = scanner.nextLine();

                    System.out.print("Enter the length of DVD: ");
                    int length = scanner.nextInt();

                    System.out.print("Enter the cost of DVD: ");
                    cost = scanner.nextFloat();
                    scanner.nextLine();

                    DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
                    store.addMedia(dvd);
                    break;
                case 3:
                    System.out.print("Enter the title of CD: ");
                    title = scanner.nextLine();

                    System.out.print("Enter the category of CD: ");
                    category = scanner.nextLine();

                    System.out.print("Enter the artist of CD: ");
                    String artist = scanner.nextLine();

                    System.out.print("Enter the cost of CD: ");
                    cost = scanner.nextFloat();

                    CompactDisc cd = new CompactDisc(title, category, artist, cost);

                    System.out.print("Enter the number of tracks: ");
                    int numTracks = scanner.nextInt();
                    for (int i = 0; i < numTracks; i++) {
                        System.out.print("Enter the title of track " + (i + 1) + ": ");
                        scanner.nextLine();
                        String trackTitle = scanner.nextLine();
                        System.out.print("Enter the length of track " + (i + 1) + ": ");
                        int trackLength = scanner.nextInt();
                        Track track = new Track(trackTitle, artist, trackLength);
                        cd.addTrack(track);
                    }
                    store.addMedia(cd);
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }

        public static void removeMediaFromStore() {
            System.out.print("Enter the title of media: ");
            scanner.nextLine();
            String title = scanner.nextLine();
            for (var item : store.getItemsInStore()) {
                if (item.getTitle().toLowerCase().equals(title.toLowerCase())) {
                    store.removeMedia(item);
                }
            }
        }
    }

    private class ViewStore {
        public static void seeMediaDetails() {
            System.out.print("Enter the title of media: ");
            scanner.nextLine();
            String title = scanner.nextLine();
            for (var item : store.getItemsInStore()) {
                if (item.getTitle().toLowerCase().equals(title.toLowerCase())) {
                    System.out.println(item.toString());
                    outerloop: while (true) {
                        mediaDetailsMenu();
                        int choiceDetailsMenu = scanner.nextInt();
                        switch (choiceDetailsMenu) {
                            case 1:
                                if (item instanceof DigitalVideoDisc) {
                                    try {

                                        ((DigitalVideoDisc) item).play();
                                    } catch (PlayerException e) {
                                        System.out.println(e.getMessage());
                                    }
                                } else if (item instanceof CompactDisc) {
                                    ((CompactDisc) item).play();
                                } else {
                                    System.out.println("This media is not playable");
                                }
                                break;
                            case 2:
                                cart.addMedia(item);
                                break;
                            case 0:
                                System.out.println("Bye");
                                break outerloop;
                            default:
                                break;
                        }
                    }
                    break;
                }
            }
        }

        public static void addMediaToStore() {
            System.out.print("Enter the title of media: ");
            scanner.nextLine();
            String title = scanner.nextLine();
            for (var item : store.getItemsInStore()) {
                if (item.getTitle().toLowerCase().equals(title.toLowerCase())) {
                    cart.addMedia(item);
                }
            }
        }

        public static void playAMedia() {
            System.out.print("Enter the title of media: ");
            scanner.nextLine();
            String title = scanner.nextLine();
            for (var item : store.getItemsInStore()) {
                if (item.getTitle().toLowerCase().equals(title.toLowerCase())) {
                    if (item instanceof DigitalVideoDisc) {
                        try {
                            ((DigitalVideoDisc) item).play();
                        } catch (PlayerException e) {
                            System.out.println(e.getMessage());
                        }
                    } else if (item instanceof CompactDisc) {
                        ((CompactDisc) item).play();
                    } else {
                        System.out.println("This media is not playable");
                    }
                }
            }
        }
    }

    public static void showMenu() {
        System.out.println("AIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options:");
        System.out.println("------------------------------------------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current Cart");
        System.out.println("0. Exit");
        System.out.println("------------------------------------------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void cartMenu() {
        System.out.println("Options:");
        System.out.println("------------------------------------------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("------------------------------------------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options:");
        System.out.println("------------------------------------------------------------------");
        System.out.println("1. Play");
        System.out.println("2. Add to cart");
        System.out.println("0. Back");
        System.out.println("------------------------------------------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void updateStoreMenu() {
        System.out.println("Options:");
        System.out.println("------------------------------------------------------------------");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.println("0. Back");
        System.out.println("------------------------------------------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }
}
