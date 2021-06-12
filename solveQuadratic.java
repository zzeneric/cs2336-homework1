// Raghav Pillai, 6/10/21
// Program that inputs 3 numbers and determines the roots if they are in a quadratic equation

import java.util.Scanner; // Import scanner for input

public class solveQuadratic{ // Public class to solve quadratic, object
    Scanner scanner = new Scanner(System.in); // Initialize scanner
    double A, B, C; // Different numbers for quadratic

    public void askInput(){ // Prompt user for input
        System.out.print("Enter a, b, c: ");
        String userInput = scanner.nextLine(); // Next scanner line
        String[] nums = userInput.split(" "); // Split input by spaces from 'a b c' to table of 3 strings

        A = Double.parseDouble(nums[0]); // Convert strings to double
        B = Double.parseDouble(nums[1]);
        C = Double.parseDouble(nums[2]);
        scanner.close(); // Close scanner to prevent memory leak
    }

    public void checkRoots(){ // Check roots and output values
        double disc = (Math.pow(B,2)) - (4*A*C); // Discriminant value
        if(disc>0){ // If 2 roots
            double rootA = (-B + Math.pow(disc, 0.5)) / (2.0 * A); // Calculate +
            double rootB = (-B - Math.pow(disc, 0.5)) / (2.0 * A);  // Calculate - 
            System.out.println("The equation has two roots " + rootA + " and " + rootB);
        }else if(disc == 0){ // If 1 root 
            double rootA = (-B - Math.pow(disc, 0.5)) / (2.0 * A);  // Calculate singular root
            System.out.println("The equation has one root " + rootA);
        }else{ // If no roots
            System.out.println("The equation has no real roots.");
        }
    }

    public static void main(String[] args){ // Main function
        solveQuadratic myObj = new solveQuadratic(); // New object
        myObj.askInput(); // Get inputs and store in object
        myObj.checkRoots(); // Check roots from input objects
    }
}