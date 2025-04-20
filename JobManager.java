import java.io.*;
import java.util.*;

public class JobManager {
    public static void postJob(String alumniName) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Job Title: ");
        String title = sc.nextLine();
        System.out.print("Description: ");
        String desc = sc.nextLine();
        String jobId = UUID.randomUUID().toString();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("jobs.txt", true))) {
            bw.write(jobId + "," + title + "," + desc + "," + alumniName);
            bw.newLine();
            System.out.println("Job posted!");
        } catch (IOException e) {
            System.out.println("Error writing to jobs.txt");
        }
    }

    public static void viewJobs() {
        try (BufferedReader br = new BufferedReader(new FileReader("jobs.txt"))) {
            String line;
            System.out.println("\nAvailable Jobs:");
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 3)
                    System.out.println("ID: " + parts[0] + " | " + parts[1] + " - " + parts[2]);
            }
        } catch (IOException e) {
            System.out.println("Error reading jobs.txt");
        }
    }

    public static void applyForJob(String username) {
        viewJobs();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Job ID to apply: ");
        String jobId = sc.nextLine();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("job_applications.txt", true))) {
            bw.write(username + "," + jobId);
            bw.newLine();
            System.out.println("Applied successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to job_applications.txt");
        }
    }
}
