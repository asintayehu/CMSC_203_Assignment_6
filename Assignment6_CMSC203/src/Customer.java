
public class Customer {
	private String customerName;
	private int customerAge;
	
	Customer(String name, int age){
		this.customerName = name;
		this.customerAge = age;
	}
	
	Customer(Customer c){
		this.customerName = c.getName();
		this.customerAge = c.getAge();
	}
	
	public int getAge() {
		return this.customerAge;
	}
	
	public String getName() {
		return this.customerName;
	}
	
	public void setAge(int age) {
		this.customerAge = age;
	}
	
	public void setName(String name) {
		this.customerName = name;
	}
	
	public String toString() {
		return this.getName() + ", " + this.getAge();
	}
	
}
