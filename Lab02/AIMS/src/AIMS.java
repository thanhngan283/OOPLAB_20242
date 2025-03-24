
public class AIMS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		carts anOrder = new carts();
		
		DVD dvd1= new DVD("The Lion Kings","Animation","Roger Allers", 87, 24.95f);
		anOrder.addDVD(dvd1);
		
		DVD dvd2 = new DVD("Star Wars", "Science Fiction","George Lucas", 87, 24.95f);
		anOrder.addDVD(dvd2);
		
		DVD dvd3 = new DVD("Aladin", "Animation",18.99f);
		anOrder.addDVD(dvd3);
		
		anOrder.removeDVD(dvd3);
		
		System.out.println("Total cost is: ");
		System.out.println(anOrder.totalCost());
	}

}
