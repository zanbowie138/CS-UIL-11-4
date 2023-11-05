import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class Archimedes {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("archimedes.dat"));
        // int lines = Integer.parseInt(s.nextLine());
        while(s.hasNext()) {
            double r = Double.parseDouble(s.nextLine());
            double v = (4.0/3.0) * Math.PI * Math.pow(r, 3);
            double c = Math.PI * Math.pow(r, 2) * 2*r;
            System.out.println(String.format("Radius = %.1f, Sphere Vol = %.2f, Cylinder Vol = %.2f", r, v, c));
        }
    }
}