package Breakout;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

public class Breakout {

	final int PANEL_WIDTH = 1024;
	final int PANEL_HEIGHT = 768;
	final int TILE_ROWS = 10;
	final int TILE_COLUMNS = 10;
	final int TILE_WIDTH = PANEL_WIDTH / TILE_COLUMNS;
	final int TILE_HEIGHT = (int) (PANEL_HEIGHT / 2.6) / TILE_ROWS;
	final int TILE_MARGIN_RATIO = 200;
	final Point TILE_FIRST_LOCATION = new Point(0, (int) (PANEL_HEIGHT / 2.3) - (PANEL_HEIGHT / TILE_MARGIN_RATIO));
	final int PADDLE_Y = (int) (PANEL_HEIGHT / 1.2);
	
	private DrawingPanel pane;
	private int mouseX;
	private boolean isPaused;
	
	private Ball ball;
	private Paddle paddle;
	private Tile[] tiles;
	
	Rectangle r = new Rectangle(5, 5, 50, 50);
	
	public Breakout(){
		this.pane = new DrawingPanel(this.PANEL_WIDTH, this.PANEL_HEIGHT);
		
		this.tiles = new Tile[(this.TILE_COLUMNS * this.TILE_ROWS) + 1];
		this.tiles[0] = new Paddle(this.PADDLE_Y, (int) (this.TILE_WIDTH * 1.5), (int) (this.TILE_HEIGHT / 1.5));
		for(int y = 0; y < this.TILE_ROWS; y ++){
			for(int x = 0; x < this.TILE_COLUMNS; x ++){
				this.tiles[((y * this.TILE_ROWS) + x) + 1] = new Tile(this.TILE_FIRST_LOCATION.getX() + (this.TILE_WIDTH * x) + ((this.PANEL_WIDTH / this.TILE_MARGIN_RATIO)), 
										this.TILE_FIRST_LOCATION.getY() - (this.TILE_HEIGHT * y) - ((this.PANEL_HEIGHT / this.TILE_MARGIN_RATIO)), 
										this.TILE_WIDTH - (this.PANEL_WIDTH / this.TILE_MARGIN_RATIO), this.TILE_HEIGHT - (this.PANEL_HEIGHT / this.TILE_MARGIN_RATIO), (y / 2) + 1);
			}
		}

		pane.onMouseMove((x, y) -> this.mouseX = x);
		pane.onClick((x, y) -> this.isPaused = !this.isPaused); 
		pane.onEnter((x, y) -> this.isPaused = false);
		pane.onExit((x, y) -> this.isPaused = true);
		pane.onKeyDown((x) -> {if(x == ' ') this.isPaused = !this.isPaused;});
		
		this.loop();
		
	}
	
	private void loop(){
		while(!isPaused){
			
			/*System.out.println(this.tiles[0].getX());
			System.out.println(this.mouseX);*/
			this.render(this.pane.getGraphics());
		}
		
	}
	
	private void render(Graphics2D g){
		pane.clear();
		g.setColor(Color.BLACK);
		g.fill(r);
		//g.drawRect(tiles[0].getX(), tiles[0].getY(), (int) tiles[0].getSize().getWidth(), (int) tiles[0].getSize().getHeight());
		for(int i = 0; i < tiles.length; i ++){
			tiles[i].render(g);
		}
	}
	
	public static void main(String[] args){
		Breakout bo = new Breakout();
	}
	
}
