import java.io.*;
import java.util.*;

public class AuthManager {
    public static String[] login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Username: ");
        String user = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3 && parts[0].equals(user) && parts[1].equals(pass)) {
                    return new String[]{user, parts[2]}; // username, role
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading users.txt");
        }

        System.out.println("Invalid credentials.");
        return null;
    }
}
