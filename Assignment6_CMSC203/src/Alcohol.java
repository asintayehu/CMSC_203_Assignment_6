
public class Alcohol extends Beverage{
	
	private boolean isWeekend;
	
	Alcohol(String bevName, Size size, boolean isWeekend){
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}
	
	@Override
	public boolean equals(Beverage anotherBev) {
		Alcohol a;
		if(anotherBev instanceof Alcohol) {
			a = (Alcohol) anotherBev;
		} else {
			return false;
		}
		
		if(super.equals(anotherBev) == true && this.calcPrice() == a.calcPrice() && this.isWeekend() == a.isWeekend()) {
			return true;
		} else {
			return false;
		}
	}
	
	// if is weekend is true then +.60 cents for total
	@Override
	public double calcPrice() {
		double weekendCharge = 0.0;
		
		if(this.isWeekend() == true)
			weekendCharge += 0.60;
		
		return super.addSizePrice() + weekendCharge;
	}
	
	public boolean isWeekend() {
		return this.isWeekend;
	}
	
	public String toString() {
		return this.getBevName() + ", " + super.getSize() + ", " + this.isWeekend() + ", " + this.calcPrice();
	}
}
