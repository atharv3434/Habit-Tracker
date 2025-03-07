import java.util.*;

public class HabitManager {
    private List<Habit> habits;
    private Scanner sc;

    public HabitManager() {
        this.habits = DataStorage.loadHabits();
        this.sc = new Scanner(System.in);
    }

    public void addHabit() {
        System.out.print("Enter habit name: ");
        String name = sc.nextLine();

        habits.add(new Habit(name));
        DataStorage.saveHabits(habits);
        System.out.println("✅ Habit Added Successfully!");
    }

    public void viewHabits() {
        if (habits.isEmpty()) {
            System.out.println("📄 No habits found.");
            return;
        }

        System.out.println("\n📌 Your Habits:");
        for (int i = 0; i < habits.size(); i++) {
            System.out.println((i + 1) + ". " + habits.get(i));
        }
    }

    public void completeHabit() {
        viewHabits();
        System.out.print("Enter habit number to mark as completed: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < habits.size()) {
            habits.get(index).completeToday();
            DataStorage.saveHabits(habits);
            System.out.println("🎉 Habit Marked as Completed!");
        } else {
            System.out.println("❌ Invalid habit number.");
        }
    }

    public void viewHabitStreaks() {
        if (habits.isEmpty()) {
            System.out.println("📄 No habits to track streaks.");
            return;
        }

        System.out.println("\n🔥 Habit Streaks:");
        for (Habit habit : habits) {
            System.out.println(habit);
        }
    }

    public void deleteHabit() {
        viewHabits();
        System.out.print("Enter habit number to delete: ");
        int index = sc.nextInt() - 1;
        sc.nextLine();

        if (index >= 0 && index < habits.size()) {
            habits.remove(index);
            DataStorage.saveHabits(habits);
            System.out.println("✅ Habit Deleted Successfully!");
        } else {
            System.out.println("❌ Invalid habit number.");
        }
    }
}
