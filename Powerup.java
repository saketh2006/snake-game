
public class Powerup implements Gameelemenmt{
	 private final int position;
	    private final String type;

	    public Powerup(int position, String type) {
	        this.position = position;
	        this.type = type;
	    }

	    public int getPosition() {
	        return position;
	    }

	    
	    public void interact(Player player) {
	        System.out.println("Power Up! You got a " + type + " at position " + position);
	    }

}
