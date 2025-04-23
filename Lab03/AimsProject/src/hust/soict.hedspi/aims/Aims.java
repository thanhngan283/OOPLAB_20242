package hust.soict.hedspi.aims;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
	private static Scanner scanner = new Scanner(System.in);
	public static Store store = new Store();
	public static Cart cart = new Cart();
	public static void main(String[] args) {
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
				"Animation", "Roger Allers", 87, 19.95f);
		store.addMedia(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
				"Science Fiction", "George Lucas", 87, 24.95f);
		store.addMedia(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
				"Animation", 18.99f);
		store.addMedia(dvd3);
		showMenu();	
	}
	
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");

		int option = scanner.nextInt();
		scanner.nextLine();
		switch (option){
			case 1:
				viewStore();
				break;
			case 2:
				updateStore();
				break;
			case 3:
				seeCurrentCart();
				break;
			case 0:
				System.out.println("You are exitted.");
				break;
		}
		
	}

	//Option 1	
	private static void viewStore(){
		for (Media item: store.getItemsInStore()){
			System.out.println(item);
		}
		storeMenu();
	}

	private static void storeMenu(){
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media's details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		System.out.print("Choose a number: ");
		int option = scanner.nextInt();
		scanner.nextLine();

		switch (option){
			case 1:
				seeMediaDetail();
				break;
			case 2:
				addMedia2Cart();
				break;
			case 3:
				playMedia();
				break;
			case 4:
				currentCart();
				break;
			case 0:
				showMenu();
				break;
		}
		storeMenu();
	}
		//Option 1.1
		private static void seeMediaDetail(){
			System.out.println("Enter title of media: ");
			String title = scanner.nextLine();
			boolean isInStore = false;
			for (Media media: store.getItemsInStore()){
				if (media.getTitle().equals(title)){
					Media yourMedia = media;
					isInStore = true;
					System.out.println(media);
					mediaDetailsMenu(yourMedia);
				}
			}
			if (!isInStore){
				System.out.println("This media is not in the store.");
				
			}
			storeMenu();
		}

		public static void mediaDetailsMenu(Media media) {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Add to cart");
			System.out.println("2. Play");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2");

			int option = scanner.nextInt();
			scanner.nextLine();
			switch (option){
				case 1:
					cart.addMedia(media);
					break;
				case 2:
					if (media instanceof CompactDisc){
						CompactDisc castMedia = (CompactDisc) media;
						castMedia.play();
					} else if ( media instanceof DigitalVideoDisc){
						DigitalVideoDisc castMedia = (DigitalVideoDisc) media;
						castMedia.play();
					} else {
						System.out.println("This media can not display.");
						mediaDetailsMenu(media);
					}
				case 0:
					
					break;
			}
			storeMenu();
		}

		//Option 1.2
		private static void addMedia2Cart(){
			for (Media media: store.getItemsInStore()){
				System.out.println(media);
			}
			System.out.println("Enter title of media to add:");
			String yourTitle = scanner.nextLine();
			boolean isInStore = false;
			for (Media media: store.getItemsInStore()){
				if (media.getTitle().equals(yourTitle)){
					cart.addMedia(media);
					isInStore = true;
				}
				
			}
			if (!isInStore){
				System.out.println("This is not valid title");
				
			}
			storeMenu();
		}

		//Option 1.3
		private static void playMedia(){
			System.out.println("Enter the title of media to play");
			String yourTitle = scanner.nextLine();
			boolean isInStore = false;
			for (Media media: store.getItemsInStore()){
				if (media.getTitle().equals(yourTitle)){
					isInStore = true;
					if (media instanceof CompactDisc){
						CompactDisc castMedia = (CompactDisc) media;
						castMedia.play();
					} else if ( media instanceof DigitalVideoDisc){
						DigitalVideoDisc castMedia = (DigitalVideoDisc) media;
						castMedia.play();
					} else {
						System.out.println("This media can not play");
					}
				}
			}
			if (!isInStore){
				System.out.println("Can not find media with this title");
			}
			storeMenu();
		}
		//Option 1.4
		private static void currentCart(){
			seeCurrentCart();
		}



	//Option 2
	private static void updateStore(){
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a media to store");
		System.out.println("2. Remove a media from store");
		System.out.println("0. Back");

		System.out.println("Choose a number:");
		int option = scanner.nextInt();
		scanner.nextLine();

		switch (option){
			case 1:
				addMediaToStore();
				break;
			case 2:
				
				removeMediaStore();
				break;
			case 0:
				
				break;
		}
		showMenu();
	}
	public static void addMediaToStore(){
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Book");
		System.out.println("2. DigitalVideoDisc");
		System.out.println("3. CompactDisc");
		System.out.println("0. Back");

		int option = scanner.nextInt();
		scanner.nextLine();
		switch (option) {
			case 1:
				System.out.println("Enter id of media: ");
				int id = scanner.nextInt();
				System.out.println("Enter title of media: ");
				String title = scanner.nextLine();
				System.out.println("Enter category of media: ");
				String category = scanner.nextLine();
				System.out.println("Enter cost of media: ");
				float cost = scanner.nextFloat();
				System.out.println("Enter the number of authors: ");
				int num = scanner.nextInt();
				List<String> authors = new ArrayList<String>();
				for (int i =0; i<num;i++) {
					String au = scanner.nextLine();
					authors.add(au);
				}
				scanner.nextLine();
				Book addBook = new Book(id, title, category, cost, authors);
				store.addMedia(addBook);
				break;
			case 2:
				System.out.println("Enter title of media: ");
				String title1 = scanner.nextLine();
				System.out.println("Enter category of media: ");
				String category1 = scanner.nextLine();
				System.out.println("Enter director of media: ");
				String director = scanner.nextLine();
				System.out.println("Enter cost of media: ");
				float cost1 = scanner.nextFloat();
				
				scanner.nextLine();
				DigitalVideoDisc addDVD = new DigitalVideoDisc(title1, category1, director, cost1);
				store.addMedia(addDVD);
				break;
			case 3:
				System.out.println("Enter id of media: ");
				int id2 = scanner.nextInt();
				System.out.println("Enter title of media: ");
				String title2 = scanner.nextLine();
				System.out.println("Enter category of media: ");
				String category2 = scanner.nextLine();
				System.out.println("Enter cost of media: ");
				float cost2 = scanner.nextFloat();
				System.out.println("Enter artist of media: ");
				String artist = scanner.nextLine();
				scanner.nextLine();
				CompactDisc addCompactDisc = new CompactDisc(id2, title2, category2, cost2, artist);
				store.addMedia(addCompactDisc);
				break;
			case 0:
				showMenu();
		}
	}

	public static void removeMediaStore(){
		store.display();
		System.out.println("Enter id of media to remove:");
		int id = scanner.nextInt();
		scanner.nextLine();
		boolean isInStore = false;
		for (Media media: store.getItemsInStore()){
			if (media.getId() == id){
				isInStore = true;
				store.removeMedia(media);
				}
			}
		if (!isInStore){
			System.out.println("Can not find media with id = " + id);
		}
		updateStore();
	}


	//Option 3
	private static void seeCurrentCart(){
		cart.printList();;
		cartMenu();

	}

	public static void cartMenu(){
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");

		int option = scanner.nextInt();
		scanner.nextLine();
		switch (option){
			case 1:
				fillterMedia();
				break;
			case 2:
				sortMedia();
				break;
			case 3:
				removeMedia();
				break;
			case 4:
				playMediaCart();
				break;
			case 5:
				placeOrder();
				break;
			case 0:
				showMenu();
				break;
		}
		cartMenu();
	}
		//Option 3.1
	public static void fillterMedia(){
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter by id");
		System.out.println("2. Filter by title");
		System.out.println("0. Back");

		int option = scanner.nextInt();
		scanner.nextLine();
		switch (option){

			case 1:
				int id = scanner.nextInt();
				cart.searchById(id);
				cartMenu();
				break;
			case 2: 
				String title = scanner.nextLine();
				cart.searchByTitle(title);
				cartMenu();
				break;
			case 0:
				cartMenu();
				break;
		}
		cartMenu();
	}
		//Option 3.2
		public static void sortMedia(){
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Sort by id");
		System.out.println("2. Sort by title");
		System.out.println("0. Back");
		
		int option = scanner.nextInt();
		switch (option) {
			case 1:
				Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
				cart.printList();
				cartMenu();
				break;
		
			case 2:
				Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
				cart.printList();
				cartMenu();
				break;
			case 0:
				cartMenu();
				break;

		}
		cartMenu();
	}
	public static void removeMedia(){
		cart.printList();;
		System.out.println("Enter id of media in cart to remove");
		int id = scanner.nextInt();
		scanner.nextLine();
		boolean isinCart = false;
		for (Media media: cart.getItemsOrdered()){
			if (media.getId() == id){
				isinCart = true;
				cart.removeMedia(media);
			}
		}
		if (!isinCart){
			System.out.println("Can not find media with ID = " + id);
			
		}
		cartMenu();

	}
	public static void playMediaCart(){
		cart.printList();;
		System.out.println("Enter id of media in cart to play");
		int id = scanner.nextInt();
		scanner.nextLine();
		boolean isinCart = false;
		for (Media media: cart.getItemsOrdered()){
			
			if (media.getId() == id){
				if (media instanceof CompactDisc){
					CompactDisc castMedia = (CompactDisc) media;
					castMedia.play();
					cartMenu();
				} else if (media instanceof DigitalVideoDisc){
					DigitalVideoDisc castMedia = (DigitalVideoDisc) media;
					castMedia.play();
					cartMenu();
				} else {
					System.out.println("Media with this id is not playable.");
					cartMenu();
				}
			}
		}
		if (!isinCart){
			System.out.println("Can not find media with ID = " + id + " to play.");
		}
		cartMenu();
	}
	public static void placeOrder(){
		System.out.println("Your order is prepared.");
		cart = new Cart();
	}

}
