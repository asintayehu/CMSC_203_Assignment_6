import java.util.Random;
import java.util.ArrayList;

public class Order implements OrderInterface, Comparable<Order>{
	
	private int orderTime;
	private Day orderDay;
	private Customer cust;
	private ArrayList<Beverage> orders = new ArrayList<Beverage>();
	private int orderNum;
	
	Order(int orderTime, Day orderDay, Customer cust){
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = cust;
		this.orderNum = generateOrder();
	}
	
	public int generateOrder() {
		int max = 90000;
		int min = 10000;
		Random random = new Random();
		int orderNum = random.nextInt(max - min) + min;
		
		return orderNum;
	}

	@Override
	// compare with another order based on order number
	// return 0 if the order number is same as another order number
	// return 1 is the order number is greater than other order number
	// return -1 if its smaller than other order number
	public int compareTo(Order o) {
		if(o.getOrderNo() == this.getOrderNo()) {
			return 0;
		} else if(this.getOrderNo() > o.getOrderNo()) {
			return 1;
		} else {
			return -1;
		}
	}
	
	public int getOrderTime() {
		return this.orderTime;
	}
	
	public int getTotalItems() {
		return orders.size();
	}
	
	public String toString() {
		String beverages = "";
		
		for(Beverage b : orders) {
			beverages += b.getBevName() + ", ";
		}
		
		return this.getOrderNo() + ", " + this.getOrderTime() + ", " + this.getOrderDay() + ", " + this.getCustomer() + ", " + beverages;
	}
	
	public int getOrderNo() {
		return this.orderNum;
	}

	@Override
	public boolean isWeekend() {
		if(this.getOrderDay() == Day.SATURDAY || this.getOrderDay() == Day.SUNDAY) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		Beverage target = orders.get(itemNo);
		return target;
	}

	@Override
	// adds a new coffee
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		Coffee c = new Coffee(bevName, size, extraShot, extraSyrup);
		orders.add(c);
	}

	@Override
	// adds a new alcohol drink
	public void addNewBeverage(String bevName, Size size) {
		// dictate whether or not it's the weekend
		Alcohol a = new Alcohol(bevName, size, this.isWeekend());
		orders.add(a);
	}

	@Override
	// adds a new smoothie drink
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		Smoothie s = new Smoothie(bevName, size, numOfFruits, addProtein);
		orders.add(s);
		
	}

	@Override
	public double calcOrderTotal() {
		double total = 0.0;
		for(Beverage b : orders) {
			total += b.calcPrice();
		}
		return total;
	}
	
	public Customer getCustomer() {
		return this.cust;
	}

	@Override
	public int findNumOfBeveType(Type type) {
		int count = 0;
		for(Beverage b : orders) {
			if(b.getType() == type) {
				count += 1;
			}
		}
		return count;
	}
	
	public Day getDay() {
		return this.getOrderDay();
	}
	
	public Day getOrderDay() {
		return this.orderDay;
	}
	
}
