
public class Snake implements Gameelemenmt{
	private final int start;
    private final int end;
    
    public Snake(int start, int end) {
        this.start = start;
        this.end = end;
    }
    
    public int getStart() {
        return start;
    }
    
    public int getEnd() {
        return end;
    }
    
    
    public void interact(Player player) {
        System.out.println("Oh no! A snake bites! Move down from " + start + " to " + end);
    }

}