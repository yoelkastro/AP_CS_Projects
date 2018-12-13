package InheritanceDemo;

public class MotorCycle extends Vehicle{

	public MotorCycle(){
		this.topSpeed = 70;
		this.wheelNumber = 2;
		this.passengerNumber = 2;
	}
	
	@Override
	public void park() {
		while(this.getSpeed() > 0){
			this.decelerate();
		}
	}

	@Override
	public int sellingPrice() {
		return 3500;
	}
	
	public void doWheelie(){
		
	}
	
}
