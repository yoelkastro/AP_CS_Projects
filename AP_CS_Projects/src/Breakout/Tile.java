package Breakout;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Color;

public class Tile extends Rectangle{
	
	private Color[] colors = {Color.WHITE, Color.CYAN, Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED, Color.BLACK};
	
	private int level;
	
	public Tile(double x, double y, int width, int height, int level){
		super((int) x, (int) y, width, height);
		this.level = level;
	}
	
	public Color getColor(){
		return colors[level];
	}
	public String toString(){
		return this.getX() + ", " + this.getY() + "; " + this.getColor().toString();
	}
	
	public void render(Graphics2D g){
		g.setColor(this.getColor());
		g.fill(this);
	}
	
}
