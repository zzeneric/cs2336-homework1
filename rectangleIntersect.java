import java.util.Scanner;

public class rectangleIntersect{
    class Rectangle{ // Rectangle class to store rectangle information
        double height, width, centerX, centerY;
        double[] bottomLeft, bottomRight, topLeft, topRight;

        public void checkCorners(){ // X = [0], Y = [1]
            double blx = centerX - (width/2);
            double bly = centerY - (height/2);
            bottomLeft = new double[]{blx,bly};

            double brx = centerX + (width/2);
            double bry = centerY - (height/2);
            bottomRight = new double[]{brx,bry};

            double tlx = centerX - (width/2);
            double tly = centerY + (height/2);
            topLeft = new double[]{tlx,tly};

            double trx = centerX + (width/2);
            double ttry = centerY + (height/2); // Need ttry because try is a thing
            topRight = new double[]{trx,ttry};
        }
    }
    
    Scanner scanner = new Scanner(System.in);
    Rectangle RectangleA = new Rectangle();
    Rectangle RectangleB = new Rectangle();

    public void checkIntersects(){
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
    
    public void getInputs(){
        String r1Input;
        String r2Input;

        System.out.print("Enter r1's center x-, y-coordinates, width and height: ");
        r1Input = scanner.nextLine();
        String[] r1Inputs = r1Input.split(" ");
        RectangleA.centerX = Double.parseDouble(r1Inputs[0]);
        RectangleA.centerY = Double.parseDouble(r1Inputs[1]);
        RectangleA.height = Double.parseDouble(r1Inputs[2]);
        RectangleA.width = Double.parseDouble(r1Inputs[3]);
        RectangleA.checkCorners();

        System.out.print("Enter r2's center x-, y-coordinates, width and height: ");
        r2Input = scanner.nextLine();
        String[] r2Inputs = r2Input.split(" ");
        RectangleB.centerX = Double.parseDouble(r2Inputs[0]);
        RectangleB.centerY = Double.parseDouble(r2Inputs[1]);
        RectangleB.height = Double.parseDouble(r2Inputs[2]);
        RectangleB.width = Double.parseDouble(r2Inputs[3]);
        RectangleB.checkCorners();
    }
    
    public static void main(String[] args){
        rectangleIntersect myObj = new rectangleIntersect();
        myObj.getInputs();
        myObj.checkIntersects();
    }
}