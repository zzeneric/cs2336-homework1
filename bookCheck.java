// Raghav Pillai, 6/10/21

import java.util.Scanner; // Import scanner for input

public class bookCheck{ // Bookcheck object
    Scanner scanner = new Scanner(System.in); // Initialize scanner
    int d1, d2, d3, d4, d5, d6, d7, d8, d9; // Input variables
    String ISBN9; // First 9 numbers string

    public void determineNumber(){ // Convert the ISBN9 numbers to ISBN10
        int d10 = (d1 * 1 + d2 * 2 + d3 * 3 + d4 * 4 + d5 * 5 + d6 * 6 + d7 * 7 + d8 * 8 + d9 * 9) % 11; // Check last digit
        if(d10 == 10){ // If d10 == 10 then add an X
            System.out.print("The ISBN-10 number is " + ISBN9 + 'X');
        }else{ // Add number if <10
            System.out.print("The ISBN-10 number is " + ISBN9 + d10);
        }
    }

    public void getInputs(){ // Get inputs from user
        System.out.print("Enter the first 9 digits of an ISBN as integer: "); // Prompt user for ISNB9
        ISBN9 = scanner.next(); // User input is ISBN9
        d1 = Character.getNumericValue(ISBN9.charAt(0)); // Store each character as digit, cast as integer
        d2 = Character.getNumericValue(ISBN9.charAt(1));
        d3 = Character.getNumericValue(ISBN9.charAt(2));
        d4 = Character.getNumericValue(ISBN9.charAt(3));
        d5 = Character.getNumericValue(ISBN9.charAt(4));
        d6 = Character.getNumericValue(ISBN9.charAt(5));
        d7 = Character.getNumericValue(ISBN9.charAt(6));
        d8 = Character.getNumericValue(ISBN9.charAt(7));
        d9 = Character.getNumericValue(ISBN9.charAt(8));
        scanner.close(); // Close scanner
    }

    public static void main(String[] args){ // Main function
        bookCheck myObj = new bookCheck(); // New object for bookcheck
        myObj.getInputs(); // Get inputs
        myObj.determineNumber(); // Use inputs to determine final digit
    }
}