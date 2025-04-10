
public class Timemanager {
	 private final long startTime;

	    public Timemanager() {
	        startTime = System.currentTimeMillis();
	    }

	    public void endGame() {
	        long endTime = System.currentTimeMillis();
	        System.out.println("⏱ Total Play Time: " + ((endTime - startTime) / 1000) + " seconds");
	    }

}
