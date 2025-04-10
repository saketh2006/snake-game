
public class Achievement {
	    private final String title;
	    private final String description;
	    private boolean unlocked;

	    public Achievement(String title, String description) {
	        this.title = title;
	        this.description = description;
	        this.unlocked = false;
	    }

	    public void unlock() {
	        this.unlocked = true;
	        System.out.println("🏅 Achievement Unlocked: " + title + " - " + description);
	    }

	    public boolean isUnlocked() {
	        return unlocked;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public String getDescription() {
	        return description;
	    }
	}


