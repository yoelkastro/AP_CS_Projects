
public class Skater {

	private static int totalSkater = 0;
	
	public Skater(){
		totalSkater ++;
	}
	
	public static int getTotalSkater(){
		return totalSkater;
	}
	
}
