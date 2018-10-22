package Breakout;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
		
		this.pane.addKeyListener(new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
				
				if(e.getKeyCode() == KeyEvent.VK_SPACE){
					isPaused = !isPaused;
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {}
			@Override
			public void keyTyped(KeyEvent e) {}
			
		});
		
		this.tick();
		
	}
	
	private void tick(){
		this.tiles[0].setX(mouseX);
		System.out.println(this.tiles[0].getX());
		System.out.println(this.mouseX);
		this.render(this.pane.getGraphics());
		
		if(!this.isPaused)
			this.tick();
	}
	
	private void render(Graphics g){
		g.setColor(Color.WHITE);
		g.fillRect(0, this.PANEL_HEIGHT - (this.PANEL_HEIGHT / 5), this.PANEL_WIDTH, this.PANEL_HEIGHT);
		for(int i = 0; i < tiles.length; i ++){
			g.setColor(tiles[i].getColor());
			g.fillRect(tiles[i].getX(), tiles[i].getY(), (int) tiles[i].getSize().getWidth(), (int) tiles[i].getSize().getHeight());
			g.setColor(Color.BLACK);
			g.drawRect(tiles[i].getX(), tiles[i].getY(), (int) tiles[i].getSize().getWidth(), (int) tiles[i].getSize().getHeight());
		}
	}
	
	public static void main(String[] args){
		Breakout bo = new Breakout();
	}
	
}
