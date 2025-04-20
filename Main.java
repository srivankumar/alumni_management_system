import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String currentUser = null;
    static String currentRole = null;

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nWelcome to Alumni Management System");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    String[] userData = AuthManager.login();
                    if (userData != null) {
                        currentUser = userData[0];
                        currentRole = userData[1];
                        showDashboard();
                    }
                    break;
                case 2:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    static void showDashboard() {
        while (true) {
            System.out.println("\nLogged in as: " + currentUser + " (" + currentRole + ")");
            switch (currentRole) {
                case "admin":
                    System.out.println("1. Create User\n2. Create Event\n3. View Stats\n4. Logout");
                    break;
                case "alumni":
                    System.out.println("1. Post Job\n2. View Events\n3. Register for Event\n4. Logout");
                    break;
                case "student":
                    System.out.println("1. View Jobs\n2. Apply for Job\n3. Register for Event\n4. Logout");
                    break;
            }

            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (currentRole.equals("admin")) {
                switch (choice) {
                    case 1 -> UserManager.createUser();
                    case 2 -> EventManager.createEvent(currentUser);
                    case 3 -> UserManager.viewStats();
                    case 4 -> { return; }
                    default -> System.out.println("Invalid choice.");
                }
            } else if (currentRole.equals("alumni")) {
                switch (choice) {
                    case 1 -> JobManager.postJob(currentUser);
                    case 2 -> EventManager.viewEvents();
                    case 3 -> EventManager.registerForEvent(currentUser);
                    case 4 -> { return; }
                    default -> System.out.println("Invalid choice.");
                }
            } else if (currentRole.equals("student")) {
                switch (choice) {
                    case 1 -> JobManager.viewJobs();
                    case 2 -> JobManager.applyForJob(currentUser);
                    case 3 -> EventManager.registerForEvent(currentUser);
                    case 4 -> { return; }
                    default -> System.out.println("Invalid choice.");
                }
            }
        }
    }
}
