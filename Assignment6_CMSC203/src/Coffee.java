
public class Coffee extends Beverage{
	
	boolean extraShot;
	boolean extraSyrup;

	Coffee(String bevName, Size size, boolean moreShot, boolean moreSyrup) {
		super(bevName, Type.COFFEE, size);
		this.extraShot = moreShot;
		this.extraSyrup = moreSyrup;
	}
	
	@Override
	public boolean equals(Beverage anotherBev) {
		Coffee c;
		if(anotherBev instanceof Coffee) {
			c = (Coffee) anotherBev;
		} else {
			return false;
		}
		if(super.equals(anotherBev) && this.calcPrice() == c.calcPrice() && this.getExtraShot() == c.getExtraShot() && this.getExtraSyrup() == c.getExtraSyrup()) {
			return true;
		}
		return false;
	}
	
	public boolean getExtraShot() {
		return this.extraShot;
	}
	
	public boolean getExtraSyrup() {
		return this.extraSyrup;
	}
	
	public String toString() {
		return this.getBevName() + ", " + this.getExtraShot() + ", " + this.getExtraSyrup() + ", " + this.calcPrice();
	}
	
	@Override
	public double calcPrice() {
		double shotPrice = 0.0;
		double syrupPrice = 0.0;
		
		if(this.getExtraShot() == true) {
			shotPrice +=  0.5;
		}
		
		if(this.getExtraSyrup() == true) {
			shotPrice += 0.5;
		}
		
		return super.addSizePrice() + (shotPrice + syrupPrice);
	}
	

}
