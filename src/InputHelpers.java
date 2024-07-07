import java.util.Scanner;

class InputHelpers {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getString(String prompt){
        String string;
        while (true) {
            System.out.print(prompt);
            string = scanner.nextLine();
            if (!string.trim().isEmpty()) { // Check if the input is not empty
                return string;
            } else {
                System.out.println("Invalid input. Please Enter something.");
            }
        }
    }
    //Method accepting string arguments to grab Integers
    public static int getInt(String prompt) {
        int num;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character
                return num;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();  // Consume the invalid input
            }
        }
    }

    //Overload method accepting zero arguments to grab Integers
    public static int getInt() {
        int num;
        while (true) {
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
                scanner.nextLine();  // Consume the newline character
                return num;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();  // Consume the invalid input
            }
        }
    }
}