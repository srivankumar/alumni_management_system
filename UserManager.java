import java.io.*;
import java.util.*;

public class UserManager {
    public static void createUser() {
        Scanner sc = new Scanner(System.in);
        System.out.print("New Username: ");
        String user = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();
        System.out.print("Role (student/alumni): ");
        String role = sc.nextLine().toLowerCase();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("users.txt", true))) {
            bw.write(user + "," + pass + "," + role);
            bw.newLine();
            System.out.println("User created successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to users.txt");
        }
    }

    public static void viewStats() {
        int studentCount = 0, alumniCount = 0, eventCount = 0, jobCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.endsWith("student")) studentCount++;
                if (line.endsWith("alumni")) alumniCount++;
            }
        } catch (IOException e) {}

        try (BufferedReader br = new BufferedReader(new FileReader("events.txt"))) {
            while (br.readLine() != null) eventCount++;
        } catch (IOException e) {}

        try (BufferedReader br = new BufferedReader(new FileReader("jobs.txt"))) {
            while (br.readLine() != null) jobCount++;
        } catch (IOException e) {}

        System.out.println("Total Students: " + studentCount);
        System.out.println("Total Alumni: " + alumniCount);
        System.out.println("Total Events: " + eventCount);
        System.out.println("Total Jobs: " + jobCount);
    }
}
