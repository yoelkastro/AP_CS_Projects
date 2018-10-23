package Quiz1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Question4 {

	static final int SQSIZE = 75;
	static final int NCOLS = 7;
	static final int NROWS = 3;
	static final int PANEL_WIDTH = NCOLS * SQSIZE;
	static final int PANEL_HEIGHT = NROWS * SQSIZE;
	
	static DrawingPanel dp = new DrawingPanel();
	static int[] frogPos = {3, 2};
	
	public static void main(String[] args) throws IOException{
		
		dp.setSize(PANEL_WIDTH, PANEL_HEIGHT);
		Graphics g = dp.getGraphics();
		BufferedImage frog = ImageIO.read(new File("src/frog.png"));
		
		g.drawImage(frog, frogPos[0] * SQSIZE, frogPos[1] * SQSIZE, null);
		
		dp.onClick((x, y) -> {
			
			y -= SQSIZE / 2;
			x -= SQSIZE / 2;
			
			System.out.println(Math.signum((frogPos[1] * SQSIZE) - y));
			
			if(!(Math.abs((frogPos[0] * SQSIZE) - x) < SQSIZE / 2 && Math.abs((frogPos[1] * SQSIZE) - y) < SQSIZE / 2)){
				int dir = (int) Math.signum((Math.abs((frogPos[1] * SQSIZE) - y)) / (Math.abs((frogPos[0] * SQSIZE) - x)));
				
				frogPos[dir] -= (dir == 1)? Math.signum((frogPos[1] * SQSIZE) - y):Math.signum((frogPos[0] * SQSIZE) - x);
				
				switch(frogPos[0]){
				case -1: frogPos[0] = 0; break;
				case NCOLS: frogPos[0] = NCOLS - 1; break;
				}
				switch(frogPos[1]){
				case -1: frogPos[1] = 0; break;
				case NROWS: frogPos[1] = NROWS - 1; break;
				}
			}
			
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
			
			g.drawImage(frog, frogPos[0] * SQSIZE, frogPos[1] * SQSIZE, null);
			
		});
		
	}
	
}
