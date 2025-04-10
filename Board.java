import java.util.ArrayList;     
import java.util.List;

class Board {
    private static final int BOARD_SIZE = 100;
    private final List<Gameelemenmt> elements;

    public Board() {
        elements = new ArrayList<>();
        initializeBoard();
    }

    private void initializeBoard() {
        // Adding Snakes
        elements.add(new Snake(98, 78));
        elements.add(new Snake(95, 75));
        elements.add(new Snake(92, 88));
        elements.add(new Snake(87, 24));
        elements.add(new Snake(62, 18));
        elements.add(new Snake(54, 34));

        // Adding Ladders
        elements.add(new Ladder(2, 23));
        elements.add(new Ladder(8, 31));
        elements.add(new Ladder(28, 84));
        elements.add(new Ladder(51, 67));
        elements.add(new Ladder(72, 91));
        elements.add(new Ladder(80, 99));

        // Adding PowerUps
        elements.add(new Powerup(11, "Extra Turn"));
        elements.add(new Powerup(26, "Shield"));
    }

    public int getNewPosition(int position) {
        for (Gameelemenmt element : elements) {
            if (element instanceof Snake && ((Snake) element).getStart() == position) {
                element.interact(null);
                return ((Snake) element).getEnd();
            }
            if (element instanceof Ladder && ((Ladder) element).getStart() == position) {
                element.interact(null);
                return ((Ladder) element).getEnd();
            }
        }
        return position; 
    }

    public void checkPowerUps(int position, Player player) {
        for (Gameelemenmt element : elements) {
            if (element instanceof Powerup && ((Powerup) element).getPosition() == position) {
                element.interact(player);
            }
        }
    }

    public int getBoardSize() {
        return BOARD_SIZE;    
    }
}