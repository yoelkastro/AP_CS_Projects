package Breakout;

import java.awt.Point;

public class Ball {

	private int direction;
	private int velocity;
	private Point location;
	private int radius;
	
	public void tick(){
		this.location.translate((int) (velocity * Math.cos(this.toRadian(direction))), (int) (velocity * Math.sin(this.toRadian(direction))));
	}
	
	private double toRadian(int degrees){
		return (((double) degrees) / 180) * Math.PI;
	}
}
