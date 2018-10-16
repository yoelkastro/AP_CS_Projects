package Ch8ClassesProjectQuestions;

import java.util.ArrayList;

public class GroceryList {

	ArrayList<GroceryItemOrder> items = new ArrayList<GroceryItemOrder>();
	
	public GroceryList(){}
	
	public void add(GroceryItemOrder g){
		if(items.size() < 10){
			items.add(g);
		}
	}
	
	public double getTotalCost(){
		double ret = 0.0;
		for(int i = 0; i < items.size(); i ++){
			ret += items.get(i).getCost();
		}
		
		return ret;
	}
}
