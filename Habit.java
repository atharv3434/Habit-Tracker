import java.time.LocalDate;

public class Habit {
    private String name;
    private int streak; // Number of consecutive days completed
    private LocalDate lastCompletedDate;

    public Habit(String name) {
        this.name = name;
        this.streak = 0;
        this.lastCompletedDate = null;
    }

    public String getName() { return name; }
    public int getStreak() { return streak; }
    public LocalDate getLastCompletedDate() { return lastCompletedDate; }

    public void completeToday() {
        LocalDate today = LocalDate.now();
        if (lastCompletedDate == null || !lastCompletedDate.equals(today)) {
            if (lastCompletedDate != null && lastCompletedDate.plusDays(1).equals(today)) {
                streak++;
            } else {
                streak = 1;
            }
            lastCompletedDate = today;
        }
    }

    @Override
    public String toString() {
        return "📌 Habit: " + name + " | 🔥 Streak: " + streak + " days";
    }
}
