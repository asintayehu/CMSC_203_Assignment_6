
public class Smoothie extends Beverage {
	
	private int numOfFruits;
	private boolean addProtein;
	
	private final double PROTEIN_CHARGE = 1.50;
	private final double FRUIT_CHARGE = 0.5;

	Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein){
		super(bevName, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
	}
	
	@Override
	public double calcPrice() {
	    double fruitPrice = 0.0;
	    double proteinCharge = 0.0;
	    
	    if (this.numOfFruits > 0) {
	        fruitPrice = this.getNumOfFruits() * FRUIT_CHARGE;
	    }
	    
	    if (this.addProtein) {
	        proteinCharge = PROTEIN_CHARGE;
	    }
	    
	    double total = addSizePrice() + fruitPrice + proteinCharge;
	    
	    return total;
	}

	
	public boolean getAddProtein() {
		return this.addProtein; 
	}
	
	public int getNumOfFruits() {
		return this.numOfFruits;
	}
	
	public String toString() {
		return super.getBevName() + ", " + super.getSize() + ", " + this.getAddProtein() + ", " + this.getNumOfFruits() + ", " + this.calcPrice();
	}
	
	@Override
	public boolean equals(Beverage anotherBev) {
		Smoothie s;
		if(anotherBev instanceof Smoothie) {
			s = (Smoothie) anotherBev;
		} else {
			return false;
		}
		if(super.equals(anotherBev) == true && s.getAddProtein() == this.getAddProtein() && s.getNumOfFruits() == this.getNumOfFruits() && s.calcPrice() == this.calcPrice()) {
			return true;
		}else{
			return false;
		}
	}
	
}
