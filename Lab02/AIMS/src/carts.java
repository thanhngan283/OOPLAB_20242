
public class carts {
	 public static final int MAX_NUMBERS_ORDERED = 20;
	    private DVD itemsOrdered[] = new DVD[MAX_NUMBERS_ORDERED];
	    public int qtyOrdered = 0; 
	    
	    public void addDVD(DVD disc) {
	    	if(qtyOrdered < MAX_NUMBERS_ORDERED) 
	    	{
	    		itemsOrdered[qtyOrdered] = disc;
	    		qtyOrdered++;
	    		System.out.println("The disc \"" + disc.getTitle()+ "\" has been added." );
	    	}
	    	else { 
	    		System.out.println("The cart is full.");
	    		 }
	    } 
	    public void removeDVD(DVD disc) {
	    	for(int i=0;i< qtyOrdered;i++) {
	    		if(itemsOrdered[i] ==disc) {
	    			for(int j = i;j< qtyOrdered - 1; j++) {
	    				itemsOrdered[j]=itemsOrdered[j+1];
	    			}
	    	itemsOrdered[qtyOrdered] = null;
	    	qtyOrdered--;
	    	System.out.println("The disc \""+disc.getTitle()+"\" has been removed");
	    		}
	    	}
	    	System.out.println("The disc \"" + disc.getTitle() + "\" not found in cart.");
	    }
	    public float totalCost() {
	    	float total=0;
	    	for(int i=0;i<qtyOrdered;i++)
	    	{	total=total+itemsOrdered[i].getCost();}
	    	return total;
	    }
	    
}
