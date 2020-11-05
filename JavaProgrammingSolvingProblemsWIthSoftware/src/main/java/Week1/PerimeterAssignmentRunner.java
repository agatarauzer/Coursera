package Week1;

import Week1.predefinedClasses.DirectoryResource;
import Week1.predefinedClasses.FileResource;
import Week1.predefinedClasses.Point;
import Week1.predefinedClasses.Shape;

import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s){
        double totalPerim = 0.0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            totalPerim = totalPerim + currDist;
            prevPt = currPt;
        }
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int sum = 0;
        for (Point p : s.getPoints()) {
            sum++;
        }
        return sum;
    }

    public double getAverageLength(Shape s) {
        return getPerimeter(s) / getNumPoints(s);
    }

    public double getLargestSide(Shape s) {
        double largest = 0;
        Point prevPt = s.getLastPoint();
        for (Point currPt : s.getPoints()) {
            double currDist = prevPt.distance(currPt);
            if (currDist > largest) {
                largest = currDist;
            }
            prevPt = currPt;
        }
        return largest;
    }

    public double getLargestX(Shape s) {
        Point prevPt = s.getLastPoint();
        double largestX = prevPt.getX();
        for (Point currPt : s.getPoints()) {
            double currX = currPt.getX();
            if (currX > largestX) {
                largestX = currX;
            }
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        DirectoryResource dr = new DirectoryResource();
        double maxPer = 0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPer = getPerimeter(s);
            if (currPer > maxPer) {
                maxPer = currPer;
            }
        }
        return maxPer;
    }

    public String getFileWithLargestPerimeter() {
        DirectoryResource dr = new DirectoryResource();
        String fileName = "";
        double maxPer = 0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            Shape s = new Shape(fr);
            double currPer = getPerimeter(s);
            if (currPer > maxPer) {
                maxPer = currPer;
                fileName = f.getName();
            }
        }
        return fileName;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numPoints = getNumPoints(s);
        double averageLength = getAverageLength(s);
        double largestSide = getLargestSide(s);
        double largestX = getLargestX(s);

        System.out.println("perimeter = "  + length);
        System.out.println("number of points = "  + numPoints);
        System.out.println("average length of sides = "  + averageLength);
        System.out.println("largest side = "  + largestSide);
        System.out.println("largest X = "  + largestX);
    }

    public void testPerimeterMultipleFiles() {
        double maxPer = getLargestPerimeterMultipleFiles();
        System.out.println("largest perimeter of files" + maxPer);
    }

    public void testFileWithLargestPerimeter() {
        String fileName = getFileWithLargestPerimeter();
        System.out.println("file with largest perimeter  " + fileName);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+ peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
        pr.testFileWithLargestPerimeter();
    }
}
