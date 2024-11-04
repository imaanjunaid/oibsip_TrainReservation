import java.util.Scanner;

public class TrainReservationSystem{
    private static boolean[] availableSeats = new boolean[30];
    static Scanner scanner = new Scanner(System.in);
    static User activeUser;
    public static void main(String[] args) {
        System.out.println("Welcome! Please register to continue:");
        registerNewUser();
        System.out.println("Proceed with login:");
        
        if (authenticateUser()) {
            System.out.println("Login successful!");
            displayMenu();
        } else {
            System.out.println("Invalid credentials, access denied.");
        }
    }

    static void registerNewUser() {
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();
        System.out.print("Create a password: ");
        String userPassword = scanner.nextLine();
        activeUser = new User(userName, userPassword);    
    }

    static boolean authenticateUser() {
        System.out.print("Enter your username: ");
        String userId = scanner.nextLine();
        System.out.print("Enter your password: ");
        String userPassword = scanner.nextLine();
        return userId.equals(activeUser.getName()) && userPassword.equals(activeUser.getPassword());    
    }

    static void displayMenu() {
        int choice;
        do {
            System.out.println("----- Train Reservation System -----");
            System.out.println("Choose an option:");
            System.out.println("1. View Available Seats");
            System.out.println("2. Reserve a Seat");
            System.out.println("3. Cancel a Reservation");
            System.out.println("4. Exit");
            System.out.print("Your selection: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showAvailableSeats();
                    break;
                case 2:
                    reserveSeat();
                    break;
                case 3:
                    cancelReservation();
                    break;
                case 4:
                    System.out.println("Thank you for using the Train Reservation System.");
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        } while (choice != 4);
    }

    private static void reserveSeat() {
        System.out.print("Enter a seat number (1-30) to reserve: ");
        int seatNumber = scanner.nextInt();

        if (seatNumber < 1 || seatNumber > 30) {
            System.out.println("Invalid seat number! Please enter a number between 1 and 30.");
        } else if (availableSeats[seatNumber - 1]) {
            System.out.println("Sorry, that seat is already reserved.");
        } else {
            availableSeats[seatNumber - 1] = true;
            System.out.println("Seat " + seatNumber + " has been successfully reserved.");
        }
    }

    private static void showAvailableSeats() {
        System.out.println("Available seats:");
        for (int i = 0; i < availableSeats.length; i++) {
            if (availableSeats[i]) {
                System.out.print("X ");
            } else {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println();
    }

    private static void cancelReservation() {
        System.out.print("Enter seat number (1-30) to cancel reservation: ");
        int seatNumber = scanner.nextInt();

        if (seatNumber < 1 || seatNumber > 30) {
            System.out.println("Invalid seat number! Please enter a number between 1 and 30.");
        } else if (!availableSeats[seatNumber - 1]) {
            System.out.println("That seat is not currently reserved.");
        } else {
            availableSeats[seatNumber - 1] = false;
            System.out.println("Reservation for seat " + seatNumber + " has been canceled.");
        }
    }
}

class User {
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}