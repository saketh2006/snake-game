import java.util.ArrayList;
import java.util.List;

public class Leaderboard {
	 private final List<String> winners = new ArrayList<>();

	    public void addWinner(String playerName) {
	        if (!winners.contains(playerName)) {
	            winners.add(playerName);
	        }
	    }

	    public void displayLeaderboard() {
	        System.out.println("\n🏆 Final Leaderboard:");
	        for (int i = 0; i < winners.size(); i++) {
	            System.out.println((i + 1) + ". " + winners.get(i));
	        }
	    }

}
