package InheritanceDemo;

public class Car extends Vehicle{
	
	public Car(){
		this.wheelNumber = 4;
		this.passengerNumber = 5;
	}
	
	@Override
	public void park() {
		this.stop();
	}

	@Override
	public int sellingPrice() {
		return 5500;
	}
	
	public void openDoor(int door){
		
	}
}
