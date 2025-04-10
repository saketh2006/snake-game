
public abstract class Playerentity {
	protected String name;
    protected int position;

    public  Playerentity(String name) {
        this.name = name;
        this.position = 1;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public abstract void move(int diceValue, Board board);
}


