package Ch8ClassesProjectQuestions;

public class GroceryItemOrder {

	String name;
	double price;
	int number;
	
	public GroceryItemOrder(int number, String name, int price){
		
		this.name = name;
		this.number = number;
		this.price = price;
		
	}
	
	public double getCost(){
		return price;
	}
	
	public void setQuantity(int quantity){
		this.number = quantity;
	}
	
}
