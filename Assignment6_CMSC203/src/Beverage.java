
public abstract class Beverage {
	private static final double BASE_PRICE = 2.0;
	private static final double SIZE_UP = 0.5;
	
	private String beverageName;
	private Type beverageType;
	private Size beverageSize;
		
	Beverage(String bevName, Type type, Size size){
		this.beverageName = bevName;
		this.beverageType = type;
		this.beverageSize = size;
	}
	
	public abstract double calcPrice();
	
	public double addSizePrice() {
	    switch (this.getSize()) {
	        case LARGE:
	            return BASE_PRICE + 2 * SIZE_UP;
	        case MEDIUM:
	            return BASE_PRICE + SIZE_UP;
	        case SMALL:
	            return BASE_PRICE;
	        default:
	            return BASE_PRICE;
	    }
	}

	
	public boolean equals(Beverage anotherBev) {
		if(this.beverageName.equals(anotherBev.getBevName()) && this.beverageType == anotherBev.getType() && this.beverageSize == anotherBev.getSize()) {
			return true;
		}else {
			return false;
		}
	}
	
	public double getBasePrice() {
		return BASE_PRICE;
	}
	
	public String getBevName() {
		return this.beverageName;
	}
	
	public Size getSize() {
		return this.beverageSize;
	}
	
	public Type getType() {
		return this.beverageType;
	}
	
	public String toString() {
		return this.getBevName() + ", " + this.getSize();
	}
		
}
