import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class Numbers {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("numbers.dat"));
        int lines = Integer.parseInt(s.nextLine());
        for (int l = 0; l < lines; l++) {
            System.out.println();
        }
    }
}