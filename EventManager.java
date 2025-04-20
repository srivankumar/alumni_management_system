import java.io.*;
import java.util.*;

public class EventManager {
    public static void createEvent(String createdBy) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Event Name: ");
        String name = sc.nextLine();
        System.out.print("Event Date (YYYY-MM-DD): ");
        String date = sc.nextLine();
        String id = UUID.randomUUID().toString();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("events.txt", true))) {
            bw.write(id + "," + name + "," + date + "," + createdBy);
            bw.newLine();
            System.out.println("Event created!");
        } catch (IOException e) {
            System.out.println("Error writing to events.txt");
        }
    }

    public static void viewEvents() {
        try (BufferedReader br = new BufferedReader(new FileReader("events.txt"))) {
            String line;
            System.out.println("\nUpcoming Events:");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3)
                    System.out.println("ID: " + parts[0] + " | " + parts[1] + " on " + parts[2]);
            }
        } catch (IOException e) {
            System.out.println("Error reading events.txt");
        }
    }

    public static void registerForEvent(String username) {
        viewEvents();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Event ID to register: ");
        String eventId = sc.nextLine();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("event_registrations.txt", true))) {
            bw.write(username + "," + eventId);
            bw.newLine();
            System.out.println("Registered successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to event_registrations.txt");
        }
    }
}
