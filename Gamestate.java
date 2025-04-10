
public class Gamestate {
	 private long startTime;
	    private long endTime;

	    public void startGame() {
	        startTime = System.currentTimeMillis();
	    }

	    public void endGame() {
	        endTime = System.currentTimeMillis();
	    }

	    public void printStats() {
	        System.out.println("Game Duration: " + (endTime - startTime) / 1000 + " seconds");
	    }

}
