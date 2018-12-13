package InheritanceDemo;

public abstract class Vehicle {
	
	protected int wheelNumber;
	protected int topSpeed;
	private int currentSpeed;
	protected int passengerNumber;
	
	public void accelerate(){
		if(currentSpeed < topSpeed)
		currentSpeed ++;
	}
	public void decelerate(){
		if(currentSpeed > 0)
		currentSpeed --;
	}
	public void stop(){
		currentSpeed = 0;
	}
	
	public int getSpeed(){
		return this.currentSpeed;
	}
	
	public abstract void park();
	
	public abstract int sellingPrice();
	
}
