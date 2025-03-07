import java.util.Scanner;

public class TrackerApp {
    private static HabitManager habitManager = new HabitManager();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("📅 Welcome to Habit Tracker 📅");

        while (true) {
            System.out.println("\n1. Add Habit");
            System.out.println("2. View Habits");
            System.out.println("3. Mark Habit as Completed");
            System.out.println("4. View Habit Streaks");
            System.out.println("5. Delete Habit");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    habitManager.addHabit();
                    break;
                case 2:
                    habitManager.viewHabits();
                    break;
                case 3:
                    habitManager.completeHabit();
                    break;
                case 4:
                    habitManager.viewHabitStreaks();
                    break;
                case 5:
                    habitManager.deleteHabit();
                    break;
                case 6:
                    System.out.println("Exiting... Keep up your good habits! 🚀");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }
}
