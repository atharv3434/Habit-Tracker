import java.io.*;
import java.util.*;

public class DataStorage {
    private static final String FILE_PATH = "habits.txt";

    public static void saveHabits(List<Habit> habits) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(habits);
        } catch (IOException e) {
            System.out.println("❌ Error saving habits.");
        }
    }

    public static List<Habit> loadHabits() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (List<Habit>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
}
