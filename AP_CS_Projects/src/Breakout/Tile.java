package Breakout;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Color;

public class Tile {
	
	private Color[] colors = {Color.WHITE, Color.CYAN, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED, Color.BLACK};
	
	private Point location;
	private Dimension size;
	private int level;
	
	public Tile(double x, double y, int width, int height, int level){
		this.location = new Point((int) x, (int) y);
		this.size = new Dimension(width, height);
		this.level = level;
	}
	
	public Color getColor(){
		return colors[level];
	}
	
	public int getX(){
		return (int) this.location.getX();
	}
	
	public int getY(){
		return (int) this.location.getY();
	}
	
	public void setX(int x){
		this.location.x = x;
	}
	
	public void setY(int y){
		this.location.y = y;
	}
	
	public Dimension getSize(){
		return size;
	}
	
	public String toString(){
		return this.getX() + ", " + this.getY() + "; " + this.getColor().toString();
	}
	
}
