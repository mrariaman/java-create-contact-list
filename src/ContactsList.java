import java.util.ArrayList;
import java.util.Scanner;

public class ContactsList {
    public static void main(String[] args) {
        boolean isActive = true;
        ArrayList<String> contactNames = new ArrayList<>();
        ArrayList<String> contactNumbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String userChoice;

        System.out.println("---- Menu ----");

        do {
            System.out.println("1) Add new contact");
            System.out.println("2) Show the contacts list");
            System.out.println("3) Exit the program");
            System.out.println("Enter a number:");
            userChoice = scanner.nextLine();

            switch (userChoice){
                case "1" -> {
                    System.out.println("\nEnter the new contact's name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter the new contact's phone number:");
                    String number = scanner.nextLine();

                    contactNames.add(name);
                    contactNumbers.add(number);

                    System.out.println("\nNew contact added to your list successfully.\n");
                }
                case "2" -> {
                    if (contactNames.isEmpty()){
                        System.out.println("\nYour contact names list is still empty !\n");
                    } else if (contactNumbers.isEmpty()) {
                        System.out.println("\nYour contact numbers list is still empty !\n");
                    } else {
                        System.out.println("\nCurrent contacts list:");
                        for (int i = 0; i < contactNames.size(); i++) {
                            System.out.println(i + 1 +")\n" + "Name: " +
                                    contactNames.get(i) + "\nPhone number: " + contactNumbers.get(i));
                        }
                        System.out.println();
                    }
                }
                case "3" -> {
                    System.out.println("\n Exiting the program ...");
                    isActive = false;
                }
                default -> {
                    System.out.println("Invalid data passed, try again !!!");
                    isActive = false;
                }
            }
        } while (isActive);

        scanner.close();
    }
}
