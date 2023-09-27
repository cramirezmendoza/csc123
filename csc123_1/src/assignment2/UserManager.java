package assignment2;
//Camila Ramirez Mendoza cramirezmendoza1@toromail.csudh.edu
import java.util.ArrayList;
import java.util.Scanner;
// user object 
class User {
    private String fname;
    private String lname;
    private String email;
// constructor
    public User(String newFName, String newLName, String newEmail) {
        fname = newFName;
        lname = newLName;
        email = newEmail;
    }
// getters
    public String getFullName() {
        return lname + ", " + fname;
    }

    public String getEmail() {
        return email;
    }
}

public class UserManager {
	//store into array 
    private ArrayList<User> users = new ArrayList<>();
    private Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
    	// contain users
        UserManager userManager = new UserManager();
        int option;
        //user dependent loop 
        do {
            userManager.screenMenu();
            option = userManager.input.nextInt();
            userManager.input.nextLine();

            switch (option) {
                case 1:
                    userManager.register();
                    break;
                case 2:
                    userManager.list();
                    break;
                case 3:
                    System.out.println("Thank you for using User Manager, Goodbye");
                    break;
                default:
                    System.out.println("Please choose options 1 - 3");

            }
        } while (option != 3); //while not 3 execute
    }

    private void screenMenu() {
        System.out.println("1 – Register User");
        System.out.println("2 – List Users");
        System.out.println("3 – Exit");
        System.out.print("Please enter your choice: ");
    }

    private void register() {
    	//get new users 
        System.out.print("Enter your first name: ");
        String fName = input.nextLine();
        System.out.print("Enter last name: ");
        String lName = input.nextLine();
        System.out.print("Enter email address: ");
        String email = input.nextLine();
        // new object for user
        User user = new User(fName, lName, email);
        users.add(user);

        System.out.println("Thank you, user " + user.getFullName() + " (" + user.getEmail() + ") has been registered");
    }

    private void list() {
    	//list users
        System.out.println("Registered Users: ");
        //user count
        int count = 1;
        for (User user : users) {
            System.out.println(count + " - " + user.getFullName() + " (" + user.getEmail() + ")");
            count++;
        }
        System.out.println("Total users: " + users.size());
    }
}
