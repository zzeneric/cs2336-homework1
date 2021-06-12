// Raghav Pillai, 6/10/21

import java.util.Scanner; // Import scanner for input

public class rectangleIntersect{
    class Rectangle{ // Rectangle class to store rectangle information
        double height, width, centerX, centerY; // Values for each rectangle
        double[] bottomLeft, bottomRight, topLeft, topRight; // Array of double values (x and y as 0 and 1)

        public void checkCorners(){ // X = [0], Y = [1]
            double blx = centerX - (width/2);
            double bly = centerY - (height/2);
            bottomLeft = new double[]{blx,bly}; // Bottom left array

            double brx = centerX + (width/2);
            double bry = centerY - (height/2);
            bottomRight = new double[]{brx,bry}; // Bottom right array

            double tlx = centerX - (width/2);
            double tly = centerY + (height/2);
            topLeft = new double[]{tlx,tly}; // Top left array

            double trx = centerX + (width/2);
            double ttry = centerY + (height/2); // Need ttry because try is a thing
            topRight = new double[]{trx,ttry}; // Top right array
        }
    }
    
    Scanner scanner = new Scanner(System.in); // Input scanner
    Rectangle RectangleA = new Rectangle(); // Rectangle A
    Rectangle RectangleB = new Rectangle(); // Rectangle B

    public void checkIntersects(){ // Check intersects for each rectangle
        if(RectangleA.topRight[0] == RectangleB.topRight[0] && RectangleA.topLeft[0] == RectangleB.topLeft[0] 
        && RectangleA.topLeft[1] == RectangleB.topLeft[1] && RectangleA.bottomLeft[1] == RectangleB.bottomLeft[1]) { // Identical
            System.out.print("r1 and r2 are indentical");
        }else if (RectangleA.topRight[0] <= RectangleB.topRight[0] && RectangleA.topLeft[0] >= RectangleB.topLeft[0] 
        && RectangleA.topLeft[1] <= RectangleB.topLeft[1] && RectangleA.bottomLeft[1] >= RectangleB.bottomLeft[1]) { // R1 is in R2
            System.out.print("r1 is inside r2");
        }else if (RectangleB.topRight[0] <= RectangleA.topRight[0] && RectangleB.topLeft[0] >= RectangleA.topLeft[0] 
        && RectangleB.topLeft[1] <= RectangleA.topLeft[1] && RectangleB.bottomLeft[1] >= RectangleA.bottomLeft[1]) { // R2 is in R1
            System.out.print("r2 is inside r1");
        }else if (RectangleA.topRight[0] < RectangleB.topLeft[0] || RectangleA.topLeft[0] > RectangleB.topRight[0] 
        || RectangleA.topLeft[1] < RectangleB.bottomLeft[1] || RectangleB.bottomLeft[1] > RectangleA.topLeft[1]) { // Overlap
            System.out.print("r2 does not overlaps r1");
        }else{
            System.out.print("r2 overlaps r1");
        }
    }
    
    public void getInputs(){ // Retrieve user inputs
        String r1Input; // String holders for user inputs
        String r2Input;

        System.out.print("Enter r1's center x-, y-coordinates, width and height: "); // Get r1 inputs
        r1Input = scanner.nextLine(); // Get next line to use as input
        String[] r1Inputs = r1Input.split(" "); // Split line by spaces to array
        RectangleA.centerX = Double.parseDouble(r1Inputs[0]); // Store r1 inputs into the rectangle object
        RectangleA.centerY = Double.parseDouble(r1Inputs[1]);
        RectangleA.height = Double.parseDouble(r1Inputs[2]);
        RectangleA.width = Double.parseDouble(r1Inputs[3]);
        RectangleA.checkCorners(); // Check corner points by inputted values

        System.out.print("Enter r2's center x-, y-coordinates, width and height: ");
        r2Input = scanner.nextLine(); // Get next line to use as input
        String[] r2Inputs = r2Input.split(" "); // Split line by spaces to array
        RectangleB.centerX = Double.parseDouble(r2Inputs[0]); // Store r2 inputs into the rectangle object
        RectangleB.centerY = Double.parseDouble(r2Inputs[1]);
        RectangleB.height = Double.parseDouble(r2Inputs[2]);
        RectangleB.width = Double.parseDouble(r2Inputs[3]);
        RectangleB.checkCorners(); // Check corner points by inputted values
    }
    
    public static void main(String[] args){ // Main function
        rectangleIntersect myObj = new rectangleIntersect(); // Create rectangleintersect object
        myObj.getInputs();
        myObj.checkIntersects();
    }
}