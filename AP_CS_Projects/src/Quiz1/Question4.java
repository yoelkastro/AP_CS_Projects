package Quiz1;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Question4 {

	static final int SQSIZE = 75;	//The size of each square in the grid
	static final int NCOLS = 7;		//The number of columns in the grid
	static final int NROWS = 3;		//The number of rows in the grid
	static final int PANEL_WIDTH = NCOLS * SQSIZE;		//Width of the DrawingPanel
	static final int PANEL_HEIGHT = NROWS * SQSIZE;		//Height of the DrawingPanel
	
	static DrawingPanel dp = new DrawingPanel();	//The DrawingPanel used for graphical display
	static int[] frogPos = {NCOLS / 2, NROWS - 1};		//The current position of the frog on the grid relative to the top left, initialized as the bottom middle of the screen
	
	public static void main(String[] args) throws IOException{
		
		dp.setSize(PANEL_WIDTH, PANEL_HEIGHT);	//Set the size of the DrawingPanel
		Graphics g = dp.getGraphics();			//Get the graphics object of the object panel
		BufferedImage frog = ImageIO.read(new File("src/frog.png"));	//Get the frog as a BufferedImage
		
		g.drawImage(frog, frogPos[0] * SQSIZE, frogPos[1] * SQSIZE, null);	//Draw the frog in its starting position
		
		dp.onClick((x, y) -> {
			
			y -= SQSIZE / 2;
			x -= SQSIZE / 2;
			
			if(!(Math.abs((frogPos[0] * SQSIZE) - x) < SQSIZE / 2 && Math.abs((frogPos[1] * SQSIZE) - y) < SQSIZE / 2)){ //Check if the mouse is not on the same square as the frog
				int dir = (int) Math.signum((Math.abs((frogPos[1] * SQSIZE) - y)) / (Math.abs((frogPos[0] * SQSIZE) - x))); //Calculate if the frog will move in the x or y axis (0 for x, 1 for y) by checking if the difference in x is larger than the difference in y
				
				frogPos[dir] -= (dir == 1)? Math.signum((frogPos[1] * SQSIZE) - y):Math.signum((frogPos[0] * SQSIZE) - x);	//Change the position of the frog by removing 1 (for moving in the negative direction) or -1 (for moving in the positive direction) calculated from the difference of the mouse's position and the frog's position from the movement axis 
				
				switch(frogPos[0]){	//Don't let the frog move if it is near the edges
				case -1: frogPos[0] = 0; break;
				case NCOLS: frogPos[0] = NCOLS - 1; break;
				}
				switch(frogPos[1]){
				case -1: frogPos[1] = 0; break;
				case NROWS: frogPos[1] = NROWS - 1; break;
				}
			}
			
			dp.clear(); //Clear the DrawingPanel to draw the new position of the frog
			g.drawImage(frog, frogPos[0] * SQSIZE, frogPos[1] * SQSIZE, null);	//Draw the frog in its new position
			
		});
		
	}
	
}
