📘 Alumni Management System (CLI-Based Java Project)

This is a Java-based Alumni Management System that runs entirely in the terminal (Command Line Interface). It uses file handling for data persistence—no databases or GUI are used. The system supports three types of users: Admin, Alumni, and Student.

/AlumniManagementSystem
├── Main.java                   # Entry point of the application
├── AuthManager.java            # Handles login and user authentication
├── EventManager.java           # Event creation, viewing, and registration
├── JobManager.java             # Job posting and applications
├── UserManager.java            # Admin controls for user management
├── users.txt                   # Stores user credentials and roles
├── events.txt                  # Stores event data
├── event_registrations.txt     # Stores registrations to events
├── jobs.txt                    # Stores job postings
├── job_applications.txt        # Stores job applications



🧠 Features
🔐 Authentication

    Users can log in as Admin, Alumni, or Student

    Admins can create accounts for Students and Alumni

    Credentials are stored in users.txt

📅 Event Management

    Admins can create and publish events

    Students and Alumni can view and register for events

    Event data stored in events.txt

    Registrations stored in event_registrations.txt

💼 Job Posting

    Alumni can post job offers (saved in jobs.txt)

    Students can view jobs and apply (applications in job_applications.txt)

🛠 Admin Functionalities

    View total number of Students, Alumni, Events, and Job Posts

    List all users and events

💻 Technologies Used

    Java

    File I/O (FileReader, FileWriter, BufferedReader, etc.)

    Modular Programming (Separate classes for each module)

    Switch-case and Menu-driven CLI

🚀 How to Run

    Open a terminal and navigate to the AlumniManagementSystem folder

    Compile the project:

javac *.java

Run the application:

    java Main

🎯 Goal

To provide a simple, modular, and CLI-based management system for alumni networks using core Java concepts and file-based persistence.
