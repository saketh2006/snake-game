import java.util.ArrayList;
import java.util.List;

public class Player extends Playerentity{
	private Dice dice;
    private List<Achievement> achievements;

    public Player(String name, Dice dice) {
        super(name);
        this.dice = dice;
        this.achievements = new ArrayList<>();
        achievements.add(new Achievement("First Step", "Reached position 10"));
        achievements.add(new Achievement("Halfway There", "Reached position 50"));
        achievements.add(new Achievement("Climber", "Used a ladder"));
        achievements.add(new Achievement("Survivor", "Bitten by a snake"));
        achievements.add(new Achievement("Champion", "Won the game"));
    }

   
    public void move(int diceValue, Board board) {
        int newPosition = position + diceValue;
        if (newPosition <= board.getBoardSize()) {
            int oldPosition = position;
            position = board.getNewPosition(newPosition);
            board.checkPowerUps(position, this);

            checkAchievements(oldPosition); 
        }
    }

    public boolean hasWon() {
        if (position == 100) {
            unlockAchievement("Champion");
            return true;
        }
        return false;
    }

    private void checkAchievements(int oldPosition) {
        if (oldPosition < 10 && position >= 10) unlockAchievement("First Step");
        if (oldPosition < 50 && position >= 50) unlockAchievement("Halfway There");
        if (oldPosition < position && position - oldPosition > 10) unlockAchievement("Climber");
        if (oldPosition > position) unlockAchievement("Survivor");
    }

    private void unlockAchievement(String title) {
        for (Achievement a : achievements) {
            if (a.getTitle().equals(title) && !a.isUnlocked()) {
                a.unlock();
                break;
            }
        }
    }
}
