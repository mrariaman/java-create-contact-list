import java.util.ArrayList;
import java.util.Scanner;

public class ContactsList {
    private static final ArrayList<Contact> contacts = new ArrayList<>();
    private static boolean isActive = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userChoice;
        System.out.println("---- Menu ----");

        do {
            printMenu();
            userChoice = scanner.nextLine();

            switch (userChoice) {
                case "1" -> addContact(scanner);
                case "2" -> printAllContacts();
                case "3" -> exitProgram();
                default -> handleError();
            }
        } while (isActive);
        scanner.close();
    }

    private static void handleError() {
        System.out.println("Invalid data passed, try again !!!");
        isActive = false;
    }

    private static void exitProgram() {
        System.out.println("\n Exiting the program ...");
        isActive = false;
    }

    private static void printMenu() {
        System.out.println("1) Add new contact");
        System.out.println("2) Show the contacts list");
        System.out.println("3) Exit the program");
        System.out.println("Enter a number:");
    }

    private static void printAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("\nYour contact names list is still empty !\n");
        } else {
            System.out.println("\nCurrent contacts list:");
            for (Contact contact : contacts) {
                System.out.println("Name: " +
                        contact.getName() + "\nPhone number: " + contact.getNumber());
            }
            System.out.println();
        }
    }

    private static void addContact(Scanner scanner) {
        Contact newContact = new Contact();
        System.out.println("\nEnter the new contact's name:");
        newContact.setName(scanner.nextLine());
        System.out.println("Enter the new contact's phone number:");
        newContact.setNumber(scanner.nextLine());
        contacts.add(newContact);
        System.out.println("\nNew contact added to your list successfully.\n");
    }
}
